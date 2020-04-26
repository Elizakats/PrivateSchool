/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import printMethods.PrintChoice;
import models.SchoolCourse;
import models.Assignment;
import models.Student;
import models.Trainer;
import java.util.ArrayList;
import java.util.Scanner;
import static dataLoader.AddInputsFromUser.addAssignmentsForEachCourseFromUserInput;
import static dataLoader.AddInputsFromUser.addCoursesFromUserInput;
import static dataLoader.AddInputsFromUser.addStudentsFromUserInput;
import static dataLoader.AddInputsFromUser.addTrainersFromUserInput;


/**
 *
 * @author ELIZA
 */
public class PrivateSchool {

    public static void privateSchool() {
        // Values initialization
        Scanner sc = new Scanner(System.in);
        String answer;

        ArrayList<Student> studentList = new ArrayList();
        ArrayList<Trainer> trainerList = new ArrayList();
        ArrayList<Assignment> assignmentList = new ArrayList();
        ArrayList<SchoolCourse> schoolCourseList = new ArrayList();

        System.out.println("Hello! Welcome to Private School Project!");

        do {
            System.out.println("If you want to print data press 1.\n"
                    + "If you want to add data press 2.");

            answer = sc.next();

            if (answer.equals("1")) {
                PrintChoice printChoise= new PrintChoice();
                printChoise.askUserWhatToPrint();
                

            } else if (answer.equals("2")) {

                // Fill data from User data
                addCoursesFromUserInput(schoolCourseList);

                addAssignmentsForEachCourseFromUserInput(assignmentList, schoolCourseList);

                addStudentsFromUserInput(studentList, schoolCourseList);

                addTrainersFromUserInput(trainerList, schoolCourseList);
            } else {
                System.out.println("Wrong input! try again: ");
            }
        } while ((!answer.equals("1")) && (!answer.equals("2")));

    }

}
