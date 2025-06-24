# EventsApp

This is an app where users are able to see events in their area planned by the community business, and if they are interested, they can sign up for the event and add it to their calendar. The staff members are able to create, edit, and delete events if they are no longer running. The idea of this app is to allow community members to be aware of events that are taking place in their town and for staff to display and manage the events they are planning to host.

## Tech Stack:
- Java
- Spring Boot
- Android Studio
- IntelliJ
- PostgreSQL

### Requirements
- Java 17 or later (Java 21 recommended)
- Maven
- Android Studio (latest)
- Internet connection (to access the hosted backend and database)

### How to run the android app:
1. Install android studio on your device - this can be done by using the following link: https://developer.android.com/studio?gad_source=1&gad_campaignid=21831783762&gbraid=0AAAAAC-IOZlXwfJpb3OsE4V21tqBCG_vj&gclid=CjwKCAjwmenCBhA4EiwAtVjzmkLLQruHMeePapfPYUhKSR7C5E1GwK4oDFOyJ1IfOvmxYIbsjKZjfBoCsgwQAvD_BwE&gclsrc=aw.ds
2. Download the frontend branch in GitHub, once done unzip the files from your downloads and open it using android studio
3. Run the application from android studio and it should display a login page on the virtual machine 

### How to run backend application on IDE:
1. Download the backend branch from GitHub and unzip the download
2. Ensure Java 17 or later is installed (Java 21 is recommended), and             all Maven dependencies are downloaded using mvn clean install.
3. Run the backend using an IDE (e.g., IntelliJ, Eclipse) or preferably a VM — make sure it works by running this link on your browser or Postman http://localhost:8080/Event
4. If the link displays JSON and some key-value pairs name, id, description, etc., this means the API is working.


### How to run backend application on Maven:
1. Download the backend branch from GitHub and unzip the download
2. Download Maven on your device using this link: https://maven.apache.org/download.cgi
3. Open command prompt and change the file location to the backend branch using this command “cd file-location”
4. Once that’s done run this command  mvn clean install -X .
5. If the install is successful, run this command “mvn spring-boot:run”
6. The spring boot server should be up and running, check by running this link on your browser or Postman: http://localhost:8080/Event
7. If the link displays JSON and some key-value pairs name, id, description, etc., this means the API is working.


### Backend API hosted here
https://eventsapp-utqb.onrender.com/

### Backend API Documentation 
https://eventsapp-utqb.onrender.com/swagger-ui/index.html

<br/>

>[!NOTE]
>Staff login is username: YM, password: StaffRole

