// Moye Yao
import java.util.*;
public class Invoices {
    public static void main(String args[]) {
        // the variables
        int invNum = 0;
        int numItems = 0;
        double itemPrice = 0.0, shipCharge = 0.0, totAmt = 0.0, discountAmt = 0.0;
        double discount = 0.02, subTotal = 0.0;
        char shipMethod = '\0';
        String invDate = "", shipCompanyName = "";
        boolean check = false, freeShipping = false;

        Scanner sc = new Scanner(System.in);

        // obtain today's date
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());

        // the program header
        System.out.println("[ Invoice Processing ]");
        System.out.println("----------------------\n");
        System.out.println("Today's Date is: " + date + "\n");

        // prompt user for data and receive data
        System.out.println("Please enter the invoice number:");
        invNum = sc.nextInt();
        System.out.println("The invoice number is: " + invNum);

        System.out.println("Please enter the invoice date:");
        invDate = sc.next();
        System.out.println("The invoice date is: " + invDate);

        System.out.println("Please enter the number of items purchased:");
        numItems = sc.nextInt();
        System.out.println("The number of items is: " + numItems);

        // determine the per item price
        if (numItems > 0 && numItems <= 10)
            itemPrice = 0.75;
        else if (numItems > 10 && numItems <= 50)
            itemPrice = 0.65;
        else
            itemPrice = 0.62;

        System.out.printf("The per item price is: $%.2f\n", itemPrice);

        // determine the shipping method
        System.out.println("Enter shipping method:");
        System.out.println("A - Federal Express");
        System.out.println("B - United Parcel Service (UPS)");
        System.out.println("C - DHL");
        System.out.println("D - United States Postal Service (USPS)");
        shipMethod = sc.next().charAt(0);

        // determine the shipping charge and company name
        switch (Character.toUpperCase(shipMethod)) {
            case 'A':
                shipCharge = 5.00;
                shipCompanyName = "Federal Express";
                break;
            case 'B':
                shipCharge = 7.20;
                shipCompanyName = "United Parcel Service (UPS)";
                break;
            case 'C':
                shipCharge = 10.00;
                shipCompanyName = "DHL";
                break;
            case 'D':
                shipCharge = 8.50; // Example for USPS
                shipCompanyName = "United States Postal Service (USPS)";
                break;
            default:
                shipCharge = 20.00;
                shipCompanyName = "Standard Shipping";
        }

        // Allow user to offer free shipping
        System.out.println("Offer free shipping? (true/false):");
        freeShipping = sc.nextBoolean();

        if (freeShipping) {
            shipCharge = 0.0;
            shipCompanyName = "Free Shipping";
        }

        System.out.printf("The shipping charge from %s is: $%.2f\n", shipCompanyName, shipCharge);

        // determine the discount validity
        System.out.println("Is discount period valid? (true or false)");
        check = sc.nextBoolean();

        if (check) {
            discountAmt = subTotal * discount;
            totAmt = subTotal * (1 - discount) + shipCharge;
            System.out.printf("Discount applied: $%.2f\n", discountAmt);
        } else {
            totAmt = subTotal + shipCharge;
        }

        System.out.printf("Total invoice amount due: $%.2f\n", totAmt);

        // Calculate and display savings if discount applied
        if (check) {
            double savedAmount = subTotal * discount;
            System.out.printf("You saved $%.2f dollars!\n", savedAmount);
        }

        // the program footer
        System.out.println("\nThank you!");
        System.out.println("---------------------");

        sc.close(); // dismiss the Scanner object
    }
}