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

    private String title;
    private String description;
    private LocalDate subDateTime;
    private float oralMark;
    private float totalMark;

    public Assignment() {
    }

    public Assignment(String title, String description, LocalDate subDateTime, float oralMark, float totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
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

    @Override
    public String toString() {
        return "Title=" + title + ", Description=" + description + ", Submission Date=" + subDateTime;
    }
    //deep copy
    public Assignment(Assignment assignment) {
        this(assignment.title, assignment.description, assignment.subDateTime, assignment.oralMark, assignment.totalMark);
    }
}
