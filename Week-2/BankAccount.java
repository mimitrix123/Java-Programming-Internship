public class BankAccount {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative.");
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive.");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be positive.");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance.");
        balance -= amount;
    }

    public double getBalance() { return balance; }

    public void displayAccount() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.printf("Balance: %.2f%n", balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC1001", "Mimi", 1000);
        account.deposit(500);
        account.withdraw(250);
        account.displayAccount();
    }
}
