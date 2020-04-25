/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLoader;

import java.time.LocalDate;
import validation.DateMethods;
import java.util.ArrayList;
import java.util.Scanner;
import models.Assignment;
import validation.CheckFloatNumbers;
import validation.CheckIntegerNumbers;
import models.Course;
import models.SchoolCourse;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class AddInputsFromUser {

    static Scanner sc = new Scanner(System.in);
    static String answer;

    public static void addCoursesFromUserInput(
            ArrayList<SchoolCourse> schoolCourseList) {
        System.out.println("Give me at least one Course.");
        // We apply do-while to give the user the ability to give as many data 
        //as they want
        do {
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
            // Creation of a new SchoolCourse and we put inside it the new Course
            // we created in line 33 
            // We add the SchoolCourse in the list:
            schoolCourseList.add(new SchoolCourse(course));

            System.out.println("Would you like to add another Course? Yes or No?");
            answer = sc.next();
            // As long as the user types "yes", we add a new Course
        } while (answer.equalsIgnoreCase("yes"));
    }

    public static void addAssignmentsForEachCourseFromUserInput(
            ArrayList<Assignment> assignmentList,
            ArrayList<SchoolCourse> schoolCourseList) {

        System.out.println("Give me at least one Assignment for each Course.");
        for (int i = 0; i < schoolCourseList.size(); i++) {
            System.out.println("For the Course: "
                    + schoolCourseList.get(i).getCourse().getTitle());
            LocalDate startDate = schoolCourseList.get(i).getCourse().getStart_date();
            LocalDate endDate = schoolCourseList.get(i).getCourse().getEnd_date();
            // We apply do-while to give the user the ability to give as many
            //data as they want
            do {
                Assignment assignment = new Assignment();
                // We ask from the user the data
                System.out.println("Give me the Assignment's Title: ");
                assignment.setTitle(sc.next());
                System.out.println("Give me the Assignment's Description "
                        + "(Individual or Team):");
                assignment.setDescription(sc.next());
                System.out.println("Give me the Assignment's Submision Date Time "
                        + "(dd/MM/yyyy): ");
                LocalDate assDate = DateMethods.stringToDateFromScanner();
                assDate = DateMethods.dateWithinLimits(assDate, startDate, endDate);
                assignment.setSubDateTime(assDate);
                //We add the new assignment in the simple assignmentList
                assignmentList.add(assignment);
                //We add the new assignment in the list of the assignments 
                //inside the schoolCourse class
                schoolCourseList.get(i).getAssignmentsPerCourse().add(assignment);
                System.out.println("Would you like to add another Assignments "
                        + "for the same Course? Yer or No?");
                answer = sc.next();
                // As long as the user types "yes", we add a new Assignment
            } while (answer.equalsIgnoreCase("yes"));
        }
    }

    public static void addStudentsFromUserInput(ArrayList<Student> studentList,
            ArrayList<SchoolCourse> schoolCourseList) {
        // We apply do-while to give the user the ability to give as many data 
        //as they want
        System.out.println("Give me at least one Student.");
        do {
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

            //We add the new Student(line 97) to the studentList
            studentList.add(student);

            System.out.println("In how many courses this student belongs? "
                    + "The Max number of Courses is: " + schoolCourseList.size());
            //We apply the method to validate the number that the user inputs
            // exist in the list (is between 1 and the list size)
            int num = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                    1, schoolCourseList.size());

            //We apply the method to enroll the Student in Courses and their Assignments
            ShowCourseList.showCourseListToEnrollStudent(num, schoolCourseList, student);

            System.out.println("Would you like to add another Student? Yes or No?");
            // As long as the user types "yes", we add a new Student
            answer = sc.next();
        } while (answer.equalsIgnoreCase(
                "yes"));
    }

    public static void addTrainersFromUserInput(ArrayList<Trainer> trainerList,
            ArrayList<SchoolCourse> schoolCourseList) {
        System.out.println("Give me at least one Trainer.");
        // We apply do-while to give the user the ability to give as many data 
        //as they want
        do {
            Trainer trainer = new Trainer();
            // We ask from the user the data
            System.out.print("Give me the Trainer's First Name and Last Name: ");
            trainer.setFirstName(sc.next());
            trainer.setLastName(sc.next());
            System.out.println("Give me the Trainer's subject(Java, C# or Front-End): ");
            trainer.setSubject(sc.next());
            trainerList.add(trainer);

            System.out.println("In how many courses this trainer teaches? "
                    + "The Max number of Courses is: " + schoolCourseList.size());
            //We apply the method to validate the number that the user inputs
            // exist in the list (is between 1 and the list size)
            int num = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                    1, schoolCourseList.size());
            //We apply the method to enroll the Trainer in Courses
            ShowCourseList.showCourseListToEnrollTrainer(num, schoolCourseList, trainer);

            System.out.print("Would you like to add another Trainer? Yes or No?");
            answer = sc.next();
            // As long as the user types "yes", we add a new Trainer
        } while (answer.equalsIgnoreCase("yes"));
    }

}
