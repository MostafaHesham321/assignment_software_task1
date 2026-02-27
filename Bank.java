package bank;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Bank {
    private ArrayList<Account> accounts = new ArrayList<>();

    // Rade from file
    public Bank() {
        try {
            File file = new File("accounts.txt");
            if (!file.exists()) {
                file.createNewFile();
            } else {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {

                    String line = scanner.nextLine();
                    if (line.isEmpty())
                        continue;

                    String[] parts = line.split(":");

                    String name = parts[0];
                    int accNum = Integer.parseInt(parts[1]);
                    int pin = Integer.parseInt(parts[2]);
                    double balance = Double.parseDouble(parts[3]);

                    accounts.add(new Account(accNum, name, balance, pin));
                }
                scanner.close();
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void createAccount(String name, double deposit, int pin) {

        int AccountNumber = 0;
        boolean loop = true;

        while (loop) {
            loop = false;
            AccountNumber = (int) (Math.random() * 10000);
            for (Account acc : accounts) {
                if (acc.getAccountNumber() == AccountNumber) {
                    loop = true;
                    break;
                }
            }
        }

        Account account = new Account(AccountNumber, name, deposit, pin);
        accounts.add(account);

        System.out.println("Account created! Your account number: " + String.format("%04d", AccountNumber));
    }

    public Account login(int AccountNumber, int pin) {

        for (Account acc : accounts) {
            if (acc.getAccountNumber() == AccountNumber && acc.login(pin)) {
                System.out.println("Login successful! Welcome " + acc.getName());
                return acc;
            }
        }

        return null;
    }

    // Write in file (name:accNum:pin:deposit)
    public void saveToFile() {
        try {
            FileWriter f = new FileWriter("accounts.txt");

            for (Account acc : accounts) {
                f.write(acc.getName() + ":" + acc.getAccountNumber() + ":" + acc.getPin() + ":" + acc.getBalance()
                        + "\n");
            }
            f.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}