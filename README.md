# AppiumAndroidDeployment
A project, to be able to deploy an app to multiple connected Android devices and launch the application.

#Setup
This code is designed to run on a mac, I am not sure if it will run on a Windows machine. 
This code has hardcoded paths in it, these are to the Appium app contents, so you will need to install the Appium app. http://appium.io/
As it's Appium and Android, you will also need to have ADB installed.
Ensure to change the apk file path in the DriverFactory to your apk.

#Run
Then simply connect some Android devices to your laptop and run the test that's in AppDeployment class. 
(I know it's not a test, but I find it easier to use Test Framework to run code, then creating executable programs)


