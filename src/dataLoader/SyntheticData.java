/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLoader;

import validation.DateMethods;
import java.util.ArrayList;
import models.Assignment;
import models.Course;
import models.SchoolCourse;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class SyntheticData {

    public static void addSyntheticsCourses(ArrayList<SchoolCourse> schoolCourseList) {
        String date1 = "01/01/2017";
        String date2 = "01/04/2017";
        String date3 = "01/04/2019";
        String date4 = "01/04/2019";
        String date5 = "01/10/2019";
        String date6 = "01/04/2020";

        Course cr1 = new Course("CB1", "Java", "Full time",
                DateMethods.stringToDate(date1), DateMethods.stringToDate(date2));
        Course cr2 = new Course("CB8", "C#", "Full time",
                DateMethods.stringToDate(date3), DateMethods.stringToDate(date4));
        Course cr3 = new Course("CB9", "C#", "Part Time",
                DateMethods.stringToDate(date5), DateMethods.stringToDate(date6));
        schoolCourseList.add(new SchoolCourse(cr1));
        schoolCourseList.add(new SchoolCourse(cr2));
        schoolCourseList.add(new SchoolCourse(cr3));

    }

    public static void addSyntheticsAssignments(
            ArrayList<SchoolCourse> schoolCourseList,
            ArrayList<Assignment> assignmentList) {
        String assDate1 = "01/04/2020";
        String assDate2 = "15/05/2020";
        String assDate3 = "30/06/2020";
        String assDate4 = "25/07/2020";
        String assDate5 = "16/09/2020";
        String assDate6 = "05/11/2020";
        Assignment ass1 = new Assignment("Project 1", "Individual",
                DateMethods.stringToDate(assDate1), 0, 0);
        Assignment ass2 = new Assignment("Project 2", "Team",
                DateMethods.stringToDate(assDate2), 0, 0);
        Assignment ass3 = new Assignment("Project 3", "Individual",
                DateMethods.stringToDate(assDate3), 0, 0);
        Assignment ass4 = new Assignment("Project 4", "Team",
                DateMethods.stringToDate(assDate4), 0, 0);
        Assignment ass5 = new Assignment("Project 5", "Individual",
                DateMethods.stringToDate(assDate5), 0, 0);
        Assignment ass6 = new Assignment("Project 6", "Team",
                DateMethods.stringToDate(assDate6), 0, 0);
        assignmentList.add(ass1);
        assignmentList.add(ass2);
        assignmentList.add(ass3);
        assignmentList.add(ass4);
        assignmentList.add(ass5);
        assignmentList.add(ass6);

        //Αuxiliary variables
        SchoolCourse schoolCourse0 = schoolCourseList.get(0);
        SchoolCourse schoolCourse1 = schoolCourseList.get(1);
        SchoolCourse schoolCourse2 = schoolCourseList.get(2);

        schoolCourse0.getAssignmentsPerCourse().add(ass1);
        schoolCourse0.getAssignmentsPerCourse().add(ass2);
        schoolCourse1.getAssignmentsPerCourse().add(ass3);
        schoolCourse1.getAssignmentsPerCourse().add(ass4);
        schoolCourse2.getAssignmentsPerCourse().add(ass5);
        schoolCourse2.getAssignmentsPerCourse().add(ass6);

    }

    public static void addSyntheticsStudents(
            ArrayList<Student> studentList,
            ArrayList<SchoolCourse> schoolCourseList) {
        String stDate1 = "12/05/1990";
        String stDate2 = "20/01/1991";
        String stDate3 = "12/12/1992";
        String stDate4 = "05/11/1992";

        Student st1 = new Student("Nikos", "Papas",
                DateMethods.stringToDate(stDate1), 1200);
        Student st2 = new Student("Giannis", "Papapetrou",
                DateMethods.stringToDate(stDate2), 2000);
        Student st3 = new Student("Elisavet", "Katsigialou",
                DateMethods.stringToDate(stDate3), 2000);
        Student st4 = new Student("Maria", "Grigoriou",
                DateMethods.stringToDate(stDate4), 2400);
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);

        //Αuxiliary variables
        SchoolCourse schoolCourse0 = schoolCourseList.get(0);
        SchoolCourse schoolCourse1 = schoolCourseList.get(1);
        SchoolCourse schoolCourse2 = schoolCourseList.get(2);

        schoolCourse0.getStudentsPerCourse().add(st1);
        schoolCourse0.getStudentsPerCourse().add(st2);
        schoolCourse0.getStudentsPerCourse().add(st3);
        addStudentAssignmentsFromSchoolCourse(st1, schoolCourse0);
        addStudentAssignmentsFromSchoolCourse(st2, schoolCourse0);
        addStudentAssignmentsFromSchoolCourse(st3, schoolCourse0);

        schoolCourse1.getStudentsPerCourse().add(st1);
        schoolCourse1.getStudentsPerCourse().add(st2);
        schoolCourse1.getStudentsPerCourse().add(st3);
        addStudentAssignmentsFromSchoolCourse(st1, schoolCourse1);
        addStudentAssignmentsFromSchoolCourse(st2, schoolCourse1);
        addStudentAssignmentsFromSchoolCourse(st3, schoolCourse1);

        schoolCourse2.getStudentsPerCourse().add(st4);
        addStudentAssignmentsFromSchoolCourse(st4, schoolCourse2);

    }

    private static void addStudentAssignmentsFromSchoolCourse(Student student,
            SchoolCourse schoolCourse) {
        //Αuxiliary variable: aasignments
        ArrayList<Assignment> assignments = schoolCourse.getAssignmentsPerCourse();
        //deep copy of the assignmentList of schoolCourse class to the Student class
        for (int i = 0; i < assignments.size(); i++) {
            student.getAssignmentsPerStudent().add(new Assignment(assignments.get(i)));
        }
    }

    public static void addSyntheticsTrainers(ArrayList<Trainer> trainerList,
            ArrayList<SchoolCourse> schoolCourseList) {
        Trainer t1 = new Trainer("George", "Iraklidis", "Java");
        Trainer t2 = new Trainer("George", "Pasparakis", "Java");
        Trainer t3 = new Trainer("Nikos", "Karapas", "Java");
        trainerList.add(t1);
        trainerList.add(t2);
        trainerList.add(t3);
        //Αuxiliary variables
        SchoolCourse schoolCourse0 = schoolCourseList.get(0);
        SchoolCourse schoolCourse1 = schoolCourseList.get(1);
        SchoolCourse schoolCourse2 = schoolCourseList.get(2);

        schoolCourse0.getTrainersPerCourse().add(t3);
        schoolCourse1.getTrainersPerCourse().add(t2);
        schoolCourse2.getTrainersPerCourse().add(t1);

    }

}
