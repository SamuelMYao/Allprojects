import java.util.Scanner;

/**
 * Program for BankAccount data including deposits and withdrawals.
 * Running balance is kept along the way and displayed at program end.
 * @author Moye Yao
 */
public class Bankaccount {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // the program's local variables
        int acctNum = 0;
        double acctBal = 0.0, currency = 0.0;
        double checks = 0.0, coins = 0.0;
        double newBal = 0.0, withdraw = 0.0;
        Scanner sc = new Scanner(System.in);

        // the program header
        System.out.println("<< Bank Account >>");
        System.out.println("------------------");
        System.out.println(" ");

        // prompt the user for data and receive data
        System.out.println("Please enter your account number:");
        acctNum = sc.nextInt();
        System.out.println("Your account number: " + acctNum);

        System.out.println("Please enter your account balance:");
        acctBal = sc.nextDouble();
        System.out.printf("** Account balance: $%6.2f\n", acctBal);

        System.out.println("Please enter the cash deposit amount:");
        currency = sc.nextDouble();
        System.out.printf("** Deposit amount (cash): $%6.2f\n", currency);

        System.out.println("Please enter the check deposit amount:");
        checks = sc.nextDouble();
        System.out.printf("** Deposit amount (checks): $%6.2f\n", checks);

        System.out.println("Please enter the coins deposit amount:");
        coins = sc.nextDouble();
        System.out.printf("** Deposit amount (coins): $%6.2f\n", coins);

        System.out.println("Please enter the withdrawal amount:");
        withdraw = sc.nextDouble();
        System.out.printf("** Withdrawal amount (cash): $%6.2f\n", withdraw);

        // calculate the new balance
        newBal = acctBal + currency + checks + coins - withdraw;

        // display the new balance
        System.out.printf("** New account balance: $%6.2f\n", newBal);

        // the program footer
        System.out.println(" ");
        System.out.println("Thank you!");
        System.out.println("------------------");

        sc.close(); // dismiss the Scanner object
    } // close the main() method
} // close the class definition