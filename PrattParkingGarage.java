//Moye Yao
import java.util.Scanner;
public class PrattParkingGarage {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        // Initialize local variables
        char answer = 'Y', specEvent = 'N', rateCode = '\0';
        int ticketNum = 0;
        int timeIn = 0, timeOut = 0, timeDiff = 0;
        double amountTendered = 0.0, changeDue = 0.0;
        double flatFee = 0.0, monthFee = 0.0;
        double EXTRA_CHARGE = 0.0;
        double coupon = 0.0, tip = 0.0;
        double flatTax = 3.00, totalDueFromCust = 0.0;

        // Accumulating variables
        double totalRevenue = 0.0;
        double totalTax = 0.0;
        double totalTip = 0.0;
        int couponUsers = 0; // Counter for customers using a coupon

        // Welcome message
        System.out.println("\n\n***************************");
        System.out.println("---- Pratt Parking Garage ----");
        System.out.println("***************************\n\n");

        // Main loop to process customer transactions
        while (answer == 'Y' || answer == 'y') {
            // Display menu
            System.out.println("--------- M E N U ---------");
            System.out.println("data entry process: enter each of these");

            // Input customer ticket number
            System.out.print("customer ticket number -> ");
            ticketNum = sc.nextInt();
            System.out.println("ticket number " + ticketNum);

            // Input time in (military)
            System.out.print("time in (military) -> ");
            timeIn = sc.nextInt();

            // Input time out (military)
            System.out.print("time out (military) -> ");
            timeOut = sc.nextInt();
            timeDiff = timeOut - timeIn;
            System.out.println("time difference " + timeDiff);

            // Input rate code: F or M
            System.out.print("rate code: (F or M) -> ");
            rateCode = sc.next().charAt(0);
            System.out.println("rate code: " + rateCode);

            // Process based on rate code
            if (rateCode == 'F') {
                flatFee = 10.00;
                totalDueFromCust = flatFee;
            } else if (rateCode == 'M') {
                monthFee = 90.00;
                totalDueFromCust = monthFee; // monthly fee is deferred
                totalDueFromCust = 0; // NOTE: This seems redundant, check logic
            }

            // Input tip amount
            System.out.print("tip amount -> ");
            tip = sc.nextDouble();
            System.out.printf("tip: $%.2f\n", tip);
            totalDueFromCust += tip;
            totalTip += tip; // Accumulate total tip amount

            // Display flat tax
            System.out.printf("flat tax: $%.2f\n", flatTax);
            totalDueFromCust += flatTax;
            totalTax += flatTax; // Accumulate total tax amount

            // Check for special event
            System.out.print("special event (Y or N)? -> ");
            specEvent = sc.next().charAt(0);
            if (specEvent == 'Y') {
                EXTRA_CHARGE = 10;
            }
            totalDueFromCust += EXTRA_CHARGE;

            // Input coupon amount
            System.out.print("coupon amount -> ");
            coupon = sc.nextDouble();
            totalDueFromCust -= coupon;
            if (coupon > 0) {
                couponUsers++;
            }

            // Display total charge to customer
            System.out.printf("total charge: $%.2f\n", totalDueFromCust);
            totalRevenue += totalDueFromCust; // Accumulate total revenue

            // Input amount tendered from customer
            System.out.print("amount tendered from customer -> ");
            amountTendered = sc.nextDouble();
            changeDue = amountTendered - totalDueFromCust;
            System.out.printf("change: $%.2f\n", changeDue);

            // Prompt to run again
            System.out.println("***************************");
            System.out.print("run again (Y or N)? -> ");
            answer = sc.next().charAt(0);

            // Reset variables for the next iteration
            // (customer) - Not clear in original code what variables should be reset
        }

        // Summary after the while loop
        System.out.println("\n\n----- Summary -----");
        System.out.printf("Total Revenue: $%.2f\n", totalRevenue);
        System.out.printf("Total Tax Collected: $%.2f\n", totalTax);
        System.out.printf("Total Tip Received: $%.2f\n", totalTip);
        System.out.printf("Number of Customers Using Coupons: %d\n", couponUsers);

        // End of program message
        System.out.println("***************************");

        // Close scanner object
        sc.close();
    }
}