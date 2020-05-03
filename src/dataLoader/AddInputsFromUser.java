/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLoader;

import database.DatabaseConnector;
import database.SelectFromDatabase;
import java.time.LocalDate;
import validation.DateMethods;
import java.util.ArrayList;
import java.util.Scanner;
import models.Assignment;
import validation.CheckFloatNumbers;
import validation.CheckIntegerNumbers;
import models.Course;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class AddInputsFromUser extends DatabaseConnector {

    static Scanner sc = new Scanner(System.in);
    static String answer;

    public Student takeStudentFromUserInput() {

        Student student = new Student();
        // We ask from the user the data
        System.out.print("Give me the Student's First Name and Last Name: ");
        student.setFirstName(sc.next());
        student.setLastName(sc.next());
        System.out.print("Give the student's Date of Birth (dd/MM/yyyy): ");
        student.setDateOfBirth(DateMethods.stringToDateFromScanner());
        System.out.print("Give the Student's Tuition Fees: ");
        // We apply the method to validate the float number
        float fees = CheckFloatNumbers.checkFloatNumberForFees();
        student.setTuitionFees(fees);

        return student;
    }

    public Trainer takeTrainerFromUserInput() {
        Trainer trainer = new Trainer();
        // We ask from the user the data
        System.out.print("Give me the Trainer's First Name and Last Name: ");
        trainer.setFirstName(sc.next());
        trainer.setLastName(sc.next());
        System.out.println("Give me the Trainer's subject(Java, C# or Front-End): ");
        trainer.setSubject(sc.next());
        return trainer;
    }

    public Assignment takeAssignmentFromUserInput() {

        SelectFromDatabase selectFromDatabase = new SelectFromDatabase();
        System.out.println("For which Course you want to create the Assignment?");
        System.out.println("Press the number of the Course: ");
        ArrayList<Course> courseList = new ArrayList<>(selectFromDatabase.getCourseList());
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println(i + 1 + "." + courseList.get(i).getTitle());
        }

        int courseChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                1, courseList.size());
        int courseId = courseList.get(courseChoice - 1).getCourseId();

        Assignment assignment = new Assignment();
        // We ask from the user the data
        System.out.println("Give me the Assignment's Title: ");
        assignment.setTitle(sc.next());
        System.out.println("Give me the Assignment's Description "
                + "(Individual or Team):");
        assignment.setDescription(sc.next());
        System.out.println("Give me the Assignment's Submision Date "
                + "(dd/MM/yyyy): ");
        LocalDate assDate = DateMethods.stringToDateFromScanner();
        // assDate = DateMethods.dateWithinLimits(assDate, startDate, endDate);
        assignment.setSubDateTime(assDate);
        System.out.println("Give me the Assignment's max oral mark(max total mark is 100): ");
        float maxOralMark = CheckFloatNumbers.checkFloatNumberForOralMark(100f);
        assignment.setOralMark(maxOralMark);
        assignment.setTotalMark(100f);
        assignment.setCourseId(courseId);

        return assignment;
    }

    public Course takeCourseFromUserInput() {

        Course course = new Course();
        // We ask from the user the data
        System.out.print("Give me the Course's Title: ");
        course.setTitle(sc.next());
        System.out.print("Give me the Course's Stream (Java or C#): ");
        course.setStream(sc.next());
        System.out.print("Give me the Course's Type (Full or Part time): ");
        course.setType(sc.next());
        System.out.print("Give me the Course's Start Date (dd/MM/yyyy): ");
        LocalDate startDate = DateMethods.stringToDateFromScanner();
        course.setStart_date(startDate);
        System.out.print("Give me the Course's End Date (dd/MM/yyyy): ");
        LocalDate endDate = DateMethods.stringToDateFromScanner();
        //We apply the method to Validate that the date the Course ends
        //is after the date that the Course starts
        endDate = DateMethods.dateEndIsBeforeDateStart(startDate, endDate);
        course.setEnd_date(endDate);

        return course;
    }
}
//  LocalDate startDate = schoolCourseList.get(i).getCourse().getStart_date();
//  LocalDate endDate = schoolCourseList.get(i).getCourse().getEnd_date();
//            System.out.println("In how many courses this student belongs? "
//                    + "The Max number of Courses is: " + schoolCourseList.size());
//            //We apply the method to validate the number that the user inputs
//            // exist in the list (is between 1 and the list size)
//            int num = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
//                    1, schoolCourseList.size());
//
//            //We apply the method to enroll the Student in Courses and their Assignments
//            ShowCourseList.showCourseListToEnrollStudent(num, schoolCourseList, student);
//        System.out.println("Would you like to add another Student? Yes or No?");
//        // As long as the user types "yes", we add a new Student
//        answer = sc.next();
//        System.out.println("In how many courses this trainer teaches? "
//                + "The Max number of Courses is: " + schoolCourseList.size());
//        //We apply the method to validate the number that the user inputs
//        // exist in the list (is between 1 and the list size)
//        int num = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
//                1, schoolCourseList.size());
//        //We apply the method to enroll the Trainer in Courses
//        ShowCourseList.showCourseListToEnrollTrainer(num, schoolCourseList, trainer);
//
//        System.out.print("Would you like to add another Trainer? Yes or No?");
//        answer = sc.next();
//        // As long as the user types "yes", we add a new Trainer
//    }
//
//    while (answer.equalsIgnoreCase (
//            
//
//"yes"));
//    }

