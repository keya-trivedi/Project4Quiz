# Project4Quiz

**A program for a student-teacher quiz managment system**

To run the file, you need a **UsersInfo.txt file in the root directory**. 
Type **
javac ControlFlow.java
java ControlFlow
**

**File: ControlFlow.java**
This class is used to run the entire program. It runs as long as the user decides not to exit the program. It first instantiates a list of users from the **UsersInfo.txt** file which will be used to check if a username and password refer to an existing user. Users can also create an account for either a student or a teacher. If a teacher logs in they will have a menu where they have the following choices:
The question types we allowed the users to make are True and False, Multiple choice, and Fill in the blank


1.Make a course (prompts them to create a Course instance and appends it to the courses list)
2.Enter a course (Go inside of a course after being given a list of them to choose from)
3.Delete a course (Delete a course after being given a list of them to choose from)
4.Edit username (Change the value of the username attribute within the instance of Teacher or Student that refers to the logged in user)
5.Edit password (Change the value of the password attribute within the instance of Teacher or Student that refers to the logged in user)
6.Logout (changes the loggedin variable to false and the current user variable to null. This prompts the user to sign in, log in, or exit)
7.Delete Account (This deletes the users account from the users list, their username and password will no longer be valid for them logging in)

If they enter a course, they will be prompted with the following options.
1.Make a quiz (Prompts you to make at least 1 question, and keeps asking you for more questions till you choose to exit)
2.Edit a quiz (Lets you see the questions in a quiz, and prompts you to make a new question replace the question you chose)
3.Delete quiz (Lists all the quizzes and lets you pick which one to delete)
4.View quiz submissions (Delete a course after being given a list of them to choose from)
5.Edit username (Change the value of the username attribute within the instance of Teacher or Student that refers to the logged in user)
6.Edit password (Change the value of the password attribute within the instance of Teacher or Student that refers to the logged in user)
7.Logout (changes the loggedin variable to false and the current user variable to null. This prompts the user to sign in, log in, or exit)
8.Delete Account (This deletes the users account from the users list, their username and password will no longer be valid for them logging in)

The program keeps you in the running loop as long as you don't choose the option to exit. You can only use the exit option if you are not logged in.

The program uses a currentUser and CurrentCourse to keep track of the users session and what to display on the screen for them. 

When the user decides to exit the program. We will rewrite the **UsersInfo.txt** file to make sure that it adjusts in case anyone who interacted with the program changed their username or password. 

Class User

•	Constructor User assigns values to variables username and password.
•	getUsername returns the username
•	setUsername accepts a username and sets it to username variable.
•	getPassword returns the password
•	setPassword accepts a password and sets it to password variable.
•	equals(Object o) checks whether the username and password exist and returns true or false
•	toFile(String fileName) stores the username and password in a file after determining whether it is teacher or student. If the username and password are invalid, it throws an exception.
So, User class accepts the login information and stores in a file indefinitely. It is used in ControlFlow(which is the class we use to run Project 4). 

Class Teacher extends User

•	Constructor Teacher accepts username and password and the super keyword is used to access the username and password from User class.
•	isTeacher just confirms that the user’s identity is teacher by returning true.
With the concept of inheritance we access parent class User and check whether the user is a teacher.

Class Student extends User

•	Constructor Teacher accepts username and password and the super keyword is used to access the username and password from User class.
•	isTeacher just confirms that the user’s identity is student by returning false.
With the concept of inheritance we access parent class User and check whether the user is a student.

Class Question 

•	getQuestion() returns the value for variable question.
•	setQuestions() accepts a question and sets it to question variable.
•	equals(Obejct o) an abstract method that is implemented since Question class is an abstract class.
•	getAnswer is an abstract method with another class AnsweredQuestion as the datatype.
This class is an abstract class that gets a question from the user.

Class AnsweredQuestion 

•	Constructor AnsweredQuestion assigns values to variables question, answer and correct. 
•	getQuestion returns the value of question
•	getAnswer returns the value of answer
•	isCorrect returns the value of correct variable
•	toString checks whether the question is right or wrong and returns the question, what the student answered and whether it is right or wrong.
This class gets the answer for the question and tests whether it is correct. 

Class TFquestion extends Question

• Constrcutor assigns value to answer and question.
• check returns true or false based on whether the student's answer matches the correct answer.
• equals(Object o) returns a boolean value for when all our inputs are valid
• getAnswer() accepts a number 1 or 2 for True or False and returns the answer and the check method. It throws an excpetion if value is invalid.
This class is a sub class of Question and formats the question to be a True/False question.

Class MCquestion extends Question

• Constrcutor assigns value to answer and question.
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
• getAnswer() accepts a number from 1-4 for all four choices, stores the value in variable ans and returns that value and the result from the check method. It throws an exception if value is invalid.
This class is a sub class of Question and formats the question to be a multiple choice question.

CLass FillBlankQuestion extends Question

• Constrcutor assigns value to answer and question.
• check returns true or false based on whether the student's answer matches the correct answer.
• equals(Object o) returns a boolean value for when all our inputs are valid
• getAnswer() returns the answer and the check method.
This class is a sub class of Question and formats the question to be a Fill in the Blank question.

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

Class QuizSubmission 

• Constructor assigns value to quiz, username, quizStart, questionsAsked and answeredQuestions and quizEnd.
• toString() returns a string with the name of the person who finished the quiz with the time stamp.
• getAnsweredQuestions() returns the value of the variable answeredQuestions.
This class gets list of responses from the user and records the time the submission was made.
