//Moye Yao
import javax.swing.JOptionPane; // Import JOptionPane for popup messages
public class AccountHolder {
    private static double annualInterestRate;
    private double balance;

    // Constructor with initial balance argument
    public AccountHolder(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to set the annual interest rate (static method)
    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money from the account
    public void withdrawal(double amount) {
        if (amount > 0 && (balance - amount) >= 50) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            JOptionPane.showMessageDialog(null, "Withdrawal amount exceeds balance or is invalid. "
                    + "Minimum balance of $50 must be maintained.");
        }
    }

    // Method to calculate monthly interest based on annual interest rate
    public void monthlyInterest() {
        balance += balance * (annualInterestRate / 12.0);
        System.out.println("Monthly interest added.");
    }

    // Getter method for balance
    public double getBalance() {
        return balance;
    }

    // Getter method for annual interest rate (static)
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void main(String[] args) {
        AccountHolder account1 = new AccountHolder(1000); // Create an account with $1000 initial balance
        account1.deposit(500); // Deposit $500
        account1.withdrawal(200); // Withdraw $200
        account1.monthlyInterest(); // Calculate and add monthly interest

        System.out.println("Current balance: $" + account1.getBalance());
    }
}