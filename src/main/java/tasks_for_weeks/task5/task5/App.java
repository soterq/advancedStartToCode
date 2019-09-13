package tasks_for_weeks.task5;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username");
        String username = scanner.nextLine();

        System.out.print("Enter password");
        String password = scanner.nextLine();
        Login app = new Login(username, password);
        app.login();
    }
}
