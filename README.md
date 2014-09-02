Download Interceptor
=========

It is very common requirement for any portal to allow user to download a case study, a document or any other resource. Many times it is equally or more important for an organization to gather user data before allowing the user to download any resource. Download Interceptor portlet gathers user’s information and email it to configured email address before allowing the user to download the file. It allows admin of the portal to fill a form regarding information of the download resource such as the link from documents and media, the extension, the reciptent email address of the user, the body and the subject of the email address. All guest users would fill up the form and then able to download the resource. Download Interceptor can be added to any page. Once available on any page any link for resource url can be set corresponding to the page.


How to Use Theme Personalizer (Liferay 6.1.x CE)
---------
1. Install Download Interceptor war file on Liferay Portal.
2. Sign In as Portal admin and navigate to Knowarth Technologies Category of the portlets.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.1/category.png)
3. Now Add Download Interceptor Portlet on your required page and go to Preferences. preferencesportlet.png
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.1/preferencesportlet.png)
4. Fill up the preferences as per need. go to documents and media to get the URL of the resource which we want the user to download.Fill this url in resource URL in preference mode.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.1/doc&lib.png)
5.Enter email settings configuration and save the preferences.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.1/preferencesemail.png)
6.A guest user wont be able to access the preferences, he would fill the form and get access to the download resource.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.1/user_download.png)

How to Use Theme Personalizer (Liferay 6.2.x CE)
---------
1. Install Download Interceptor war file on Liferay Portal.
2. Sign In as Portal admin and navigate to Knowarth Technologies Category of the portlets.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/adding_portlet.png)
3. Now Add Download Interceptor Portlet on your required page and go to Preferences
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/portlet_preferences.png)
4. Fill up the preferences as per need. go to documents and media to get the URL of the resource which we want the user to download
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/URLFromDocumentsAndMedia.png)
5. After Getting the URL, fill up the email settings form. The preferences form looks like this.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/preferences_1.png)
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/preferences_email.png)
6. When A User views he wont be able to see the preferences, he would be able to fill the form and download the resouce.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/user_form_Fill.png)
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/user_Download_resource.png)

Things to Remember
------
Make Sure you have the following things setup.

-Your Mail Server is Setup.
Go to Admin->Control Panel->Server Administration->Mail and fill up the settings.
![ScreenShot](https://raw.githubusercontent.com/knowarth-technologies/download-interceptor/master/screenshots/liferay-6.2/mail_Configuration.png) 
- Documents Are Setup in Documents Library
- You Copy valid URL from the document library as resourceURL
If mail Server is not setup, a visitor would be able to download the resource but its details wont be sent to the configured email address.If Valid URL are not provided then a visitor wont be able to downlaod the corresponding resource. Each Document has to be stored in the Documents and the media portlet. By Default Only admin can configure the parameters in Portlet's preferences.

Version 1.0.0
----

Here are some of the key features of the plugin included in this version.

- A User form to be filled by the visitor[NOT Customizable].
- A form in the preferences where a portlet admin can configure settings like Resource Name, Resource URL, Resource extension.
- Further portlet admin can configure the email address which will receive the user details, the email body & the email subject.
- Variables are provided alongside which helps in configuring the mail templates for subject and body.
- This version is compitible with Liferay Portal 6.1.x CE & 6.2.X CE.


Support
------
Please feel free to contact us on contact@knowarth.com for any issue/suggestions.You can report issues through [Github issues] (https://github.com/knowarth-technologies/download-interceptor/issues "Github Issues")
