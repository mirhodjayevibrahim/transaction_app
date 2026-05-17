import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome! Type 'r' to register, 'l' to login, or 'q' to quit:");
            String choice = scanner.nextLine();

            if (choice.equals("q")) {
                break;
            } else if (choice.equalsIgnoreCase("r")) {
                System.out.println("Enter your email:");
                String email = scanner.nextLine();
                if (email.equals("q")) break;

                System.out.println("Enter your 4-digit PIN:");
                String password = scanner.nextLine();
                if (password.equals("q")) break;

                Register register = new Register();
                User user = register.register(email, password);
                if (!register.isLogged()) continue;

                runServiceMenu(scanner, new Service(user), email);

            } else if (choice.equalsIgnoreCase("l")) {
                System.out.println("Enter your email:");
                String email = scanner.nextLine();
                if (email.equals("q")) break;

                System.out.println("Enter your PIN:");
                String password = scanner.nextLine();
                if (password.equals("q")) break;

                Login login = new Login();
                User user = login.login(email, password);
                if (!login.isLogged()) continue;

                runServiceMenu(scanner, new Service(user), email);
            }
        }

        System.out.println("Goodbye!");
    }


    private static void runServiceMenu(Scanner scanner, Service service, String email) {
        while (true) {
            System.out.println("\nWelcome, " + email + "!");
            System.out.println("d = deposit | w = withdraw | c = check balance | t = transfer | h = history | logout | q");
            String serviceChoice = scanner.nextLine();

            if (serviceChoice.equals("q") || serviceChoice.equalsIgnoreCase("logout")) {
                break;
            }

            switch (serviceChoice) {
                case "d":
                    System.out.println("Enter deposit amount:");
                    long amount = scanner.nextLong();
                    scanner.nextLine();
                    service.deposit(amount);
                    break;

                case "w":
                    System.out.println("Enter withdrawal amount:");
                    amount = scanner.nextLong();
                    scanner.nextLine();
                    service.withdraw(amount);
                    break;

                case "c":
                    service.checkBalance();
                    break;

                case "t":
                    System.out.println("Enter recipient email:");
                    String recipientEmail = scanner.nextLine();
                    if (recipientEmail.equals("q")) break;
                    System.out.println("Enter transfer amount:");
                    amount = scanner.nextLong();
                    scanner.nextLine();
                    service.transfer(recipientEmail, amount);
                    break;

                case "h":
                    service.history();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}