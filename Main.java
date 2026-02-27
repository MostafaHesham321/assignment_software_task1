package bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Bank System =====");
            System.out.println("1) Create Account");
            System.out.println("2) Login");
            System.out.println("3) Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                scanner.nextLine();
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter initial deposit: ");
                double deposit = scanner.nextDouble();
                System.out.print("Set 4-digit PIN: ");
                int pin = scanner.nextInt();

                bank.createAccount(name, deposit, pin);

            } else if (choice == 2) {
                System.out.print("Enter account number: ");
                int accNum = scanner.nextInt();
                System.out.print("Enter PIN: ");
                int pin = scanner.nextInt();

                Account user = bank.login(accNum, pin);

                if (user == null) {
                    System.out.println("Invalid account number or PIN!");
                } else {
                    int userChoice;
                    while (true) {
                        System.out.println("\n1) Check Balance");
                        System.out.println("2) Deposit");
                        System.out.println("3) Withdraw");
                        System.out.println("4) Logout");
                        System.out.print("Choose: ");
                        userChoice = scanner.nextInt();

                        if (userChoice == 1) {
                            user.checkBalance();

                        } else if (userChoice == 2) {
                            System.out.print("Enter amount to deposit: ");
                            double amt = scanner.nextDouble();
                            user.deposit(amt);

                        } else if (userChoice == 3) {
                            System.out.print("Enter amount to withdraw: ");
                            double amt = scanner.nextDouble();
                            user.withdraw(amt);

                        } else if (userChoice == 4) {
                            break;
                        } else {
                            System.out.println("Invalid choice!");
                        }
                    }
                }
            } else if (choice == 3) {
                bank.saveToFile();
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        scanner.close();

    }
}