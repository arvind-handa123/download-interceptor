Download Interceptor
=========

It is very common and quite needed requirement for any network to allow users to download a resource, as well as collect the information of the user via email. Download Interceptor is a portlet which fullfills both functionalities. It allows admin of the portal to fill a form regarding information of the download resource such as the link from documents and media, the extension, the reciptent email address of the user, the body and the subject of the email address. All guest users would fill up the form and then able to download the resource. Download Interceptor can be added to any page. Once available on any page any link for resource url can be set corresponding to the page.


How to Use Theme Personalizer (Liferay 6.1.x CE)
---------

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
- If there is no color scheme in a theme then Color Scheme dropdown will be blank. User can just choose Theme and apply it on the page.
- User can apply theme to all the pages and then go to individual page and override it through theme personalizer portlet on that page.
- The portlet will be automatically made hidden for Guest users.
- If available themes are not configured by Portal admin then theme personalizer portlet will only display a message.

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