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
