/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printMethods;

import models.SchoolCourse;
import models.Assignment;
import models.Student;
import models.Trainer;
import java.util.ArrayList;

/**
 *
 * @author ELIZA
 */
public class PrintLists {

    public static void printAllStudents(ArrayList<Student> studentList) {
        System.out.println("All the Students are:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + "." + studentList.get(i));
        }
    }

    public static void printAllTrainers(ArrayList<Trainer> trainerList) {
        System.out.println("All the Trainers are:");
        for (int i = 0; i < trainerList.size(); i++) {
            System.out.println((i + 1) + "." + trainerList.get(i));
        }
    }

    public static void printAllCourses(ArrayList<SchoolCourse> schoolCourseList) {
        System.out.println("All the Courses are:");
        for (int i = 0; i < schoolCourseList.size(); i++) {
            System.out.println((i + 1) + "." + schoolCourseList.get(i).getCourse());
        }
    }

    public static void printAllAssigniments(ArrayList<Assignment> assignmentList) {
        System.out.println("All the Assignments are:");
        for (int i = 0; i < assignmentList.size(); i++) {
            System.out.println((i + 1) + "." + assignmentList.get(i));
        }
    }

    public static void printStudentsPerCourse(
            ArrayList<SchoolCourse> schoolCourseList) {

        System.out.println("Students per Course: ");
        for (int i = 0; i < schoolCourseList.size(); i++) {

            System.out.print("For the Course "
                    + schoolCourseList.get(i).getCourse().getTitle());
            //Αuxiliary variable: students
            ArrayList<Student> students = schoolCourseList.get(i).getStudentsPerCourse();
            if (students.isEmpty()) {
                System.out.println(": there are no Students in that Course");
            } else {
                System.out.println(" the students are: ");
                for (int j = 0; j < students.size(); j++) {
                    System.out.println((j + 1) + ". "
                            + students.get(j).getFirstName() + " "
                            + students.get(j).getLastName());
                }
            }
        }
    }

    public static void printTrainersPerCourse(
            ArrayList<SchoolCourse> schoolCourseList) {

        System.out.println("Trainers per Course: ");
        for (int i = 0; i < schoolCourseList.size(); i++) {
            System.out.print("For the Course " + schoolCourseList.get(i).getCourse().getTitle());
            //Αuxiliary variable: trainers
            ArrayList<Trainer> trainers = schoolCourseList.get(i).getTrainersPerCourse();
            if (trainers.isEmpty()) {
                System.out.println(": there are no Trainers in that Course");
            } else {
                System.out.println(" the trainers are: ");
                for (int j = 0; j < trainers.size(); j++) {
                    System.out.println((j + 1) + ". "
                            + trainers.get(j).getFirstName() + " "
                            + trainers.get(j).getLastName());
                }
            }
        }
    }

    public static void printAssignmentsPerCourse(
            ArrayList<SchoolCourse> schoolCourseList) {

        System.out.println("Assignments per Course: ");
        for (int i = 0; i < schoolCourseList.size(); i++) {
            System.out.print("For the Course " + schoolCourseList.get(i).getCourse().getTitle());
            //Αuxiliary variable: assignments
            ArrayList<Assignment> assignments = schoolCourseList.get(i).getAssignmentsPerCourse();
            System.out.println(" the assignmnets are: ");
            for (int j = 0; j < assignments.size(); j++) {
                System.out.println((j + 1) + ". " + assignments.get(j).getTitle());
            }
        }
    }

    public static void printAssignmentsPerStudent(ArrayList<Student> studentList) {
        System.out.println("Assignments per Student are: ");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.print("For the Student "
                    + studentList.get(i).getFirstName() + " "
                    + studentList.get(i).getLastName());
            System.out.println(" the assignmnets are: ");
            //Αuxiliary variable: assPerStudent
            ArrayList<Assignment> assPerStudent
                    = studentList.get(i).getAssignmentsPerStudent();
            for (int j = 0; j < assPerStudent.size(); j++) {
                System.out.println((j + 1) + ". "
                        + assPerStudent.get(j).getTitle());
            }
        }
    }

    public static void printStudentsThatBelongsInManyCourses(
            ArrayList<Student> studentListInManyCourses) {

        if (studentListInManyCourses.isEmpty()) {
            System.out.println("Sorry, there are no Students that belong to more"
                    + " than one Courses.");
        } else {
            System.out.println("These are the Students that belong to more "
                    + "than one Courses: ");
            for (int i = 0; i < studentListInManyCourses.size(); i++) {
                System.out.println((i + 1) + "."
                        + studentListInManyCourses.get(i).getFirstName()
                        + " " + studentListInManyCourses.get(i).getLastName());
            }
        }
    }

    public static ArrayList<Student> findStudentsInManyCourses(
            ArrayList<Student> studentList,
            ArrayList<SchoolCourse> schoolCourseList) {

        ArrayList<Student> studentListInManyCourses = new ArrayList<>();

        for (int i = 0; i < studentList.size(); i++) {
            int counter = 0;
            //Αuxiliary variable: student1
            Student student1 = studentList.get(i);

            for (int j = 0; j < schoolCourseList.size(); j++) {
                if (schoolCourseList.get(j).
                        getStudentsPerCourse().contains(student1)) {
                    counter++;
                }
            }
            // 2 courses are enough in order to put the Student in the list
            // if it was: counter>=2 , the student will be added multiple times 
            //in the list
            if (counter == 2) {
                studentListInManyCourses.add(studentList.get(i));
            }
        }
        return studentListInManyCourses;
    }

    public static void printStudentListWithAssignmnetsInADateRange(
            ArrayList<Student> studentListWithAssInADAteRange) {

        if (studentListWithAssInADAteRange.isEmpty()) {
            System.out.println("Sorry, there are no students who need to submit "
                    + "one or more assignments on the same calendar week "
                    + "as the given date");
        } else {
            System.out.println("The students who need to submit one or more"
                    + " assignments on the same calendar week as the given "
                    + "date are: ");
            for (int i = 0; i < studentListWithAssInADAteRange.size(); i++) {
                System.out.println((1 + 1) + "."
                        + studentListWithAssInADAteRange.get(i).getFirstName()
                        + " " + studentListWithAssInADAteRange.get(i).getLastName());
            }
        }
    }
}
