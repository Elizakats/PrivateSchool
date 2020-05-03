/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ELIZA
 */
public class Student {

    private int studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private float tuitionFees;
    private ArrayList<Assignment> assignmentsPerStudent;

    public Student() {
        assignmentsPerStudent = new ArrayList<>();
    }

    public Student(int studentId, String firstName, String lastName, LocalDate dateOfBirth, float tuitionFees) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        assignmentsPerStudent = new ArrayList<>();
    }

    // gia dokimi. Na to sviso
    public Student(int studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public float getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(float tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public ArrayList<Assignment> getAssignmentsPerStudent() {
        return assignmentsPerStudent;
    }

    public void setAssignmentsPerStudent(ArrayList<Assignment> assignmentsPerStudent) {
        this.assignmentsPerStudent = assignmentsPerStudent;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student Id=" + studentId
                + ", First Name=" + firstName
                + ", Last Name=" + lastName
                + ", Date Of Birth=" + dateOfBirth
                + ", Tuition Fees=" + tuitionFees;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Float.floatToIntBits(this.tuitionFees) != Float.floatToIntBits(other.tuitionFees)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.dateOfBirth, other.dateOfBirth)) {
            return false;
        }
        return true;
    }

}
