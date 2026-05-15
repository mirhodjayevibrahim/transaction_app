import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to my app, you should choose between register and login just type r or l");
            String choice = scanner.nextLine();
            if (choice.equals("q")) {
                break;
            }

            if (choice.equalsIgnoreCase("r")) {
                System.out.println("Enter your email");
                String email = scanner.nextLine();
                if (email.equals("q")) {
                    break;
                }


                System.out.println("Enter your pin");
                String password = scanner.nextLine();
                if (password.equals("q")) {
                    break;
                }

                Register register = new Register();
                Service service = new Service(register.register(email, password));
                if (register.log == false) {
                    continue;
                }


                while (true) {
                    System.out.println("Welcome " + email + ", you can choose between deposit, withdraw, checkbalance, transfer and history just type d, w, c, t or h(or logout)");
                    String serviceChoice = scanner.nextLine();
                    if (serviceChoice.equals("q")) {
                        break;
                    }
                    else if(serviceChoice.equals("logout")) {
                        break;
                    }
                    switch (serviceChoice) {
                        case "d":
                            System.out.println("enter the deposit amount:");
                            long amount = scanner.nextLong();
                            scanner.nextLine();
                            if (amount < 0) {
                                System.out.println("Amount should be positive");
                            } else {
                                service.deposit(amount);
                            }
                            break;
                        case "w":
                            System.out.println("enter the withdraw amount:");
                            amount = scanner.nextLong();
                            scanner.nextLine();
                            if (amount < 0) {
                                System.out.println("Amount should be positive");
                            } else {
                                service.withdraw(amount);
                            }
                            break;
                        case "c":
                            service.checkbalance();
                            break;
                        case "t":
                            System.out.println("enter the email of the user you want to transfer to:");
                            String email1 = scanner.nextLine();
                            if (email1.equals("q")) {
                                break;
                            }
                            User user1 = User.usersList.stream().filter(u -> u.email.equals(email1)).findFirst().orElse(null);
                            if (user1 == null) {
                                System.out.println("User not found");
                                break;
                            }
                            System.out.println("enter the transfer amount:");
                            amount = scanner.nextLong();
                            scanner.nextLine();
                            if (amount < 0) {
                                System.out.println("Amount should be positive");
                            } else {
                                service.transfer(user1, amount);
                            }
                            break;
                        case "h":
                            service.histroy();
                            break;
                    }
                }


            } else if (choice.equalsIgnoreCase("l")) {
                Login login = new Login();
                System.out.println("Enter your email");
                String email = scanner.nextLine();
                if (email.equals("q")) {
                    break;
                }


                System.out.println("Enter your password");
                String password = scanner.nextLine();
                if (password.equals("q")) {
                    break;
                }
                Service service = new Service(login.login(email, password));
                if (login.log == false) {
                    continue;
                }
                while (true) {
                    if (login.log == true) {
                        System.out.println("Welcome " + email + ", you can choose between deposit, withdraw, checkbalance, transfer and history just type d, w, c, t or h(or logout)");
                        String serviceChoice = scanner.nextLine();
                        if (serviceChoice.equals("q")) {
                            break;
                        }
                        else if(serviceChoice.equals("logout")) {
                            break;
                        }
                        switch (serviceChoice) {
                            case "d":
                                System.out.println("enter the deposit amount:");
                                long amount = scanner.nextLong();
                                scanner.nextLine();
                                if (amount < 0) {
                                    System.out.println("Amount should be positive");
                                } else {
                                    service.deposit(amount);
                                }
                                break;
                            case "w":
                                System.out.println("enter the withdraw amount:");
                                amount = scanner.nextLong();
                                scanner.nextLine();
                                if (amount < 0) {
                                    System.out.println("Amount should be positive");
                                } else {
                                    service.withdraw(amount);
                                }
                                break;
                            case "c":
                                service.checkbalance();
                                break;
                            case "t":
                                System.out.println("enter the email of the user you want to transfer to:");
                                String email1 = scanner.nextLine();
                                if (email1.equals("q")) {
                                    break;
                                }
                                User user1 = User.usersList.stream().filter(u -> u.email.equals(email1)).findFirst().orElse(null);
                                if (user1 == null) {
                                    System.out.println("User not found");
                                    break;
                                }
                                System.out.println("enter the transfer amount:");
                                amount = scanner.nextLong();
                                scanner.nextLine();
                                if (amount < 0) {
                                    System.out.println("Amount should be positive");
                                } else {
                                    service.transfer(user1, amount);
                                }
                                break;
                            case "h":
                                service.histroy();
                                break;
                        }
                    }
                }
                System.out.println(User.users);

            }

        }
    }
}
