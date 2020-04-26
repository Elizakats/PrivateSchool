/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.text.SimpleDateFormat;
import models.Student;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ELIZA
 */
public class DateMethods {

    static Scanner sc = new Scanner(System.in);

    public static LocalDate stringToDateFromScanner() {
        LocalDate date = null;
        do {
            try {
                String stringDate = sc.nextLine();
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                date = LocalDate.parse(stringDate, dateFormatter);
            } catch (DateTimeParseException ex) {
                System.out.println("Wrong date format or unvalid date. Try again: ");

            }
        } while (date == null);
        
        return date;
    }

    public static LocalDate stringToDate(String stringDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(stringDate, dateFormatter);
        return date;
    }

    public static ArrayList<Student> createStudentListWithAssignmentsInADateRange(
            ArrayList<Student> studentList) {
        //We take the date from user input and we make it LocalDate
        LocalDate usersDate = stringToDateFromScanner();
        // Take the day of the week from the date that the user put in
        DayOfWeek usersDateOfWeek = usersDate.getDayOfWeek();
        // Set 2 random days for the switch to work
        //I find the last Sunday of the week and Saturday of the same week
        //in order to work with isAfter and isBefore
        LocalDate dSunday = stringToDate("01/03/2020");
        LocalDate dSaturday = stringToDate("07/03/2020");

        switch (usersDateOfWeek) {
            case MONDAY:
                dSunday = usersDate.minusDays(1);
                dSaturday = usersDate.plusDays(5);
                break;
            case TUESDAY:
                dSunday = usersDate.minusDays(2);
                dSaturday = usersDate.plusDays(4);
                break;
            case WEDNESDAY:
                dSunday = usersDate.minusDays(3);
                dSaturday = usersDate.plusDays(3);
                break;
            case THURSDAY:
                dSunday = usersDate.minusDays(4);
                dSaturday = usersDate.plusDays(2);
                break;
            case FRIDAY:
                dSunday = usersDate.minusDays(5);
                dSaturday = usersDate.plusDays(1);
                break;
            case SATURDAY:
                dSunday = usersDate.minusDays(6);
                dSaturday = usersDate;
                break;
            case SUNDAY:
                dSunday = usersDate.minusDays(7);
                dSaturday = usersDate.minusDays(1);
                break;
            default:
                break;
        }
        ArrayList<Student> studentListWithAssignmentsInADateRange = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            int counter = 0;
            for (int j = 0; j < studentList.get(i).getAssignmentsPerStudent().size(); j++) {
                //Αuxiliary variable
                LocalDate subDate = studentList.get(i).
                        getAssignmentsPerStudent().get(j).getSubDateTime();
                if (subDate.isAfter(dSunday) && subDate.isBefore(dSaturday)) {
                    counter++;
                }
            }
            if (counter > 0) {
                studentListWithAssignmentsInADateRange.add(studentList.get(i));
            }
        }
        return studentListWithAssignmentsInADateRange;
    }

    public static LocalDate dateEndIsBeforeDateStart(LocalDate dateStart,
            LocalDate dateEnd) {

        if (dateEnd.isBefore(dateStart)) {
            do {
                System.out.println("You can't input a date before the Start Day"
                        + " of the Course."
                        + " Try again: ");
                dateEnd = stringToDateFromScanner();

            } while (dateEnd.isBefore(dateStart));
        }
        System.out.println("Well done!");
        return dateEnd;
    }

    public static LocalDate dateWithinLimits(LocalDate date, LocalDate dateStart, LocalDate dateEnd) {
        if (date.isBefore(dateStart) || date.isAfter(dateEnd)) {
            do {
                System.out.println("You can't input a date before the Start Day"
                        + " of the Course or after the End Date of the Course."
                        +"\nStart Date: "+dateStart+" End Date: "+ dateEnd+"."
                        + " Try again: ");
                date = stringToDateFromScanner();

            } while (date.isBefore(dateStart) || date.isAfter(dateEnd));
        }
        System.out.println("Well done!");
        return date;
    }

}
