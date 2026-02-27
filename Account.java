package bank;

class Account {
    private int accountNumber;
    private String name;
    private double balance;
    private int pin;

    public Account(int accNum, String n, double bal, int p) {
        accountNumber = accNum;
        name = n;
        balance = bal;
        pin = p;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public boolean login(int enteredPin) {
        return enteredPin == pin;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! New balance: " + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdraw successful! New balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }
}