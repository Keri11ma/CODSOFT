package codsoft.student.grade.calculator;
import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();
        scanner.nextLine();

        String[] subjectTypes = new String[subjects];
        int[] marks = new int[subjects];


        for (int i = 0; i < subjects; i++) {
            System.out.println("Enter the type of subject " + (i +1) + ": ");
            subjectTypes[i] = scanner.nextLine();
            System.out.print("Enter marks for subject " + subjectTypes[i] + ": ");
            marks[i] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("\nSubject\t\tMarks");
        System.out.println("-------\t\t-----");
        for (int i = 0; i < subjects; i++) {
            System.out.println(subjectTypes[i] + "\t\t" + marks[i]);

        }

        int totalMarks = 0;

        for (int mark:marks) {
            totalMarks += mark;

        }

        double averagePercentage = (double) totalMarks / subjects;

        String grade;

        if (averagePercentage >= 95) {
            grade = "A+";
        } else if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 85) {
            grade = "B+";
        } else if (averagePercentage >= 80) {
            grade = "B";
        }else if (averagePercentage >= 75) {
            grade = "C+";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 65) {
            grade = "D";
        } else if (averagePercentage >= 55) {
            grade = "E";
        } else if (averagePercentage >= 45) {
            grade = "F";
        }else{
            grade = "Error grading this results";
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("The student grade is: " + grade);
    }
}


