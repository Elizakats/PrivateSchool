/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;


/**
 *
 * @author ELIZA
 */
public class SchoolCourse {
    private final Course course;
    private ArrayList<Trainer> trainersPerCourse;
    private ArrayList<Student> studentsPerCourse;
    private ArrayList<Assignment> assignmentsPerCourse;
    
    public SchoolCourse(Course course)
    {
        this.course = course;
        trainersPerCourse = new ArrayList<>();
        studentsPerCourse = new ArrayList<>();
        assignmentsPerCourse = new ArrayList<>();
    }

    public Course getCourse() {
        return course;
    }

    public ArrayList<Trainer> getTrainersPerCourse() {
        return trainersPerCourse;
    }

    public void setTrainersPerCourse(ArrayList<Trainer> trainersPerCourse) {
        this.trainersPerCourse = trainersPerCourse;
    }

    public ArrayList<Student> getStudentsPerCourse() {
        return studentsPerCourse;
    }

    public void setStudentsPerCourse(ArrayList<Student> studentsPerCourse) {
        this.studentsPerCourse = studentsPerCourse;
    }

    public ArrayList<Assignment> getAssignmentsPerCourse() {
        return assignmentsPerCourse;
    }

    public void setAssignmentsPerCourse(ArrayList<Assignment> assignmentsPerCourse) {
        this.assignmentsPerCourse = assignmentsPerCourse;
    }

   
    
    
    
    
}
