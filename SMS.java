import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student 
{
    private String name;
    private int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) 
    {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getRollNumber() 
    {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) 
    {
        this.rollNumber = rollNumber;
    }

    public char getGrade() 
    {
        return grade;
    }

    public void setGrade(char grade) 
    {
        this.grade = grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);

    }

    public Student searchStudent(int rollNumber) 
    {
        for (Student student : students) 
        {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() 
    {
        System.out.println("List of Students:");
        for (Student student : students) 
        {
            System.out.println("Name: " + student.getName() +
                    ", Roll Number: " + student.getRollNumber() +
                    ", Grade: " + student.getGrade());
        }
    }
}

public class SMS 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) 
        {
            System.out.println("Options:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    System.out.print("Enter grade: ");
                    char grade = scanner.next().charAt(0);

                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    system.removeStudent(rollToRemove);
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    Student searchedStudent = system.searchStudent(rollToSearch);
                    if (searchedStudent != null) 
                    {
                        System.out.println("Student found: " + searchedStudent.getName());
                    } else 
                    {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    system.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
