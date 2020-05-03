/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ELIZA
 */
public class SelectAndPrint extends DatabaseConnector{
    
     public void selectAndPrintAllStudentsPerCourse() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            String query = "SELECT C.TITLE, ST.FIRST_NAME, ST.LAST_NAME "
                    + "FROM COURSES AS C "
                    + "LEFT JOIN STUDENT_COURSE AS STC "
                    + "ON C.COURSE_ID = STC.COURSE_ID "
                    + "LEFT JOIN  STUDENTS AS ST "
                    + "ON ST.STUDENT_ID= STC.STUDENT_ID";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String courseTitle = resultSet.getString("C.TITLE");
                String studentFirstName = resultSet.getString("ST.FIRST_NAME");
                String studentLastName = resultSet.getString("ST.LAST_NAME");

                System.out.println("Course: " + courseTitle
                        + ", Student's Name: " + studentFirstName
                        + ", Surname: " + studentLastName);
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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
    }

    public void selectAndPrintAllTrainersPerCourse() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            String query = "SELECT C.TITLE, TR.FIRST_NAME, TR.LAST_NAME "
                    + "FROM  COURSES AS C "
                    + "LEFT JOIN TRAINER_COURSE AS TRC "
                    + "ON C.COURSE_ID = TRC.COURSE_ID "
                    + "LEFT JOIN TRAINERS AS TR "
                    + "ON TR.TRAINER_ID = TRC.TRAINER_ID";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String courseTitle = resultSet.getString("C.TITLE");
                String trainerFirstName = resultSet.getString("TR.FIRST_NAME");
                String trainerLastName = resultSet.getString("TR.LAST_NAME");

                System.out.println("Course: " + courseTitle
                        + ", Trainer's Name: " + trainerFirstName
                        + ", Surname: " + trainerLastName);
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public void selectAndPrintAllAssignmentsPerCourse() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            String query = "SELECT C.TITLE, ASS.TITLE, ASS.DESCRIPTION "
                    + "FROM COURSES AS C "
                    + "LEFT JOIN ASSIGNMENTS AS ASS "
                    + "ON C.COURSE_ID= ASS.COURSE_ID";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String courseTitle = resultSet.getString("C.TITLE");
                String assignmentTitle = resultSet.getString("ASS.TITLE");
                String assignmentDescription = resultSet.getString("ASS.DESCRIPTION");

                System.out.println("Course: " + courseTitle
                        + ", Assignment's Title: " + assignmentTitle
                        + ", Description: " + assignmentDescription);
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void selectAndPrintAllAssignmentsPerStudent() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");

            String query = "SELECT  ST.FIRST_NAME, ST.LAST_NAME, C.TITLE, ASS.TITLE "
                    + "FROM STUDENTS AS ST "
                    + "LEFT JOIN STUDENT_COURSE AS STC "
                    + "ON ST.STUDENT_ID = STC.STUDENT_ID "
                    + "LEFT JOIN COURSES AS C "
                    + "ON C.COURSE_ID= STC.COURSE_ID "
                    + "LEFT JOIN ASSIGNMENTS AS ASS "
                    + "ON C.COURSE_ID= ASS.COURSE_ID";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String studentFirstName = resultSet.getString("ST.FIRST_NAME");
                String studentLastName = resultSet.getString("ST.LAST_NAME");
                String courseTitle = resultSet.getString("C.TITLE");
                String assignmentTitle = resultSet.getString("ASS.TITLE");

                System.out.println("Student: " + studentFirstName + " " + studentLastName
                        + ", Assignment's Title: " + assignmentTitle
                        + ", Course: " + courseTitle);
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void selectAndPrintStudentsThatBelongsInManyCourses() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");

            String query = "SELECT ST.FIRST_NAME, ST.LAST_NAME, COUNT(*) AS NUM_OF_COURSES "
                    + "FROM STUDENTS AS ST, STUDENT_COURSE AS STC "
                    + "WHERE ST.STUDENT_ID= STC.STUDENT_ID "
                    + "GROUP BY ST.STUDENT_ID "
                    + "HAVING NUM_OF_COURSES >1";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String studentFirstName = resultSet.getString("ST.FIRST_NAME");
                String studentLastName = resultSet.getString("ST.LAST_NAME");
                int numberOfCourses = resultSet.getInt("NUM_OF_COURSES");

                System.out.println("Student: " + studentFirstName + " " + studentLastName
                        + " belongs to " + numberOfCourses + " courses.");
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
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
