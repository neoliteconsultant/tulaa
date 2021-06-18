# About
A Spring Boot web service that exposes a function to reverse a string while preserving the position of 
special characters.



### Prerequisites

Before running this application, ensure you have installed and configured
the following tools

- JDK 1.8 or above.
  Ensure JAVA_HOME environment variable is set and points to your JDK installation.
- Maven 3.3.9 or later. Maven is a build automation tool for Java. Read more at (https://maven.apache.org/)



### Running the project     

1. To run the project, navigate to the project root (quiz-ws).

   
2. Build an executable jar at the command line :
   ```
   $ mvn package
   ```


3. Run the application:
   ```
   $  java -jar target/quiz-ws-1.0.0.jar
   ```


### Calling API Endpoints

Now that the service is up, make a HTTP POST to reverse a string.

``` 
$ curl -X POST http://localhost:8097/api/v1/quiz/reversetext -H "Content-Type: application/json"  -d '{"content":"a,b#@c"}'
```



### Testing
To run unit tests, run mvn test in a shell/command line from the project root.
  ```
  $ mvn test
  ```
 
 

### Javadoc 
To generate javadocs, run mvn javadoc:javadoc goal in a shell from the project root.
  ```
  $ mvn javadoc:javadoc
  ```

The generated javadoc is located in target/site/apidocs
  


