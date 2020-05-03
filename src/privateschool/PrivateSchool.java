/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool;

import printMethods.PrintChoice;
import java.util.Scanner;
import dataLoader.InsertChoice;

/**
 *
 * @author ELIZA
 */
public class PrivateSchool {

    public static void privateSchool() {
        // Values initialization
        Scanner sc = new Scanner(System.in);
        String answer;

        System.out.println("Hello! Welcome to Private School Project!");

        do {
            System.out.println("If you want to print data press 1.\n"
                    + "If you want to add data press 2.");

            answer = sc.next();

            if (answer.equals("1")) {
                PrintChoice printChoise = new PrintChoice();
                printChoise.askUserWhatToPrint();

            } else if (answer.equals("2")) {

                // Fill data from User data
                InsertChoice insertChoise = new InsertChoice();
                insertChoise.askUserWhatToInsert();

            } else {
                System.out.println("Wrong input! try again: ");
            }
        } while ((!answer.equals("1")) && (!answer.equals("2")));

    }

}
