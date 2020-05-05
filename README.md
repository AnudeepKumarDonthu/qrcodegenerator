# qrcodegenerator

Java Version : 1.11

Spring Boot Version : 2.1.12.RELEASE

Simple Application which is developed using Springboot and Angularjs

It contain 3 Simple APIs

1) Health API --> localhost:9091/ping --> Return a String Message as "I am Available" stating that Application is Running Successfully

2) Home Page API --> localhost:9091/home --> Which will open a html Page in browser developed using AngularJS,html,css,bootstrap

3) QR Code Generate API --> localhost:9091/generateqr --> Which will triggerd by UI upon clicking on "Generate QR Button" in UI (This is a POST REST call can be integrated with anything)

Home Page:
-----------
https://github.com/AnudeepKumarDonthu/qrcodegenerator/blob/master/homescreen.JPG

Instruction to Use The Application
-----------------------------------
1) Download and Install java version 1.11 from official oracle website https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
Note : Check the latest Oracle JDK License policies
2) Check out the code
3) update application.properties file with your email ID and password used to send email to the QR code recipient
4) To make Application to access GmailID via less secure app or device, we need to enable "Less secure app access" in your gmail account settings under Security Section by clicking on Manage your google account option upon clicking on top right corner profile icon.
5) Run as a SpringBoot or Java Application from Eclipse or directly run the jar file upon maven install from command window
   