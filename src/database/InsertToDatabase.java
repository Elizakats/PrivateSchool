/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;

/**
 *
 * @author ELIZA
 */
public class InsertToDatabase extends DatabaseConnector {

    public void insertStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
           
            String query = "INSERT INTO STUDENTS VALUES (NULL,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            String dateBirth = student.getDateOfBirth().format(DateTimeFormatter.ISO_LOCAL_DATE);
            preparedStatement.setString(3, dateBirth);
            preparedStatement.setFloat(4, student.getTuitionFees());

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Insert succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void insertTrainer(Trainer trainer) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            
            String query = "INSERT INTO TRAINERS VALUES (NULL,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, trainer.getFirstName());
            preparedStatement.setString(2, trainer.getLastName());
            preparedStatement.setString(3, trainer.getSubject());

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Insert succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void insertAssignment(Assignment assignment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            
            String query = "INSERT INTO ASSIGNMENTS VALUES (NULL,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, assignment.getTitle());
            preparedStatement.setString(2, assignment.getDescription());
            String subDate = assignment.getSubDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
            preparedStatement.setString(3, subDate);
            preparedStatement.setFloat(4, assignment.getOralMark());
            preparedStatement.setFloat(5, assignment.getTotalMark());
            preparedStatement.setInt(6, assignment.getCourseId());

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Insert succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void insertCourse(Course course) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            
            String query = "INSERT INTO COURSES VALUES (NULL,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getStream());
            preparedStatement.setString(3, course.getType());
            String startDate = course.getStart_date().format(DateTimeFormatter.ISO_LOCAL_DATE);
            preparedStatement.setString(4, startDate);
            String endDate = course.getEnd_date().format(DateTimeFormatter.ISO_LOCAL_DATE);
            preparedStatement.setString(5, endDate);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Insert succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void insertStudentToCourse(int courseId, int studentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            
            String query = "INSERT INTO STUDENT_COURSE VALUES (NULL,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, studentId);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Insert succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void insertTrainerToCourse(int courseId, int trainerId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
           
            String query = "INSERT INTO TRAINER_COURSE VALUES (NULL,?,?)";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, trainerId);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Insert succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void insertStudentGradesForAssignment(int studentId,
            int assignmentId, float oralMark, float totalMark) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();

            String query = "UPDATE STUDENTS_GRADES "
                    + "SET ORAL_MARK= ?, TOTAL_MARK=?"
                    + " WHERE STUDENT_ID=?"
                    + " AND ASSIGNMENT_ID=? ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setFloat(1, oralMark);
            preparedStatement.setFloat(2, totalMark);
            preparedStatement.setInt(3, studentId);
            preparedStatement.setInt(4, assignmentId);

            int result = preparedStatement.executeUpdate();

            if (result > 0) {
                System.out.println("Update succesfull!");
            } else {
                System.out.println("Somthing went wrong");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
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
}
