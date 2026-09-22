import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        double[] marks = new double[n];

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String highestStudent = "";
        String lowestStudent = "";

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter name: ");
            names[i] = sc.next();

            System.out.print("Enter marks: ");
            marks[i] = sc.nextDouble();

            total = total + marks[i];

            if (marks[i] > highest) {
                highest = marks[i];
                highestStudent = names[i];
            }

            if (marks[i] < lowest) {
                lowest = marks[i];
                lowestStudent = names[i];
            }
        }

        double average = total / n;

        // Display report
        System.out.println("\n========== STUDENT REPORT ==========");

        for (int i = 0; i < n; i++) {
            System.out.println(
                names[i] + " : " + marks[i]
            );
        }

        System.out.println("------------------------------------");
        System.out.println("Average Marks : " + average);
        System.out.println("Highest Marks : " + highest +
                           " (" + highestStudent + ")");
        System.out.println("Lowest Marks  : " + lowest +
                           " (" + lowestStudent + ")");

        sc.close();
    }
}