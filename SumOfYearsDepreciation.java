import java.text.DecimalFormat;
import java.util.Scanner;

public class SumOfYearsDepreciation {

    // Global variables are declared
    static double assetCost = 0;
    static double salvageValue = 0;
    static double depreciableAmount = 0;
    static int assetLife = 0;

    // Declare a Scanner class object
    static Scanner sc = new Scanner(System.in);

    // Declare a DecimalFormat class object
    static DecimalFormat two = new DecimalFormat("0.00");

    // Method to receive asset information
    public static void AssetInfo() {
        // Declare and initialize a variable
        String assetType = "";

        // Display output block information
        System.out.println("[[ Asset Information ]]");

        // Request, receive and echo the asset type
        System.out.println("Please input the asset type:");
        assetType = sc.nextLine();
        System.out.println("Asset Type: " + assetType);

        // Request, receive, echo the asset cost, salvage value
        System.out.println("Please input the asset cost:");
        assetCost = sc.nextDouble();
        System.out.println("Asset Cost: " + two.format(assetCost));

        System.out.println("Please input the salvage value:");
        salvageValue = sc.nextDouble();
        System.out.println("Salvage Value: " + two.format(salvageValue));

        // Compute, echo depreciable amount as (cost - salvage)
        depreciableAmount = assetCost - salvageValue;
        System.out.println("Depreciable Amount: " + two.format(depreciableAmount));

        // Request, receive and echo the asset life
        System.out.println("Please input the asset life:");
        assetLife = sc.nextInt();
        System.out.println("Asset Life: " + assetLife);
    }

    // Method to sum the years
    public static int GaussSum(int num) {
        // Declare and initialize a variable
        int sumOfYears = 0;

        // Use Gauss Formula to sum the years
        sumOfYears = num * (num + 1) / 2;

        // Echo the sum of years
        System.out.println("Sum of years: " + sumOfYears);

        // Return the sum
        return sumOfYears;
    }

    // Method to show the depreciation schedule
    public static void ShowDepreciationSchedule() {
        System.out.println("\n[[ Depreciation Schedule ]]");
        int sumOfYears = GaussSum(assetLife);
        for (int year = 1; year <= assetLife; year++) {
            double depreciationExpense = depreciableAmount * (assetLife - year + 1) / sumOfYears;
            System.out.println("Year " + year + ": " + two.format(depreciationExpense));
        }
    }

    // Method to check if the total depreciation matches the depreciable amount
    public static void CheckDepreciation() {
        int sumOfYears = GaussSum(assetLife);
        double totalDepreciation = 0;
        for (int year = 1; year <= assetLife; year++) {
            double depreciationExpense = depreciableAmount * (assetLife - year + 1) / sumOfYears;
            totalDepreciation += depreciationExpense;
        }
        System.out.println("Total Depreciation: " + two.format(totalDepreciation));
        if (Math.abs(totalDepreciation - depreciableAmount) < 0.01) {
            System.out.println("Total depreciation matches the depreciable amount.");
        } else {
            System.out.println("Total depreciation does not match the depreciable amount.");
        }
    }

    public static void main(String[] args) {
        // Declare and initialize the local variable(s)
        String userName = "";

        // Display output block information
        System.out.println("<< Sum of Years Digits Program >>");

        // Meet and greet the program user
        System.out.println("Please enter your name: ");
        userName = sc.nextLine();
        System.out.println("Welcome: " + userName + "\n");

        // Call the AssetInfo() method
        AssetInfo();

        // Call the GaussSum() method
        GaussSum(assetLife);

        // Call the ShowDepreciationSchedule() method
        ShowDepreciationSchedule();

        // Call the CheckDepreciation() method
        CheckDepreciation();
    }
}
