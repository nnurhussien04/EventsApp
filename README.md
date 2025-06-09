# EventsApp

This is an app where users are able to see events in their area planned by the community business, and if they are interested, they can sign up for the event and add it to their calendar. The staff members are able to create, edit, and delete events if they are no longer running. The idea of this app is to allow community members to be aware of events that are taking place in their town and for staff to display and manage the events they are planning to host.

The tech stack that is being used here is as follows:

Java

Spring Boot

Android Studio

IntelliJ

PostgreSQL

How to run the application:

Install both the frontend and the backend branches onto your device.

If successful, run the backend using an IDE (e.g., IntelliJ, Eclipse) and preferably a VM — make sure it works by running this link on your browser or Postman: http://localhost:8080/Event

If the link displays JSON and some key-value pairs including name, id, description, etc., this means the API is working.

Try to get the IP address of your system. Depending on your OS, the steps will differ, so do some research on this before the next step.

Once done, open the frontend with Android Studio and go to the following file: app/src/main/java/com/northcoders/eventapp/service/RetrofitInstance.java

Go to line 14 in the code and replace the IP address listed there with your own.

After that, you should run the application, and it should work.

Key Note: Staff login is username: YM, password: StaffRole
Key Note: Both the backend and the frontend should be running at the same time; otherwise, the application will not work.
