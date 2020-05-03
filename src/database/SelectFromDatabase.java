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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");

            String query = "SELECT * FROM STUDENTS";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("STUDENT_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                LocalDate dateOfbirth = resultSet.getDate("DATE_OF_BIRTH").toLocalDate();
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

        return studentList;

    }

    public ArrayList<Trainer> getTrainerList() {
        ArrayList<Trainer> trainerList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");

            String query = "SELECT * FROM TRAINERS";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int trainerId = resultSet.getInt("TRAINER_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                String subject = resultSet.getString("SUBJECT");

                Trainer trainer = new Trainer(trainerId, firstName, lastName, subject);
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

        return trainerList;
    }

    public ArrayList<Assignment> getAssignmentList() {
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            String query = "SELECT * FROM ASSIGNMENTS";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int assignmentId = resultSet.getInt("ASSIGNMENT_ID");
                String title = resultSet.getString("TITLE");
                String description = resultSet.getString("DESCRIPTION");
                LocalDate subDateTime = resultSet.getObject("SUB_DATETIME", LocalDate.class);///
                float oralMark = resultSet.getFloat("ORAL_MARK");
                float totalMark = resultSet.getFloat("TOTAL_MARK");
                int courseId = resultSet.getInt("COURSE_ID");

                Assignment assignment = new Assignment(assignmentId, title,
                        description, subDateTime, oralMark, totalMark, courseId);
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

        return assignmentList;
    }

    public ArrayList<Course> getCourseList() {
        ArrayList<Course> courseList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");
            String query = "SELECT * FROM COURSES";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int courseId = resultSet.getInt("COURSE_ID");
                String title = resultSet.getString("TITLE");
                String stream = resultSet.getString("STREAM");
                String type = resultSet.getString("TYPE");
                LocalDate startDate = resultSet.getObject("START_DATE", LocalDate.class);//
                LocalDate endDate = resultSet.getObject("END_DATE", LocalDate.class);//

                Course course = new Course(courseId, title,
                        stream, type, startDate, endDate);
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

        return courseList;
    }

    public ArrayList<Assignment> getAssignmentListForAStudent(int studentId) {
        ArrayList<Assignment> assignmentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");

            String query = "SELECT ASS.ASSIGNMENT_ID, ASS.TITLE, ASS.DESCRIPTION "
                    + "FROM STUDENT_COURSE AS STC, ASSIGNMENTS AS ASS "
                    + "WHERE STC.STUDENT_ID= ? "
                    + "AND STC.COURSE_ID= ASS.COURSE_ID";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int assId = resultSet.getInt("ASS.ASSIGNMENT_ID");
                String title = resultSet.getString("ASS.TITLE");
                String description = resultSet.getString("ASS.DESCRIPTION");

                Assignment assignment = new Assignment(assId, title, description);
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
        return assignmentList;
    }

    public void showGrades(int studentId, int assignmentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("Connection to database created successfully.");

            String query = "SELECT ORAL_MARK, TOTAL_MARK "
                    + "FROM STUDENTS_GRADES AS STG "
                    + "WHERE STG.STUDENT_ID= ? "
                    + "AND STG.ASSIGNMENT_ID= ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            preparedStatement.setInt(2, assignmentId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                float oralMark = resultSet.getFloat("ORAL_MARK");
                float totalMark = resultSet.getFloat("TOTAL_MARK");

                System.out.println("The student's grades for this assignment are: Oral mark: "
                        + oralMark + ", Total mark: " + totalMark);
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

    public float getAssignmentMaxOralMark(int assignmentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        float assMaxOralMark = 0;

        try {
            connection = getConnection();

            String query = "SELECT ORAL_MARK "
                    + "FROM ASSIGNMENTS  "
                    + "WHERE ASSIGNMENT_ID= ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, assignmentId);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
            assMaxOralMark = resultSet.getFloat("ORAL_MARK");
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
        return assMaxOralMark;
    }

}
