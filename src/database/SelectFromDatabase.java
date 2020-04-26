/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class SelectFromDatabase extends DatabaseConnector {

    public ArrayList<Student> getStudentList() {
        ArrayList<Student> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            statement = connection.createStatement();
            String query = "SELECT * FROM STUDENTS";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int studentId = resultSet.getInt("STUDENT_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                LocalDate dateOfbirth = resultSet.getObject("DATE_OF_BIRTH", LocalDate.class);
                float tuitionFees = resultSet.getFloat("TUITION_FEES");

                Student student = new Student(studentId, firstName, lastName, dateOfbirth, tuitionFees);
                studentList.add(student);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
            
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return studentList;

    }
    
     public ArrayList<Trainer> getTrainerList() {
        ArrayList<Trainer> trainerList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            statement = connection.createStatement();
            String query = "SELECT * FROM TRAINERS";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int trainerId = resultSet.getInt("TRAINER_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String subject = resultSet.getString("SUBJECT");

                Trainer trainer = new Trainer (trainerId,firstName, lastName, subject);
                trainerList.add(trainer);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return trainerList;
    }
     
      public ArrayList<Assignment> getAssignmentList() {
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            statement = connection.createStatement();
            String query = "SELECT * FROM ASSIGNMENTS";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int assignmentId = resultSet.getInt("ASSIGNMENT_ID");
                String title = resultSet.getString("TITLE");
                String description = resultSet.getString("DESCRIPTION");
                LocalDate subDateTime = resultSet.getObject("SUB_DATETIME", LocalDate.class);
                float oralMark = resultSet.getFloat("ORAL_MARK");
                float totalMark = resultSet.getFloat("TOTAL_MARK");
                int courseId = resultSet.getInt("COURSE_ID");

                Assignment assignment = new Assignment(assignmentId,title
                        ,description,subDateTime,oralMark, totalMark, courseId);
                assignmentList.add(assignment);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return assignmentList;
    }
      
       public ArrayList<Course> getCourseList() {
       ArrayList<Course> courseList= new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            statement = connection.createStatement();
            String query = "SELECT * FROM COURSES";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int courseId = resultSet.getInt("COURSE_ID");
                String title = resultSet.getString("TITLE");
                String stream = resultSet.getString("STREAM");
                String type = resultSet.getString("TYPE");
                LocalDate startDate = resultSet.getObject("START_DATE", LocalDate.class);
                LocalDate endDate = resultSet.getObject("END_DATE", LocalDate.class);
               

                Course course= new Course(courseId,title
                        ,stream,type,startDate, endDate);
                courseList.add(course);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong!");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return courseList;
    }
}
