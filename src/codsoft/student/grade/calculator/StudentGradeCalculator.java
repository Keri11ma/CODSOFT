package codsoft.student.grade.calculator;
import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();

        int[] marks = new int[subjects];
        int totalMarks = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / subjects;

        String grade;

        if (averagePercentage >= 85) {
            grade = "A";
        } else if (averagePercentage >= 75) {
            grade = "B";
        } else if (averagePercentage >= 65) {
            grade = "C";
        } else if (averagePercentage >= 55) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("The student grade is: " + grade);
    }
}


