/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printMethods;

import database.SelectFromDatabase;
import validation.CheckIntegerNumbers;
import models.Assignment;
import models.Student;
import models.Trainer;
import java.util.ArrayList;
import java.util.Scanner;
import models.Course;
import validation.DateMethods;

/**
 *
 * @author ELIZA
 */
public class PrintChoice {

    static Scanner sc = new Scanner(System.in);
    static String answer;

    private PrintLists printer;
    private SelectFromDatabase selector;

    public PrintChoice() {
        printer = new PrintLists();
        selector = new SelectFromDatabase();
    }

    public void askUserWhatToPrint() {

        do {
            System.out.println("What would you like to print? Press :");
            System.out.println("1. To print all the students");
            System.out.println("2. To print all the trainers");
            System.out.println("3. To print all the assignments");
            System.out.println("4. To print all the courses");
            System.out.println("5. To print all the students per course");
            System.out.println("6. To print all the trainers per course");
            System.out.println("7. To print all the assignments per course");
            System.out.println("8. To print all the assignments per student");
            System.out.println("9. To print all the students that that belong "
                    + "to more than one courses");

            int printChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(1, 9);

            switch (printChoice) {
                case 1:
                    ArrayList<Student> studentList = selector.getStudentList();
                    printer.printAllStudents(studentList);
                    break;
                case 2:
                    ArrayList<Trainer> trainerList = selector.getTrainerList();
                    printer.printAllTrainers(trainerList);
                    break;
                case 3:
                    ArrayList<Assignment> assignmentList = selector.getAssignmentList();
                    printer.printAllAssigniments(assignmentList);
                    break;
                case 4:
                    ArrayList<Course> courseList = selector.getCourseList();
                    printer.printAllCourses(courseList);
                    break;
                case 5:
                    printer.selectAndPrintAllStudentsPerCourse();
                    break;
                case 6:
                    printer.selectAndPrintAllTrainersPerCourse();
                    break;
                case 7:
                    printer.selectAndPrintAllAssignmentsPerCourse();
                    break;
                case 8:
                    printer.selectAndPrintAllAssignmentsPerStudent();
                    break;
                case 9:
                    printer.selectAndPrintStudentsThatBelongsInManyCourses();
                    break;
            }
            System.out.println("Would you like to print something else? Yes or No?");
            answer = sc.next();
        } while (answer.equalsIgnoreCase("yes"));
        System.out.println("Goodbye!!!");
    }
}
