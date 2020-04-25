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
public class Course {

    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;

    public Course() {

    }

    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }

  

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    

    @Override
    public String toString() {
        return  "Course title=" + title + ", Stream=" + stream + ", Type=" + type + ", Start Date=" + start_date + ", End Date=" + end_date;
    }
    
}
