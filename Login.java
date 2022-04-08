import java.util.*;
import java.io.*;
//Requires a "UsersInfo.txt" file to function properly
public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username;
        String password;
        int c;
        boolean loggedIn = false;
        do {
            System.out.println("Welcome to Quiz Manager!");
            do {
                try {
                    System.out.println("1.Log In\n2.Sign Up\n3.Quit");
                    c = scan.nextInt();
                    if (c >=1 && c <= 3) {
                        break;
                    }
                } catch (InputMismatchException e) {
                } finally {
                    scan.nextLine();
                }
                System.out.println("Input must be a number between 1 and 3");
            } while (true);

            ArrayList<String> users = new ArrayList<String>();
            String line;
            try {
                File f = new File("UsersInfo.txt");
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                line = br.readLine();
                while (line != null) {
                    users.add(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (c == 1) {
                if (users.size() <= 0) {
                    System.out.println("There are no users in the registry!");
                    System.out.println("Please try signing up instead");
                } else {
                    do {
                        System.out.println("Enter your username:");
                        username = scan.nextLine();
                        if (username.contains(",")) {
                            System.out.println("Usernames may not contain a comma");
                        }
                    } while (username.contains(","));

                    System.out.println("Enter your password:");
                    password = scan.nextLine();

                    String refUsername;
                    String refPassword;

                    int scenario = 0;

                    for (int i = 0; i < users.size(); i++) {
                        refUsername = users.get(i).substring(0, users.get(i).indexOf(','));
                        refPassword = users.get(i).substring(users.get(i).indexOf(',') + 1, users.get(i).length());

                        if (refPassword.equals(password) && refUsername.equals(username)) {
                            scenario = 1;
                            break;
                        } else if (!refPassword.equals(password) && refUsername.equals(username)){
                            scenario = 2;
                            break;
                        }

                    }

                    if (scenario == 1) {
                        System.out.println("Login Successful!");
                        loggedIn = true;
                    } else if (scenario == 2) {
                        System.out.println("Password was Incorrect!");
                    } else {
                        System.out.println("Username not found!");
                    }
                }
            }

            if (c == 2) {
                boolean alreadyExists = false;
                do {
                    do {
                        System.out.println("Enter new username:");
                        username = scan.nextLine();
                        if (username.contains(",")) {
                            System.out.println("Usernames may not contain a comma");
                        }
                    } while (username.contains(","));

                    System.out.println("Enter new password:");
                    password = scan.nextLine();

                    String refUsername;

                    for (int i = 0; i < users.size(); i++) {
                        refUsername = users.get(i).substring(0, users.get(i).indexOf(','));

                        if (username.equals(refUsername)) {
                            alreadyExists = true;
                        }
                    }

                    if (alreadyExists) {
                        System.out.println("This username is taken.");
                        System.out.println("Try logging in or using a different username");
                    }
                } while (alreadyExists);

                try {
                    PrintWriter pw = new PrintWriter(new FileOutputStream(new File("UsersInfo.txt"),
                            true));

                    String newInfo = String.format("%s,%s", username, password);

                    pw.println(newInfo);
                    pw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("Sign Up was successful!");
            }

        } while (c !=3 && loggedIn == false);

    }
}