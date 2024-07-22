import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

// Moye Yao, Programmer
public class RetailStore {
    Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        int rows = 6;
        int columns = 8;
        int[][] table = new int[rows][columns];
        Random randomGen = new Random();
        StringBuilder s = new StringBuilder();
        int randomInt1 = 0;
        int randomInt2 = 0;

        // Generate column titles
        for (int j = 0; j < columns; j++) {
            s.append("\thr " + (j + 1));
        }
        s.append("\n\n");

        // Populate data for each cashier lane
        for (int i = 0; i < rows; i++) {
            s.append("lane " + (i + 1));
            s.append("\t");
            for (int j = 0; j < columns; j++) {
                // Express checkout lane
                randomInt1 = 1 + randomGen.nextInt(20);
                // Standard checkout lane
                randomInt2 = 1 + randomGen.nextInt(10);
                if (i == 0)
                    table[i][j] = randomInt1;
                else
                    table[i][j] = randomInt2;
                s.append(table[i][j]);
                s.append(" ");
                s.append("\t");
            }
            s.append("\n");
        }
        System.out.println("data simulation: \n\n" + s);
        System.out.println("");

        // Perform data analysis
        // Row analysis
        String str = JOptionPane.showInputDialog(null, "enter a cashier lane number : ");
        // Subtract 1 to compensate for a zero-indexed array
        int laneNum = Integer.parseInt(str) - 1;
        double average = 0.0, sum = 0.0;
        for (int j = 0; j < columns; j++) {
            sum += table[laneNum][j];
        }
        average = sum / columns;
        System.out.println("");
        String outputMsg = "";
        outputMsg += "\n for cashier lane " + (laneNum + 1);
        outputMsg += "\n the data analysis is: ";
        outputMsg += "\n customer count -> " + Math.round(sum);
        outputMsg += "\n average -> " + Math.round(average);
        if (average > 10) {
            outputMsg += "\n Schedule another Bagging Clerk";
        }
        JOptionPane.showMessageDialog(null, outputMsg, "Data Row Analysis", JOptionPane.PLAIN_MESSAGE);

        // Column analysis
        str = JOptionPane.showInputDialog(null, "enter an hour number : ");
        // Subtract 1 to compensate for a zero-indexed array
        int hourNum = Integer.parseInt(str) - 1;
        // Reset the accumulating variable
        sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += table[i][hourNum];
            System.out.println(table[i][hourNum]);
        }
        average = sum / rows;
        System.out.println("");
        outputMsg = "";
        outputMsg += "\n for hour number " + (hourNum + 1);
        outputMsg += "\n the data analysis is: ";
        outputMsg += "\n customer count -> " + Math.round(sum);
        outputMsg += "\n average -> " + Math.round(average);
        if (average > 10) {
            outputMsg += "\n Schedule another Bagging Clerk";
        }
        JOptionPane.showMessageDialog(null, outputMsg, "Data Column Analysis", JOptionPane.PLAIN_MESSAGE);

        // Determine the total number of customers served in all cashier lanes
        int totalCustomers = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                totalCustomers += table[i][j];
            }
        }
        System.out.println("Total number of customers served in all cashier lanes: " + totalCustomers);
    }
}
