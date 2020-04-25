/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLoader;

import java.util.ArrayList;
import java.util.Scanner;
import models.Assignment;
import validation.CheckFloatNumbers;
import validation.CheckIntegerNumbers;
import models.SchoolCourse;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class ShowCourseList {

    static Scanner sc = new Scanner(System.in);
    static String answer;

    public static void showCourseListToEnrollStudent(int num,
            ArrayList<SchoolCourse> schoolCourseList, Student student) {
        int courseChoice = 0;

        for (int i = 1; i <= num; i++) {
            do {
                System.out.println("Choose the "+i+" course by typing its number: ");
                for (int j = 0; j < schoolCourseList.size(); j++) {
                    System.out.println((j + 1) + "."
                            + schoolCourseList.get(j).getCourse().getTitle());
                }
                //We apply the method to validate the number that the user inputs
                // exist in the list (is between 1 and the list size)
                courseChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                        1, schoolCourseList.size());

                if (schoolCourseList.get(courseChoice - 1).
                        getStudentsPerCourse().contains(student)) {
                    System.out.println("This Student is already enrolled in "
                            + "that Course! Try again.");
                }
            } while (schoolCourseList.get(courseChoice - 1).
                    getStudentsPerCourse().contains(student));
            //We add Student in the StudentsPerCourse, inside the schoolCourse class
            schoolCourseList.get(courseChoice - 1).getStudentsPerCourse().add(student);
            ////Αuxiliary variable: assignmnets
            ArrayList<Assignment> assignments = schoolCourseList.
                    get(courseChoice - 1).getAssignmentsPerCourse();
            //deep copy of the assignmentList from the schoolCourseList to the Student class
            for (int z = 0; z < assignments.size(); z++) {
                Assignment studentAssignment = new Assignment(assignments.get(z));
                student.getAssignmentsPerStudent().add(studentAssignment);
                System.out.println("For theAssignment: " + studentAssignment.getTitle());
                System.out.println("Give me the Oral Mark(max 20): ");
                float oralMark = CheckFloatNumbers.checkFloatNumberForOralMark();
                studentAssignment.setOralMark(oralMark);
                System.out.println("Give me the Total Mark (max " + (80 + oralMark) + "): ");
                float totalMark = CheckFloatNumbers.checkFloatNumberForTotalMark(oralMark);
                studentAssignment.setTotalMark(totalMark);
            }
        }
    }

    public static void showCourseListToEnrollTrainer(int num,
            ArrayList<SchoolCourse> schoolCourseList, Trainer trainer) {
        int courseChoice = 0;
        for (int i = 1; i <= num; i++) {
            do {
                System.out.println("Choose the "+i+" course by typing its number: ");
                for (int j = 0; j < schoolCourseList.size(); j++) {
                    System.out.println((j + 1) + "."
                            + schoolCourseList.get(j).getCourse().getTitle());
                }
                //We apply the method to validate the number that the user inputs
                // exist in the list (is between 1 and the list size)
                courseChoice
                        = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                                1, schoolCourseList.size());
                if (schoolCourseList.get(courseChoice - 1).
                        getTrainersPerCourse().contains(trainer)) {
                    System.out.println("This Trainer is already enrolled in "
                            + "that Course! Try again.");
                }
            } while (schoolCourseList.get(courseChoice - 1).
                    getTrainersPerCourse().contains(trainer));
            schoolCourseList.get(courseChoice - 1).getTrainersPerCourse().add(trainer);
        }
    }
}
