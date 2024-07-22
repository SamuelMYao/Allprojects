import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Sammy Student: Data Analysis with Java File Processing
public class DataAnalytics {

    public static void main(String args[]) {
        // declare an object to receive the data
        Scanner scan = new Scanner(System.in);
        // declare an array list to hold the data
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int num = 0;
        int val = 0;
        String line = "";

        try {
            // create or append to the file
            FileWriter fileOut = new FileWriter("outData.txt");
            BufferedWriter fout = new BufferedWriter(fileOut);

            System.out.println("How many data items?");
            count = scan.nextInt();
            for (int i = 1; i <= count; i++) {
                System.out.println("Enter a data value:");
                val = scan.nextInt();
                fout.write(val + "\n");
            }

            System.out.println("Thank you... the data has been recorded!");

            // close the output stream objects
            fout.close();
            fileOut.close();
            scan.close();
        } catch (Exception e) {
            // catch an exception if any arises
            System.err.println("Error: " + e.getMessage());
        }

        try {
            // read the data
            FileReader fileIn = new FileReader("outData.txt");
            BufferedReader fin = new BufferedReader(fileIn);

            while ((line = fin.readLine()) != null) {
                num = Integer.parseInt(line);
                list.add(num);
                System.out.println(num);
            }

            System.out.println("Thank you... the data has been received!");
            System.out.println("Display unsorted data:");
            DisplayData(list);

            fin.close();
            fileIn.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        BubbleSort(list);

        System.out.println("Display sorted data:");
        DisplayData(list);

        // Example of calling the searchData method
        ArrayList<String> vals = new ArrayList<>();
        vals.add("John");
        vals.add("Doe");
        vals.add("Jane");
        searchData(vals);
    }

    public static void DisplayData(ArrayList<Integer> num) {
        for (int i = 0; i < num.size(); i++) {
            System.out.println(num.get(i).toString());
        }
    }

    public static void BubbleSort(ArrayList<Integer> num) {
        int j = 0;
        boolean flag = true; // set the flag to true to begin first pass
        int temp = 0; // define the holding variable

        while (flag) {
            flag = false; // set flag to false awaiting a possible swap

            for (j = 0; j < num.size() - 1; j++) {
                if (num.get(j) > num.get(j + 1)) {
                    // for descending sort change to <
                    temp = num.get(j); // swap the elements
                    num.set(j, num.get(j + 1));
                    num.set(j + 1, temp);
                    flag = true; // shows a swap occurred
                }
            }
        }
    }

    public static void searchData(ArrayList<String> vals) {
        System.out.print("Enter a name: ");
        Scanner sc = new Scanner(System.in);
        String strName = sc.nextLine().trim();
        boolean found = false;

        for (int i = 0; i < vals.size(); i++) {
            if (vals.get(i).equals(strName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Data found.");
        } else {
            System.out.println("Data not found.");
        }

        sc.close();
    }
}
