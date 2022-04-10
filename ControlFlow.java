import java.util.*;
import java.io.*;
//Requires a "UsersInfo.txt" file to function properly
public class ControlFlow {
    public static String USER_INFO_FILE_NAME = "UsersInfo.txt";

    public static String WELCOME_MESSAGE = "Welcome to Quiz Manager!";
    public static String NOT_LOGGED_IN_OPTIONS =  "1.Log In\n2.Sign Up\n3.Quit";
    public static String SUCCESSFUL_LOGIN = "Login Successful!";
    public static String USER_TYPE_OPTIONS = "1.Student\n2.Teacher";
    public static String EXIT_MESSAGE = "Quiz manager shutting down...Have a great day!";
    public static String LOGGED_IN_TEACHER_OPTIONS ="1.Make a quiz\n2.Edit a quiz\n3.Delete quiz\n4.View quiz submissions\n5.Edit username\n6.Edit password\n7.Logout\n8.Delete Account";

    public static String QUESTION_TYPES = "1.Multiple Choice\n2.True or False\n3.Fill in the blank";
    public static String QUESTION_TYPES_WITH_EXIT = "1.Multiple Choice\n2.True or False\n3.Fill in the blank\n4.Exit";
    public static String QUESTION_EDIT_PROMPT = "1.Add a question\n2.Edit a question\n3.Delete a question";

    public static String QUIZ_NAME_PROMPT = "What is the name of the quiz?";
    public static String QUESTION_PROMPT = "What is the the question you want to ask?";
    public static String FIRST_MC_CHOICE = "What is the value of the first choice: ";
    public static String SECOND_MC_CHOICE = "What is the value of the second choice: ";
    public static String THIRD_MC_CHOICE = "What is the value of the third choice: ";
    public static String FOURTH_MC_CHOICE = "What is the value of the fourth choice: ";
    public static String ANSWER_PROMPT = "What is the answer for this question";

    public static String COURSE_LEVEL_VIEW_OPTIONS ="1.Make a course\n2.Enter a course\n3.Delete a course\n4.Edit username\n5.Edit password\n6.Logout\n7.Delete Account";

    public static String STUDENT_COURSE_LEVEL_VIEW_OPTIONS = "1.Enter a course\n2.Edit username\n3.Edit password\n4.Logout\n5.Delete Account";
    public static String STUDENT_IN_COURSE_OPTIONS = "1.Take a quiz\n2.Edit username\n3.Edit password\n4.Logout\n5.Delete Account";


    public static String TRUE_FALSE_SELECTION = "1.True\n2.False";

    public static void reWriterUserFile(ArrayList<User> users) { //do this when they delete their account, change username, password, or any other user attribute that is stored
        File f = new File(USER_INFO_FILE_NAME);
        String descriptor;
        FileWriter fwr = null;
        try {
            fwr = new FileWriter(f, false);

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (var v: users) {
            if (v instanceof Teacher) {
                descriptor = "Teacher";
            } else {
                descriptor = "Student";
            }
            try {
                fwr.append(String.format("%s,%s,%s\n",v.getUsername(), v.getPassword(), descriptor));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fwr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readInt(Scanner scanner, String prompt, int minVal, int maxVal) {
        int num = 0;
        boolean readInt = false;

        do {
            try {
                System.out.println(prompt);
                num = scanner.nextInt();

                if(num <= maxVal && num >= minVal) {
                    readInt = true;
                }
                else {
                    System.out.printf("Please enter a valid integer from %d to %d\n", minVal, maxVal);
                }
            } catch (InputMismatchException e) {
                System.out.printf("Please enter a valid integer from %d to %d\n", minVal, maxVal);
            }
        } while (!readInt);

        return num;
    }

    public static FillBlankQuestion createFillBlankQuestion(Scanner scanner) {
        System.out.println(QUESTION_PROMPT);
        String prompt = scanner.nextLine();

        System.out.println(ANSWER_PROMPT);
        String answer = scanner.nextLine();

        FillBlankQuestion question = new FillBlankQuestion(prompt, answer);
        return question;

    }

    public static MCquestion createMCquestion(Scanner scanner) {
        System.out.println(QUESTION_PROMPT);
        String prompt = scanner.nextLine();

        System.out.println(FIRST_MC_CHOICE);
        String choice1 = scanner.nextLine();

        System.out.println(SECOND_MC_CHOICE);
        String choice2 = scanner.nextLine();

        System.out.println(THIRD_MC_CHOICE);
        String choice3 = scanner.nextLine();

        System.out.println(FOURTH_MC_CHOICE);
        String choice4 = scanner.nextLine();

        int answer = readInt(scanner, ANSWER_PROMPT + "\n1." + choice1 + "\n2." + choice2 + "\n3." + choice3 + "\n4." + choice4,1, 4);
        MCquestion question = new MCquestion(prompt, choice1, choice2, choice3, choice4, answer);

        return question;

    }

    public static TFquestion createTFquestion(Scanner scanner) {
        String prompt;
        boolean answer;
        int temp;

        System.out.println(QUESTION_PROMPT);
        prompt = scanner.nextLine();

        temp = readInt(scanner, ANSWER_PROMPT + "\n" + TRUE_FALSE_SELECTION, 1, 2);

        if (temp == 1) {
            answer = true;
        } else {
            answer = false;
        }

        return new TFquestion(prompt, answer);

    }

    public static Quiz createQuiz(Scanner scanner) {
        System.out.println(QUIZ_NAME_PROMPT);
        String quizName = scanner.nextLine();
        Quiz currentQuiz = new Quiz(quizName);

        int questionType = readInt(scanner, "What type of question do you want to add?\n" + QUESTION_TYPES, 1, 3);
        scanner.nextLine();

        while(questionType != 4) {
            if (questionType == 1) {
                currentQuiz.addQuestion(createMCquestion(scanner));
            } else if (questionType == 2){
                currentQuiz.addQuestion(createTFquestion(scanner));
            }
            else if (questionType == 3) {
                currentQuiz.addQuestion(createFillBlankQuestion(scanner));
            }

            questionType = readInt(scanner, "What type of question do you want to add?\n" + QUESTION_TYPES_WITH_EXIT, 1, 4);
            scanner.nextLine();

        }

        return currentQuiz;


    }

    public static Quiz createQuizFromFile(Scanner scanner) {
        System.out.println("What file do you want to create the quiz from?");
        return Quiz.fromFile(scanner.nextLine());
    }

    public static String readValidPassword(Scanner scanner) {
        boolean validPassword = false;
        String password;
        do {
            System.out.println("Enter a new password: "); //maybe have them enter their password to be even allowed
            password = scanner.nextLine();
            if (password.contains(",")) {
                System.out.println("Passwords can not contain a comma, try again");
            }
            else {
                validPassword = true;
            }
        } while(!validPassword);

        return password;
    }

    public static String readValidUsername(Scanner scanner) {
        boolean validUsername = false;
        String username;
        do {
            System.out.println("Enter a new username: ");
            username = scanner.nextLine();
            if (username.contains(",")) {
                System.out.println("Usernames can not contain a comma, try again");
            }
            else {
                validUsername = true;
            }
        } while(!validUsername);
        return username;
    }

    public static Course createCourse(Scanner scanner) {
        String name;
        int number;

        System.out.println("What do you want to be the name of the course?");
        name = scanner.nextLine();

        System.out.println("What do you want the course number to be?");
        number = scanner.nextInt();

        return new Course(name, number);
    }



    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String username;
        String password;

        int choice;
        boolean loggedIn = false;
        User currentUser = null;
        Course currentCourse;

        System.out.println(WELCOME_MESSAGE);
        choice = readInt(scanner, NOT_LOGGED_IN_OPTIONS, 1, 3);
        scanner.nextLine();


        ArrayList<User> users = new ArrayList<User>();
        //ArrayList<Quiz> quizzes = new ArrayList<Quiz>();

        ArrayList<Course> courses = new ArrayList<Course>();


        String line;
        try {
            File f = new File(USER_INFO_FILE_NAME);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");

                if (attributes[2].equals("Teacher")) {
                    users.add(new Teacher(attributes[0], attributes[1]));
                } else if (attributes[2].equals("Student")) {
                    users.add(new Student(attributes[0], attributes[1]));
                }
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (choice != 3) {

            if (choice == 1) {

                System.out.println("Enter your username: ");
                username = scanner.nextLine();

                System.out.println("Enter your password: ");
                password = scanner.nextLine();

                if (users.contains(new User(username, password))) {
                    System.out.println(SUCCESSFUL_LOGIN);
                    loggedIn = true;
                    currentUser = users.get(users.indexOf(new User(username, password)));
                } else {
                    System.out.println("Login failed, enter a valid username and password");
                }

            }

            if (choice == 2) {
                int userType = readInt(scanner, "What type of account do you want to make?\n" + USER_TYPE_OPTIONS, 1, 2);
                scanner.nextLine();
                boolean validUsername = false;

                username = readValidUsername(scanner);
                while (!validUsername) {
                    validUsername = true;
                    for (User u: users) {
                        if(u.getUsername().equals(username)) {
                            validUsername = false;
                            break;
                        }
                    }
                    if(validUsername) {
                        break;
                    }
                    System.out.printf("Enter another username, %s is taken%n", username);
                    username = readValidUsername(scanner);
                }
                password = readValidPassword(scanner);



                if (userType == 1) {
                    currentUser = new Student(username, password);
                    users.add(currentUser); //FIXME make student
                } else if (userType == 2) {
                    currentUser = new Teacher(username, password);
                    users.add(currentUser);
                }
                loggedIn = true;
                currentUser.toFile(USER_INFO_FILE_NAME);

            }

            while (loggedIn && currentUser instanceof Teacher) {
                int loggedInChoice = readInt(scanner, "What do you want to do\n" + COURSE_LEVEL_VIEW_OPTIONS, 1, 7);
                scanner.nextLine();

                switch (loggedInChoice) {
                    case 1:
                        courses.add(createCourse(scanner));
                        break;
                    case 2:
                        if (courses.size() == 0) {
                            System.out.println("There are no courses made. You need to add courses before editing them");
                            break;
                        }
                        String courseList = "";
                        for (int i = 0; i < courses.size(); i++) {
                            if(i != courses.size()-1) {
                                courseList += String.format("%d.%s %s%n", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber());
                            } else {
                                courseList += String.format("%d.%s %s", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber()); //no need for the newline at the end if its the last one
                            }
                        }
                        int courseEditIndex = readInt(scanner, "Which course do you want to edit\n" + courseList, 1, courses.size());

                        currentCourse = courses.get(courseEditIndex - 1);

                        //FIXME, send them into this courses quizzes, maybe put them in the for loop
                        loggedInChoice = readInt(scanner, "What do you want to do\n" + LOGGED_IN_TEACHER_OPTIONS, 1, 8);
                        scanner.nextLine();

                        switch (loggedInChoice) {
                            case 1:
                                int createQuizType = readInt(scanner, "How do you want to make the quiz?\n1.From a file\n2.From the terminal.",1, 2);
                                scanner.nextLine();
                                if(createQuizType == 1) {
                                    currentCourse.addQuiz(createQuizFromFile(scanner));
                                } else {
                                    currentCourse.addQuiz(createQuiz(scanner));
                                }
                                break;
                            case 2:
                                if (currentCourse.getQuizCount() == 0) {
                                    System.out.println("There are no quizzes. You can't edit any.");
                                    break;
                                }
                                String listedQuizzes = "";
                                for (int i = 1; i <= currentCourse.getQuizCount(); i++) {
                                    if (i != currentCourse.getQuizCount()) {
                                        listedQuizzes += String.format("%d.%s%n", i, currentCourse.getQuiz(i - 1).getQuizName());
                                    } else {
                                        listedQuizzes += String.format("%d.%s", i, currentCourse.getQuiz(i - 1).getQuizName());
                                    }
                                }
                                int editIndex = readInt(scanner, "Which quiz do you want to edit?\n" + listedQuizzes, 1, currentCourse.getQuizCount());
                                Quiz quizToEdit = currentCourse.getQuiz(editIndex - 1);//subtract 1 since they are listed counting up from 1


                                int editType = readInt(scanner, "How do you want to edit the quiz?\n" + QUESTION_EDIT_PROMPT, 1, 3);

                                if (editType == 1) {
                                    int questionType = readInt(scanner, "What type of question do you want to add?\n" + QUESTION_TYPES, 1, 3);
                                    scanner.nextLine();
                                    if (questionType == 1) {
                                        quizToEdit.addQuestion(createMCquestion(scanner));
                                    } else if (questionType == 2) {
                                        quizToEdit.addQuestion(createTFquestion(scanner));
                                    } else if (questionType == 3) {
                                        quizToEdit.addQuestion(createFillBlankQuestion(scanner));
                                    }
                                } else if (editType == 2) {

                                    if (quizToEdit.getQuestionCount() == 0) {
                                        System.out.println("There are no questions in this quiz, you can't edit any");
                                        break;
                                    }

                                    int questionEditIndex = readInt(scanner, "Which question do you want to edit?\n" + quizToEdit, 1, quizToEdit.getQuestionCount());
                                    //fixme add a scanner.nextline right here possibly
                                    int questionType = readInt(scanner, "What type of question do you want to replace it with?\n" + QUESTION_TYPES, 1, 3);
                                    scanner.nextLine();

                                    if (questionType == 1) {
                                        quizToEdit.setQuestion(questionEditIndex - 1, createMCquestion(scanner));
                                    } else if (questionType == 2) {
                                        quizToEdit.setQuestion(questionEditIndex - 1, createTFquestion(scanner));
                                    } else if (questionType == 3) {
                                        quizToEdit.setQuestion(questionEditIndex - 1, createFillBlankQuestion(scanner));
                                    }

                                } else if (editType == 3) {

                                    if (quizToEdit.getQuestionCount() == 0) {
                                        System.out.println("There are no questions in this quiz, you can't delete any");
                                        break;
                                    }

                                    int delIndex = readInt(scanner, "Which question do you want to delete?\n" + quizToEdit, 1, quizToEdit.getQuestionCount());
                                    quizToEdit.deleteQuestion(delIndex - 1);
                                }

                                break;
                            case 3:
                                if (currentCourse.getQuizCount() == 0) {
                                    System.out.println("There are no quizzes. You can't delete.");
                                    break;
                                }
                                String listedQuizzes1 = "";
                                for (int i = 1; i <= currentCourse.getQuizCount(); i++) {

                                    listedQuizzes1 += String.format("%d.%s%n", i, currentCourse.getQuiz(i - 1).getQuizName());
                                }
                                int delIndex = readInt(scanner, "Which quiz do you want to delete?\n" + listedQuizzes1, 1, currentCourse.getQuizCount());
                                currentCourse.removeQuiz(delIndex - 1); //subtract 1 since you start at 1 instead of 0
                                break;
                            case 4:
                                int quizToViewIndex = readInt(scanner, "Which quiz do you want to view submission for?\n" + currentCourse, 1, currentCourse.getQuizCount());
                                scanner.nextLine();

                                Quiz quizToView = currentCourse.getQuiz(quizToViewIndex - 1);

                                String submissionList = "";
                                for(int i = 0; i < quizToView.getSubmissions().size(); i++){
                                    if(i != quizToView.getSubmissions().size() - 1) {
                                        submissionList += String.format("%d.%s%n", i+1, quizToView.getSubmissions().get(i));
                                    } else {
                                        submissionList += String.format("%d.%s", i+1, quizToView.getSubmissions().get(i));
                                    }
                                }
                                int submissionIndex = readInt(scanner, "Which quiz do you want to view submission for?\n" + submissionList, 1, currentCourse.getQuizCount());
                                scanner.nextLine();

                                QuizSubmission sub = quizToView.getSubmissions().get(submissionIndex - 1);

                                for (AnsweredQuestion ans: sub.getAnsweredQuestions()) {
                                    System.out.println(ans);
                                }
                                break;
                            case 5:
                                currentUser.setUsername(readValidUsername(scanner));
                                break;
                            case 6:
                                currentUser.setPassword(readValidPassword(scanner));
                                break;
                            case 7:
                                loggedIn = false;
                                currentUser = null;
                                break;
                            case 8:
                                users.remove(currentUser);
                                reWriterUserFile(users);
                                loggedIn = false;
                                break;
                        }
                        break;
                    case 3:
                        if (courses.size() == 0) {
                            System.out.println("There are no courses made. You need to add courses before deleting them");
                            break;
                        }
                        courseList = "";
                        for (int i = 0; i < courses.size(); i++) {
                            if (i != courses.size() - 1) {
                                courseList += String.format("%d.%s %s%n", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber());
                            } else {
                                courseList += String.format("%d.%s %s", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber());
                            }
                        }
                        int delIndex = readInt(scanner, "Which course do you want to delete\n" + courseList, 1, courses.size());
                        courses.remove(delIndex - 1);
                        break;
                    case 4:
                        currentUser.setUsername(readValidUsername(scanner));
                        break;
                    case 5:
                        currentUser.setPassword(readValidPassword(scanner));
                        break;
                    case 6:
                        loggedIn = false;
                        currentUser = null;
                        break;
                    case 7:
                        users.remove(currentUser);
                        reWriterUserFile(users);
                        loggedIn = false;
                        break;
                }
            }

            while (loggedIn && currentUser instanceof Student) {
                int loggedInChoice = readInt(scanner, "What do you want to do\n" + STUDENT_COURSE_LEVEL_VIEW_OPTIONS, 1, 5);
                scanner.nextLine();

                switch (loggedInChoice) {
                    case 1:
                        if(courses.size() == 0) {
                            System.out.println("There have been no courses made yet. Tell your teachers to make them first.");
                            break;
                        }
                        String courseList = "";
                        for (int i = 0; i < courses.size(); i++) {
                            if(i != courses.size() - 1) {
                                courseList += String.format("%d.%s %s%n", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber());
                            } else {
                                courseList += String.format("%d.%s %s", i + 1, courses.get(i).getCourseName(), courses.get(i).getCourseNumber());
                            }
                        }
                        int courseIndex = readInt(scanner, "Which course do you want to enter\n" + courseList, 1, courses.size());
                        currentCourse = courses.get(courseIndex - 1);

                        int inCourseChoice = readInt(scanner, "What do you want to do\n" + STUDENT_IN_COURSE_OPTIONS, 1, courses.size());

                        switch(inCourseChoice) {
                            case 1:
                                if (currentCourse.getQuizzes().size() == 0) {
                                    System.out.println("There are no quizzes for this class :)");
                                    break;
                                }
                                Quiz quizToTake = currentCourse.getQuiz(readInt(scanner, "Which quiz do you want to take?\n" + currentCourse, 1, currentCourse.getQuizCount())-1);

                                quizToTake.addSubmission(new QuizSubmission(quizToTake, scanner, currentUser.getUsername()));


                                //fixme and implement a way to take quizzes and store submissions


                                //need to list quizzes
                                break;
                            case 2: //change username
                                currentUser.setUsername(readValidUsername(scanner));
                                break;
                            case 3: //change password
                                currentUser.setPassword(readValidPassword(scanner));
                                break;
                            case 4: //logout
                                loggedIn = false;
                                currentUser = null;
                                break;
                            case 5: //delete account
                                users.remove(currentUser);
                                reWriterUserFile(users);
                                loggedIn = false;
                                break;

                        }



                        break;
                    case 2: //change username
                        currentUser.setUsername(readValidUsername(scanner));
                        break;
                    case 3: //change password
                        currentUser.setPassword(readValidPassword(scanner));
                        break;
                    case 4: //logout
                        loggedIn = false;
                        currentUser = null;
                        break;
                    case 5: //delete account
                        users.remove(currentUser);
                        reWriterUserFile(users);
                        loggedIn = false;
                        break;

                }

            }


            choice = readInt(scanner, NOT_LOGGED_IN_OPTIONS, 1, 3);
            scanner.nextLine();
            }

            reWriterUserFile(users); //only do this if there was a change, otherwise it is not efficient especially as the user size grows fixme
            System.out.println(EXIT_MESSAGE);


            }

}