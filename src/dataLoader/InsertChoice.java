/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataLoader;

import database.ShowData;
import database.InsertToDatabase;
import database.SelectFromDatabase;
import java.awt.Insets;
import java.util.Scanner;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;
import validation.CheckFloatNumbers;
import validation.CheckIntegerNumbers;

/**
 *
 * @author ELIZA
 */
public class InsertChoice {

    private AddInputsFromUser inputLoader;
    private InsertToDatabase insertToDatabase;
    private ShowData showData;
    private SelectFromDatabase select;

    public InsertChoice() {
        inputLoader = new AddInputsFromUser();
        insertToDatabase = new InsertToDatabase();
        showData = new ShowData();
        select = new SelectFromDatabase();

    }

    public void askUserWhatToInsert() {
        Scanner sc = new Scanner(System.in);
        String answer;

        do {
            System.out.println("What would you like to insert? Press :");
            System.out.println("1. To insert students");
            System.out.println("2. To insert trainers");
            System.out.println("3. To insert assignments");
            System.out.println("4. To insert courses");
            System.out.println("5. To enroll a student to a course");
            System.out.println("6. To enroll a trainer to a course");
            System.out.println("7. To grade an assignment for a student");

            int printChoice = CheckIntegerNumbers.insertAndCheckIntNumberInARange(1, 7);

            switch (printChoice) {
                case 1:
                    Student student = inputLoader.takeStudentFromUserInput();
                    insertToDatabase.insertStudent(student);

                    break;
                case 2:
                    Trainer trainer = inputLoader.takeTrainerFromUserInput();
                    insertToDatabase.insertTrainer(trainer);

                    break;
                case 3:
                    Assignment assignment = inputLoader.takeAssignmentFromUserInput();
                    insertToDatabase.insertAssignment(assignment);

                    break;
                case 4:
                    Course course = inputLoader.takeCourseFromUserInput();
                    insertToDatabase.insertCourse(course);

                    break;
                case 5:
                    int studentId = showData.showStudentListAndGetStudentId();
                    int courseId = showData.showCourseListAndGetCourseId();
                    insertToDatabase.insertStudentToCourse(courseId, studentId);

                    break;
                case 6:
                    int trainerId = showData.showTrainerListAndGetTrainerId();
                    courseId = showData.showCourseListAndGetCourseId();
                    insertToDatabase.insertTrainerToCourse(courseId, trainerId);

                    break;
                case 7:
                    studentId = showData.showStudentListAndGetStudentId();
                    int assignmentId = showData.showAssignmentListAndGetAssignmnetId(studentId);
                    select.showGrades(studentId, assignmentId);
                    System.out.println("If you want to insert new grades press 1. "
                            + "If not press somethinng else.");
                    answer = sc.next();
                    if (answer.equals("1")) {
                        System.out.println("Give me the new Oral Mark: ");
                        float maxOralMark = select.getAssignmentMaxOralMark(assignmentId);
                        float oralMark = CheckFloatNumbers.checkFloatNumberForOralMark(maxOralMark);
                        System.out.println("Give me the new Total Mark: ");
                        float totalMark = CheckFloatNumbers.checkFloatNumberForStudentTotalMark(oralMark, maxOralMark);
                        insertToDatabase.insertStudentGradesForAssignment(studentId, assignmentId, oralMark, totalMark);
                    }
                    break;
            }
            System.out.println("Would you like to insert something else? Yes or No?");
            answer = sc.next();
        } while (answer.equalsIgnoreCase("yes"));
        System.out.println("Goodbye!!!");
    }
}
