//Moye Yao
import java.util.Scanner;
public class AccountHolderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set the annual interest rate (hard-coded to 4%)
        AccountHolder.setAnnualInterestRate(4.0);

        // Create an Account object with initial balance input from user
        System.out.print("Enter initial balance for the account holder: $");
        double initialBalance = scanner.nextDouble();
        AccountHolder accountHolder = new AccountHolder(initialBalance);

        // Prompt user to enter a deposit amount
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();
        accountHolder.deposit(depositAmount);

        // Prompt user to enter a withdrawal amount
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();
        accountHolder.withdrawal(withdrawalAmount);

        // Display current balance including applied interest
        accountHolder.monthlyInterest(); // Calculate monthly interest
        double currentBalance = accountHolder.getBalance();
        System.out.println("Current balance for the account holder: $" + currentBalance);

        scanner.close();
    }
}

