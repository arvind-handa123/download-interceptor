/**
 * Copyright (c) 2014 KNOWARTH Technologies Pvt. Ltd. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.knowarth.portlet.downloadinterceptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.portlet.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
* @author :Parth Ghiya
*/
public class DownloadInterceptorPortlet extends MVCPortlet {
	protected String editJSP;
	protected String viewJSP;
	private static Log _log=LogFactory.getLog(DownloadInterceptorPortlet.class);

	public void init(){
		editJSP=getInitParameter("edit-template");
		viewJSP=getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest,RenderResponse renderResponse) throws PortletException, IOException{
		ResourceURL sendEmail=renderResponse.createResourceURL();
		String resourceUrl=sendEmail.toString();
		renderRequest.setAttribute("resourceUrl", resourceUrl);
		include(viewJSP, renderRequest, renderResponse);

	}

	public void doEdit(RenderRequest renderRequest,RenderResponse renderResponse) throws PortletException, IOException{
		renderResponse.setContentType("text/html");
		PortletURL addLocationURL=renderResponse.createActionURL();
		//Getting values from preferences
		PortletPreferences prefs=renderRequest.getPreferences();
		String resourceLocation=prefs.getValue("resourceurl", "");
		String resourceName=prefs.getValue("caseStudyName", "");
		String receiverEmailAdd=prefs.getValue("receiverEmailAdd","");
		String emailBodyTempl=prefs.getValue("emailBodyTemplate","");
		String emailSubjectTemplate=prefs.getValue("emailSubjectTemplate", "");
		String resExtension=prefs.getValue("ResourceExtension","");
		if(resExtension.equalsIgnoreCase("")){
			resExtension="";
		}
		if(resourceLocation.equalsIgnoreCase("")){
			resourceLocation="";
		}
		if(resourceName.equalsIgnoreCase("")){
			resourceName="";
		}
		if(receiverEmailAdd.equalsIgnoreCase("")){
			receiverEmailAdd="";
		}
		if(emailBodyTempl.equalsIgnoreCase("")){
			emailBodyTempl="";
		}
		if(emailSubjectTemplate.equalsIgnoreCase("")){
			emailSubjectTemplate="";
		}
		renderRequest.setAttribute("resLocation",resourceLocation);
		renderRequest.setAttribute("resName", resourceName);
		renderRequest.setAttribute("receiverEmailAddress", receiverEmailAdd);
		renderRequest.setAttribute("addLocationURL", addLocationURL.toString());
		renderRequest.setAttribute("emailBodyTempl",emailBodyTempl);
		renderRequest.setAttribute("emailSubjTempl", emailSubjectTemplate);
		renderRequest.setAttribute("resourceExtension", resExtension);
		include(editJSP, renderRequest, renderResponse);
	}
	protected void include(String path,RenderRequest renderRequest,RenderResponse renderResponse) throws PortletException, IOException{
		PortletRequestDispatcher portletRequestDispatcher=getPortletContext().getRequestDispatcher(path);
		if(portletRequestDispatcher==null){
			_log.error(path+"is not a valid include");	
		}
		else{
			portletRequestDispatcher.include(renderRequest,renderResponse);
		}
	}
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException{
		//Setting out email parameters
		String emailAdd=resourceRequest.getParameter("emailAddress");
		String visitorName=resourceRequest.getParameter("visitorName");
		String cmpName=resourceRequest.getParameter("companyName");
		String phoneNumber=resourceRequest.getParameter("phoneNumber");
		String comments=resourceRequest.getParameter("comments");

		//Getting the preferences and reading URL Location reading from edit mode
		PortletPreferences prefs=resourceRequest.getPreferences();
		String resourceurl=prefs.getValue("resourceurl", "");
		String caseStudyName=prefs.getValue("caseStudyName", "");
		String receiveEmailAdd=prefs.getValue("receiverEmailAdd","");
		//emailBodyContent Return the template stored in preferences edit mode.
		String emailBodyContent=prefs.getValue("emailBodyTemplate", "");
		String emailsubj=prefs.getValue("emailSubjectTemplate","");
		String resExtension=prefs.getValue("ResourceExtension","");
		String body=StringUtil.replace(emailBodyContent, 
				new String[]{"[$VISITOR_NAME$]","[$COMPANY_NAME$]","[$EMAIL_ADDRESS$]","[$PHONE_NUMBER$]","[$COMMENTS$]","[$CASE_STUDY_NAME$]"},
				new String[]{visitorName,cmpName,emailAdd,phoneNumber,comments,caseStudyName} 
				);


		//Setting out body and email parameters
		String subject=StringUtil.replace(emailsubj,
				new String[]{"[$VISITOR_NAME$]","[$CASE_STUDY_NAME$]"},
				new String[]{visitorName,caseStudyName});
		//code for sending email
		try {
			InternetAddress fromAddress=new InternetAddress(emailAdd);
			InternetAddress toAddress=new InternetAddress(receiveEmailAdd);

			MailMessage mailMessage=new MailMessage(fromAddress,toAddress,subject,body,true);
			MailServiceUtil.sendEmail(mailMessage);

		} catch (AddressException e) {
			// TODO Auto-generated catch block
			_log.error("Error Sending Message",e);
		}
		finally{
			//For Downloading a resource
			
			String contentDisposition = "attachment; filename=" + caseStudyName+"."+resExtension;
			OutputStream out=resourceResponse.getPortletOutputStream();
		
			//LInk for resource URL Goes here. Uncomment it out for dynamic location and comment out the static link
			URL url = new URL(resourceurl);
			URLConnection conn = url.openConnection();
			resourceResponse.setContentType(conn.getContentType());
			resourceResponse.setContentLength(conn.getContentLength());
			resourceResponse.setCharacterEncoding(conn.getContentEncoding());
			resourceResponse.setProperty(HttpHeaders.CONTENT_DISPOSITION, contentDisposition);				
			resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600");

			
			// open the stream and put it into BufferedReader
			InputStream stream = conn.getInputStream();
			int c;
			while((c=stream.read())!=-1){
				out.write(c);
			}
			out.flush();
			out.close();
			stream.close();	

		}

	}

	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletModeException, ReadOnlyException, ValidatorException, IOException{
		String addLocation=actionRequest.getParameter("addLocation");
		String caseStudyName=actionRequest.getParameter("caseStudyName");
		String receiverEmailAddress=actionRequest.getParameter("receiverEmailAddress");
		String emailBody=actionRequest.getParameter("emailTemplate");
		String emailSubj=actionRequest.getParameter("emailSubject");
		String resourceExt=actionRequest.getParameter("resourceExtension");
		if(addLocation!=null && caseStudyName!=null && receiverEmailAddress!=null && emailBody!=null && resourceExt!=null)
		{
			PortletPreferences prefs=actionRequest.getPreferences();
			prefs.setValue("resourceurl",addLocation);
			prefs.setValue("caseStudyName", caseStudyName);
			prefs.setValue("receiverEmailAdd",receiverEmailAddress);
			prefs.setValue("emailBodyTemplate", emailBody);
			prefs.setValue("emailSubjectTemplate", emailSubj);
			prefs.setValue("ResourceExtension", resourceExt);
			prefs.store();

		}
		actionResponse.setPortletMode(PortletMode.VIEW);
	}

}
