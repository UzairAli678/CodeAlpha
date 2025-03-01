import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);
        }
        
        int highest = grades.get(0);
        int lowest = grades.get(0);
        int sum = 0;
        
        for (int grade : grades) {
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
            sum += grade;
        }
        
        double average = (double) sum / numStudents;
        
        System.out.println("\nGrade Summary:");
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.printf("Average Grade: %.2f\n", average);
        
        scanner.close();
    }
}
