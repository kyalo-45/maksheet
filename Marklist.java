package marklist;

import java.util.Scanner;

public class Marklist {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

	System.out.print("Enter the number of students: ");
	int numStudents = scanner.nextInt();
	scanner.nextLine();

	String[][] studentData = new String[numStudents][9]; // multidimensional array to store student data

	for (int i = 0; i < numStudents; i++) {
	    System.out.println("");
	    System.out.print("Enter the Student Roll Number: ");
	    String rollNumber = scanner.next();

	    System.out.print("Enter the Student Name: ");
	    scanner.nextLine();
	    String name = scanner.nextLine();
	    System.out.println("");

	    System.out.print("Enter the Three Marks(separated by spaces): ");
	    String[] input = scanner.nextLine().split(" ");

	    studentData[i][0] = rollNumber; // roll number
	    studentData[i][1] = name; // name
	    studentData[i][2] = input[0]; // mark 1
	    studentData[i][3] = input[1]; // mark 2
	    studentData[i][4] = input[2]; // mark 3

	    int marks1 = Integer.parseInt(studentData[i][2]);
	    int marks2 = Integer.parseInt(studentData[i][3]);
	    int marks3 = Integer.parseInt(studentData[i][4]);

	    int totalMarks = marks1 + marks2 + marks3;
	    float average = (float) totalMarks / 3;
	    String grade = calculateGrade(average);

	    char result;
	    if (marks1 >= 50 && marks2 >= 50 && marks3 >= 50) {
		result = 'P';
	    } else {
		result = 'F';
	    }

	    studentData[i][5] = Integer.toString(totalMarks);
	    studentData[i][6] = Character.toString(result);
	    studentData[i][7] = String.format("%.1f", average);
	    studentData[i][8] = grade;

	    System.out.println("The Total is: " + totalMarks);
	}
	scanner.close();
	System.out.println("");

	System.out.println("*********************************************************************");
	System.out.println("\t\t\tSTUDENT MARKLIST");
	System.out.println("*********************************************************************");
	System.out.printf("%-6s%-10s%-6s%-6s%-6s%-6s%-7s%-8s%-6s\n", "ROLL", "NAME", "MARK1", "MARK2", "MARK3", "TOTAL",
		"RESULT", "AVERAGE", "GRADE");
	for (int i = 0; i < numStudents; i++) {
	    System.out.printf("%-6s%-10s%-6s%-6s%-6s%-6s%-7s%-8s%-6s\n", studentData[i][0], studentData[i][1],
		    studentData[i][2], studentData[i][3], studentData[i][4], studentData[i][5], studentData[i][6],
		    studentData[i][7], studentData[i][8]);
	}
    }

    public static String calculateGrade(float average) {
	if (average >= 70) {
	    return "A";
	} else if (average >= 50) {
	    return "B";
	} else {
	    return "C";
	}
    }
}
