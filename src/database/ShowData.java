/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.Scanner;
import models.Assignment;
import models.Course;
import validation.CheckIntegerNumbers;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class ShowData {

    static Scanner sc = new Scanner(System.in);
    static String answer;
    static SelectFromDatabase select;

    public int showCourseListAndGetCourseId() {
        select = new SelectFromDatabase();
        ArrayList<Course> courseList = new ArrayList<>(select.getCourseList());
        int courseChoice;

        System.out.println("Choose the course by typing its number: ");
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println((i + 1) + "."
                    + courseList.get(i).getTitle());
        }
        //We apply the method to validate the number that the user inputs
        // exist in the list (is between 1 and the list size)
        courseChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                1, courseList.size());
        int courseId = courseList.get(courseChoice - 1).getCourseId();

        return courseId;

    }

    public int showStudentListAndGetStudentId() {
        select = new SelectFromDatabase();
        ArrayList<Student> studentList = new ArrayList<>(select.getStudentList());
        int studentChoice;

        System.out.println("Choose the student by typing its number: ");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + "."
                    + studentList.get(i).getFirstName() + " "
                    + studentList.get(i).getLastName());
        }
        //We apply the method to validate the number that the user inputs
        // exist in the list (is between 1 and the list size)
        studentChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                1, studentList.size());
        int studentId = studentList.get(studentChoice - 1).getStudentId();

        return studentId;

    }

    public int showTrainerListAndGetTrainerId() {
      select = new SelectFromDatabase();
        ArrayList<Trainer> trainerList = new ArrayList<>(select.getTrainerList());
        int trainerChoice;

        System.out.println("Choose the trainer that you want to enroll to a "
                + "course by typing its number: ");
        for (int i = 0; i < trainerList.size(); i++) {
            System.out.println((i + 1) + "."
                    + trainerList.get(i).getFirstName() + " "
                    + trainerList.get(i).getLastName());
        }
        //We apply the method to validate the number that the user inputs
        // exist in the list (is between 1 and the list size)
        trainerChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                1, trainerList.size());
        int trainerId = trainerList.get(trainerChoice - 1).getTrainerId();

        return trainerId;
    }

    public int showAssignmentListAndGetAssignmnetId(int studentId) {
        select = new SelectFromDatabase();
        ArrayList<Assignment> assignmentList = new ArrayList<>(select.getAssignmentListForAStudent(studentId));
        int assignmentChoice;

        System.out.println("Choose the assignment that you want to fill with "
                + "student's grades: ");
        for (int i = 0; i < assignmentList.size(); i++) {
            System.out.println((i + 1) + "."
                    + assignmentList.get(i).getTitle() + " "
                    + assignmentList.get(i).getDescription());
        }
        //We apply the method to validate the number that the user inputs
        // exist in the list (is between 1 and the list size)
        assignmentChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(
                1, assignmentList.size());
        int assignmentId = assignmentList.get(assignmentChoice - 1).getAssignmentId();

        return assignmentId;

    }

}
