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
import static dataLoader.SyntheticData.addSyntheticsCourses;
import static dataLoader.SyntheticData.addSyntheticsAssignments;
import static dataLoader.SyntheticData.addSyntheticsStudents;
import static dataLoader.SyntheticData.addSyntheticsTrainers;

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

        System.out.print(
                "Hello! Would you like to add data or you would like to use synthetics?\nPress 1 to add or  something else to use synthetics:");
        answer = sc.next();

        if (answer.equals("1")) {

            // Fill data from User data
            addCoursesFromUserInput(schoolCourseList);

            addAssignmentsForEachCourseFromUserInput(assignmentList, schoolCourseList);

            addStudentsFromUserInput(studentList, schoolCourseList);

            addTrainersFromUserInput(trainerList, schoolCourseList);
        } else {

            // Fill data with Synthetics
            addSyntheticsCourses(schoolCourseList);

            addSyntheticsAssignments(schoolCourseList, assignmentList);

            addSyntheticsStudents(studentList, schoolCourseList);

            addSyntheticsTrainers(trainerList, schoolCourseList);

        }
        //Print selection
        PrintChoice.askUserWhatToPrint(studentList, trainerList, assignmentList, schoolCourseList);
    }
}
