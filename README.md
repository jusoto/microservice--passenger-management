Check MySQL root and username and password on file:
   src/main/resources/application.properties
   
Create DB on MySQL:
   passengermanagementdb

To build the microservice run command on root directory of the project:
   ./gradlew clean build bootRun
   
Test http://localhost:8081/api/passengers -GET