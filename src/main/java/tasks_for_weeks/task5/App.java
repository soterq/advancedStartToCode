package tasks_for_weeks.task5;

import tasks_for_weeks.task5.exception.UserNotFound;

import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Choose option\n" +
                "1 - Login\n2 - Restore password");
        int choose = scanner.nextInt();

        if (choose == 1) {
            login();
        } else if (choose == 2) {
            restorePassword();
        }
    }

    public static void login() throws Exception {
        System.out.print("Enter username");
        String username = scanner.nextLine();

        System.out.print("Enter password");
        String password = scanner.nextLine();
        Login app = new Login(username, password);
        app.login();
    }

    private static void restorePassword() throws Exception {

        System.out.print("Enter username");
        String username = scanner.nextLine();

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.print("Enter username");
        String phone = scanner.nextLine();

        RestorePassword restorePassword = new RestorePassword(username, phone);
        restorePassword.restorePassword();

    }

}
