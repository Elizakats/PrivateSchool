/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printMethods;

import models.Assignment;
import models.Student;
import models.Trainer;
import java.util.ArrayList;
import models.Course;
import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ELIZA
 */
public class PrintLists extends DatabaseConnector {

    public void printAllStudents(ArrayList<Student> studentList) {
        System.out.println("All the Students are:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + "." + studentList.get(i));
        }
    }

    public void printAllTrainers(ArrayList<Trainer> trainerList) {
        System.out.println("All the Trainers are:");
        for (int i = 0; i < trainerList.size(); i++) {
            System.out.println((i + 1) + "." + trainerList.get(i));
        }
    }

    public void printAllCourses(ArrayList<Course> courseList) {
        System.out.println("All the Courses are:");
        for (int i = 0; i < courseList.size(); i++) {
            System.out.println((i + 1) + "." + courseList.get(i));
        }
    }

    public void printAllAssigniments(ArrayList<Assignment> assignmentList) {
        System.out.println("All the Assignments are:");
        for (int i = 0; i < assignmentList.size(); i++) {
            System.out.println((i + 1) + "." + assignmentList.get(i));
        }
    }
    
  
   
}
