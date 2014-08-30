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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<jsp:useBean class="java.lang.String" id="sendEmail" scope="request" />
<portlet:defineObjects />
<portlet:resourceURL var="formActionURL" id="formActionURL"/>
<aui:form
name="userForm"
id="form" 
method="post"
action="<%=formActionURL %>"
onSubmit="javascript:calledAfterSubmit();"
>
	<aui:fieldset label="Visitor Details">
	<aui:input name="visitorName" label="Name">
	<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
	</aui:input>
	
	<aui:input name="companyName" label="Company Name"/>

	<aui:input name="emailAddress" label="Email">
	<aui:validator name="required" errorMessage="Cannot Be Left Blank"/>
	<aui:validator name="email"/>
	</aui:input>

	<aui:input name="phoneNumber" label="Phone Number">
	<aui:validator name="number"/>
	</aui:input>
	<aui:input name="comments" type="textarea" label="comments"/>
	
	<aui:button name="submitButton" type="submit"  value="Download" last="true" />
	</aui:fieldset>
</aui:form>

<div id="afterForm" style="display:none">
Thanks For Your Interest in Resource Download.Resource will be Downloaded Shortly.Click on the Back Button if any problems or Trouble Shooting
<br/>
<aui:button name="backButton" type="Back" id="backButton"  value="Back"/>
</div>

<aui:script use="aui-base,aui-form-validator">

window.calledAfterSubmit=function(){
A.one('#<portlet:namespace />userForm').hide();
A.one('#afterForm').show();
}

A.one('#<portlet:namespace />backButton').on('click',function(){
A.one('#<portlet:namespace />userForm').show();
A.one('#afterForm').hide();
});
</aui:script>
