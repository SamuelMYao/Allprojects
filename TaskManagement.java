import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Programmer: Sammy Student
public class TaskManagement {

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);

            // define the tasks
            ArrayList<String> theTasks = new ArrayList<String>(
                Arrays.asList("Task 1", "Task 2", "Task 3", "Task 4", "Task 5"));

            // define the task durations
            ArrayList<Integer> theDurations = new ArrayList<Integer>(
                Arrays.asList(20, 25, 18, 9, 13));

            // define the task status
            ArrayList<String> theStatus = new ArrayList<String>(
                Arrays.asList("Open", "Open", "Open", "Open", "Open"));

            // define the current task
            int num = 0;

            // define the processors
            int processor1 = 0;
            int processor2 = 0;

            // define the total running time
            int TRT = 0;

            // display initial data
            listTasks(theTasks);
            listDurations(theDurations);
            listStatus(theStatus);

            // commence the processing
            while (num < theTasks.size()) {
                // assign the duration of current task to processor 1
                processor1 += theDurations.get(num);

                // change the status of current task
                theStatus.set(num, "In Use");

                // update the total running time of the complete process
                TRT += theDurations.get(num);

                // show current process
                showProgress(num + 1, processor1, theStatus.get(num), TRT);

                // increment task number
                num++;

                // display current data
                listTasks(theTasks);
                listDurations(theDurations);
                listStatus(theStatus);

                // optional: add a delay to simulate processing time
                // Thread.sleep(1000); // uncomment and handle InterruptedException
            }

            // end of processing
            System.out.println("All tasks have been processed.");

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listTasks(ArrayList<String> tasks) {
        System.out.println(" ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.print(tasks.get(i) + "\t");
        }
        System.out.println(" ");
    }

    public static void listDurations(ArrayList<Integer> durations) {
        System.out.println(" ");
        for (int i = 0; i < durations.size(); i++) {
            System.out.print(durations.get(i) + "\t");
        }
        System.out.println(" ");
    }

    public static void listStatus(ArrayList<String> status) {
        System.out.println(" ");
        for (int i = 0; i < status.size(); i++) {
            System.out.print(status.get(i) + "\t");
        }
        System.out.println(" ");
    }

    public static void showProgress(int n, int processor, String s, int total) {
        System.out.println(" ");
        System.out.println("Task Number" + "\t" + n);
        System.out.println("task time" + "\t" + processor);
        System.out.println("task status" + "\t" + s);
        System.out.println("total time" + "\t" + total);
        System.out.println(" ");
    }
}
