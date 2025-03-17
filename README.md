this project is named as QuizApp
in this :
techStack use:
Java 23
Spring Boot
Hibernate & JPA (for database operations)
IntelliJ IDEA 

Features
✔️ Fetch questions from the database
✔️ Generate random quizzes
✔️ Submit quiz responses and calculate scores
✔️ Simple REST API for handling quiz operations

quizapp/
│── src/main/java/com/example/quizapp/
│   ├── controller/          # Handles API endpoints
│   │   ├── QuizController.java
│   │   ├── QuestionController.java
│   ├── model/               # Entity classes (Question, Response)
│   ├── repository/          # Database interactions (JPA/Hibernate)
│   ├── service/             # Business logic for quiz generation
│── src/main/resources/      # Application properties & static files
│── pom.xml                  # Project dependencies (Maven)
│── README.md                # Documentation


Access the API

Quiz Endpoints: http://localhost:8080/quiz
Questions Endpoints: http://localhost:8080/questions

Future Improvements
Add user authentication
Implement a frontend with React/Angular
Store quiz history
