/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printMethods;

import validation.CheckIntegerNumbers;
import models.SchoolCourse;
import models.Assignment;
import models.Student;
import models.Trainer;
import java.util.ArrayList;
import java.util.Scanner;
import validation.DateMethods;

/**
 *
 * @author ELIZA
 */
public class PrintChoice {

    static Scanner sc = new Scanner(System.in);
    static String answer;

    public static void askUserWhatToPrint(
            ArrayList<Student> studentList,
            ArrayList<Trainer> trainerList,
            ArrayList<Assignment> assignmentList,
            ArrayList<SchoolCourse> schoolCourseList) {

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
            System.out.println("10. To print all students that need to submit "
                    + "assignment/s within a week.");
            System.out.println("11. Nothing");
                  
            int printChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(1,11);

            switch (printChoice) {
                case 1:
                    PrintLists.printAllStudents(studentList);
                    break;
                case 2:
                    PrintLists.printAllTrainers(trainerList);
                    break;
                case 3:
                    PrintLists.printAllAssigniments(assignmentList);
                    break;
                case 4:
                    PrintLists.printAllCourses(schoolCourseList);
                    break;
                case 5:
                    PrintLists.printStudentsPerCourse(schoolCourseList);
                    break;
                case 6:
                    PrintLists.printTrainersPerCourse(schoolCourseList);
                    break;
                case 7:
                    PrintLists.printAssignmentsPerCourse(schoolCourseList);
                    break;
                case 8:
                    PrintLists.printAssignmentsPerStudent(studentList);
                    break;
                case 9:
                    ArrayList<Student> studentListInManyCourses
                            = PrintLists.findStudentsInManyCourses(studentList, schoolCourseList);
                    PrintLists.printStudentsThatBelongsInManyCourses(studentListInManyCourses);
                    break;
                case 10:
                    askUserADateAndPrintStudentsWithAssignments(studentList);
                    break;
                case 11:
                    System.out.println("Ok, no prints for you.");
            }
            System.out.println("Would you like to print something else? Yes or No?");
            answer = sc.next();
        } while (answer.equalsIgnoreCase("yes"));
        System.out.println("Goodbye!!!");
    }

    public static void askUserADateAndPrintStudentsWithAssignments(
            ArrayList<Student> studentList) {

        System.out.println("Give me a date to show you the students who need"
                + " to submit assignment/s in the same week (dd/MM/yyyy): ");
        ArrayList<Student> studentListWithAssignmentsInADateRange
                = DateMethods.createStudentListWithAssignmentsInADateRange(studentList);
        PrintLists.printStudentListWithAssignmnetsInADateRange(studentListWithAssignmentsInADateRange);
    }
}
