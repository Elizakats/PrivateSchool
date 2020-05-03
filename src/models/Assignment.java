/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author ELIZA
 */
public class Assignment {

    private int assignmentId;
    private String title;
    private String description;
    private LocalDate subDateTime;
    private float oralMark;
    private float totalMark;
    private int courseId;

    public Assignment() {
    }

    public Assignment(int assignmentId, String title, String description) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
    }

    public Assignment(int assignmentId, String title, String description, LocalDate subDateTime, float oralMark, float totalMark, int courseId) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.courseId = courseId;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public float getOralMark() {
        return oralMark;
    }

    public void setOralMark(float oralMark) {
        this.oralMark = oralMark;
    }

    public float getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Assignment Id=" + assignmentId + ", "
                + "Title=" + title + ", Description=" + description + ","
                + " Submision DateTime=" + subDateTime + ", "
                + "Max Oral Mark=" + oralMark + ", "
                + "Max Total Mark=" + totalMark + '}';
    }

    //deep copy
    public Assignment(Assignment assignment) {
        //   this(assignment.title, assignment.description, assignment.subDateTime, assignment.oralMark, assignment.totalMark);
    }
}
