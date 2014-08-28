<%--
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
--%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
  <%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
    <jsp:useBean class="java.lang.String" id="addLocationURL" scope="request" />
    <jsp:useBean class="java.lang.String" id="resName" scope="request" />
     <jsp:useBean class="java.lang.String" id="resLocation" scope="request" />
      <jsp:useBean class="java.lang.String" id="receiverEmailAddress" scope="request" />
   	      <jsp:useBean class="java.lang.String" id="emailBodyTempl" scope="request" />
   		<jsp:useBean class="java.lang.String" id="emailSubjTempl" scope="request" />	
    
<portlet:defineObjects />
<aui:form
id="form"
method="post"
action="<%=addLocationURL %>"
>

<aui:input name="caseStudyName" label="Resource Name" value="<%=resName %>">
	<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
	</aui:input>

<aui:input name="addLocation" label="Resource Link Address" value="<%=resLocation %>">
	<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
	</aui:input>
	
<aui:fieldset label="Email Settings And Configurations">

<aui:input name="receiverEmailAddress" label="Receiver Email Address" value="<%=receiverEmailAddress %>">
	<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
	<aui:validator name="email"/>
</aui:input>

<aui:input type="textarea" name="emailSubject" label="Email Subject Content" value="<%=emailSubjTempl%>">
<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
</aui:input>
<h4>Definition Of Terms for Email Subject</h4>
<dl>
<dt>[$VISITOR_NAME$]</dt>
<dd>Name of the Visitor who downloads the resource</dd>
<dt>[$CASE_STUDY_NAME$]</dt>
<dd>Name of the Downloaded Resource</dd>
</dl>
<aui:input type="textarea" name="emailTemplate" label="Email Body Content" value="<%=emailBodyTempl %>" >
<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
</aui:input>


</aui:fieldset>


<h4>Definition of Terms for Email Body</h4>
<dl>
<dt>[$VISITOR_NAME$]</dt>
<dd>Name of the Visitor who downloads the resource</dd>
<dt>[$COMPANY_NAME$]</dt>
<dd>Name of the company of which the Visitor is a Employee</dd>
<dt>[$EMAIL_ADDRESS$]</dt>
<dd>Email Address of the Employee</dd>
<dt>[$COMMENTS$]</dt>
<dd>Comments By The Employee</dd>
<dt>[$PHONE_NUMBER$]</dt>
<dd>Phone Number Of The Visitor</dd>
<dt>[$CASE_STUDY_NAME$]</dt>
<dd>Name of the Downloaded Resource</dd>
</dl>


<aui:button name="submitButton" type="submit" value="Save" last="true" />
</aui:form>
