# Project5Quiz

**A program for a student-teacher quiz managment system**

To run the file, you need a **UsersInfo.txt file in the root directory**. 

** Run Server then run Client**

Class AnsweredQuestion

• Constructor AnsweredQuestion assigns values to variables question, answer and correct. 
• getQuestion returns the value of question 
• getAnswer returns the value of answer 
• isCorrect returns the value of correct variable 
• toString checks whether the question is right or wrong and returns the question, what the student answered and whether
it is right or wrong.
This class gets the answer for the question and tests whether it is correct.

Class ChooseQuestionTypeScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks which type pf action you want to perform and displays the respective screen 
accordingly.
This class is to choose and display the type of the question.

Class Client

This class has one main method used to create objects for inout and output operations 
throughout the project.

Class Course

• Constructor assigns values to courseName, courseNumber and quizzes variables. 
• getQuizzes() returns the value of quizzes. 
• setQuizzes() sets the value of quizzes. 
• getCourseName() returns the value of quizzes. 
• setCourseName() sets the value of quizzes. 
• getCourseNumber() returns the value of quizzes. 
• setCourseNumber() sets the value of quizzes. 
• toString() returns a string containing a list of quizzes in the course. 
• equals(Object o) returns a boolean value for when all our inputs are valid 
• getQuiz() returns the number of quiz user wants. 
• removeQuiz() removes the quiz user wants. 
• addQuiz() adds the quiz user wants. 
• getQuizCount() returns the size of the variable quizzes. 
This class gets the quiz from class Quiz and stores it in a specific course.

Class CourseEditsOptionScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks which type of action you want to perform and displays the respective screen
accordingly.
This class helps you perform operations like logout, login, reset name and password, make, delete and edit 
quizzes.

Class CreateCourseScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks which type of action you want to perform and displays the respective screen
accordingly.
This class performs functions to make a course.

Class CreateFBquestionScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks whether you want to make a question and displays the fill in the blank question screen.
This class performs functions to make a fill in the blank question and display it.

Class CreateMCquestionScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks whether you want to make a question and displays the multiple choice question screen.
This class performs functions to make a multiple choice question and display it.

Class CreateQuizScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks whether you have made a course and displays a screen to create a quiz.
This class performs functions to make a quiz.

Class CreateTFquestionScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks whether you want to make a question and displays the True or False question screen.
This class performs functions to make a True or False question and display it.

CLass FillBlankQuestion extends Question implements Serializable

• Constructor assigns value to answer and question.
• check returns true or false based on whether the student's answer matches the correct answer.
• equals(Object o) returns a boolean value for when all our inputs are valid
• getAnswer() returns the answer and the check method.
This class is a sub class of Question and formats the question to be a Fill in the Blank question.

Class LoginScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks which type of action you want to perform and displays the respective screen
accordingly.
This class performs actions like login, singing as a student or teacher, showing password and reset.

Class MCquestion extends Question implements Serializable

• Constructor assigns value to answer and question. 
• check returns true or false based on whether the student's answer matches the correct answer. 
• getChoiceA returns the value of choiceA 
• getChoiceB returns the value of choiceB 
• getChoiceC returns the value of choiceC 
• getChoiceD returns the value of choiceD 
• setChoiceA accepts choice A and sets it to choiceA variable. 
• setChoiceB accepts choice B and sets it to choiceB variable. 
• setChoiceC accepts choice C and sets it to choiceC variable. 
• setChoiceD accepts choice D and sets it to choiceD variable. 
• equals(Object o) returns a boolean value for when all our inputs are valid 
• getAnswer() accepts a number from 1-4 for all four choices, stores the value in variable ans and returns that value 
and the result from the check method. It throws an exception if value is invalid. This class is a sub class of Question
and formats the question to be a multiple choice question.

Class Question

• getQuestion() returns the value for variable question. 
• setQuestions() accepts a question and sets it to question variable. 
• equals(Obejct o) an abstract method that is implemented since Question class is an abstract class. 
• getAnswer is an abstract method with another class AnsweredQuestion as the datatype. 
This class is an abstract class that gets a question from the user.

Class QuestionListScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks whether you have a question and displays screen to edit the quiz or delete the question.
This class performs actions to edit the questions.

Class Quiz

• Constructor assigns values to quizName, questions and submissions variables. 
• addQuestion() adds a question. 
• getQuestionCount() returns the value of the size of the questions variable. 
• deleteQuestion() removes a question. 
• setQuestion() set the question to a particular index of choice. 
• getQuestions() returns the value of variable questions. 
• equals(Object o) returns a boolean value for when all our inputs are valid 
• getQuizName() returns the quiz name. 
• fromFile() reads in the Quiz text file and creates an instance. 
• toString() returns a string containing a list of questions in the quiz. 
• addSubmission() adds the current submission. 
• getSubmissions() returns the value of the variable submissions. 
This class is used to create a quiz and implements features like deleting, modifying and adding questions.

Class QuizEditOptions

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks which type of action you want to perform and displays the respective screen
accordingly.
This class performs actions to add, delete and edit quizzes.

Class QuizListScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed checks whether you have a question and displays screen to edit the quiz or delete the question.
This class performs actions to edit the questions.

Class QuizSubmission

• Constructor assigns value to quiz, username, quizStart, questionsAsked and answeredQuestions and quizEnd. 
• toString() returns a string with the name of the person who finished the quiz with the time stamp.
• getAnsweredQuestions() returns the value of the variable answeredQuestions. 
This class gets list of responses from the user and records the time the submission was made.

Class ResetUsernameScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed edits the username
This class resets the username of the user.

Class ResetPasswordScreen

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed edits the password
This class resets the password of the user.

Class Server implements Runnable

• constructor assigns values to variables
• run performs actions to get the courses, quizzes, questions and also deals with login and logout actions.
• main method starts the thread
This class is one of the most important ones because other classes reference this class to carry out different actions.

Class Session
• constructor initializes variables
• getCurrentQuiz() returns the value of the current quiz
• setCurrentQuiz() sets the value of the current quiz according to the parameter.
• getCurrentCourse() returns the value of current course.
• setCurrentCourse() sets the value of the current course according to the parameter.
• equals(Object o) returns a boolean value for when all our inputs are valid
• getUser() returns the user value.
• setUser() sets the value of user according to parameter.
• setLoggedIn() set the valued for variable loggedIn.
• logout() sets loggedIn value to false and the rest of the variables to null.

Class ShowCoursesDropdownScreen 

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class performs actions for entering, edit and delete courses.

Class ShowCoursesDropdownScreenStudent

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class displays the courses for the student.

Class Student extends User

• Constructor Teacher accepts username and password and the super keyword is used to access the username and password 
from User class.
• isTeacher just confirms that the user’s identity is student by returning false.
With the concept of inheritance we access parent class User and check whether the user is a student.

Class StudentBaseView extends JFrame implements ActionListener

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class performs actions like resetting and deleting the student's account and also accessing the courses.

Class StudentInCourseOptions extends JFrame implements ActionListener

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class performs actions like resetting and deleting the student's account and get the quizzes inside courses.

Class TakeMCquestion extends JFrame implements ActionListener

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class helps to take the multiple choice question.

Class TakeTFquestion extends JFrame implements ActionListener

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class helps to take the True or False question.

Class Teacher extends User

• Constructor Teacher accepts username and password and the super keyword is used to access the username and password 
from User class.
• isTeacher just confirms that the user’s identity is teacher by returning true.
With the concept of inheritance we access parent class User and check whether the user is a teacher.

Class TeacherBaseView extends JFrame implements ActionListener

• constructor assigns values to variables and calls all the methods in the class.
• setLocationAndSize sets boundaries to all the JButtons
• addComponentsToContainer adds objects to container.
• addActionEvent simply makes use of addActionListener to take current object as parameters.
• actionPerformed performs actions as per the user and displays it accordingly.
This class performs actions like resetting and deleting the teacher's account and also accessing the courses
and being able to edit them.

CLass TFQuestion extends Question implements Serializable

• Constructor assigns value to answer and question.
• check returns true or false based on whether the student's answer matches the correct answer.
• equals(Object o) returns a boolean value for when all our inputs are valid
• getAnswer() returns the answer and the check method.
This class is a sub class of Question and formats the question to be a True or False question.

Class User

• Constructor User assigns values to variables username and password. 
• getUsername returns the username 
• setUsername accepts a username and sets it to username variable. 
• getPassword returns the password 
• setPassword accepts a password and sets it to password variable. 
• equals(Object o) checks whether the username and password exist and returns true or false 
• toFile(String fileName) stores the username and password in a file after determining whether it is teacher or student.
If the username and password are invalid, it throws an exception. 
So, User class accepts the login information and stores in a file indefinitely.

Class Utils

• makeFrameFromTemplate is being referenced in other classes to from the design of the screen displayed
• reWriterUserFile used for writing the file to store user username and password










