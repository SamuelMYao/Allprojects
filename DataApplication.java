import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Programmer: Sammy Student
public class DataApplication {

    public static void main(String[] args) {
        ArrayList<String> theData = new ArrayList<String>();

        // Read data from file and populate theData ArrayList
        readDataFromFile("data.txt", theData);

        // Display all data
        displayData(theData);

        // Example of calling the searchData method
        searchData(theData);

        // Example of calling the method to find consultants with fees exceeding $2,000
        findConsultantsWithHighFees(theData);

        // Example of calling the method to count consultants specializing in media services
        countMediaSpecialists(theData);
    }

    public static void readDataFromFile(String filename, ArrayList<String> dataList) {
        try {
            File fin = new File(filename);
            Scanner scan = new Scanner(fin);

            // read the column headings from the flat text file (assuming first line is header)
            if (scan.hasNextLine()) {
                scan.nextLine(); // Skip header line
            }

            // read data lines
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                dataList.add(line);
            }

            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayData(ArrayList<String> dataList) {
        System.out.println("Displaying data:");
        for (String data : dataList) {
            System.out.println(data);
        }
    }

    public static void searchData(ArrayList<String> dataList) {
        System.out.print("Enter a name to search: ");
        Scanner sc = new Scanner(System.in);
        String strName = sc.nextLine().trim();
        boolean found = false;

        for (String data : dataList) {
            String[] parts = data.split(",");
            if (parts.length >= 2 && parts[1].trim().equalsIgnoreCase(strName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Data found for name: " + strName);
        } else {
            System.out.println("Data not found for name: " + strName);
        }

        sc.close();
    }

    public static void findConsultantsWithHighFees(ArrayList<String> dataList) {
        System.out.println("Consultants with fees exceeding $2,000:");

        for (String data : dataList) {
            String[] parts = data.split(",");
            if (parts.length >= 3) {
                try {
                    int fee = Integer.parseInt(parts[2].trim());
                    if (fee > 2000) {
                        System.out.println("Name: " + parts[1].trim() + ", Fee: $" + fee);
                    }
                } catch (NumberFormatException e) {
                    // Handle parsing error if fee is not a valid integer
                    continue;
                }
            }
        }
    }

    public static void countMediaSpecialists(ArrayList<String> dataList) {
        int mediaCount = 0;

        for (String data : dataList) {
            String[] parts = data.split(",");
            if (parts.length >= 4 && parts[3].trim().equalsIgnoreCase("media")) {
                mediaCount++;
            }
        }

        System.out.println("Number of consultants specializing in media services: " + mediaCount);
    }
}
