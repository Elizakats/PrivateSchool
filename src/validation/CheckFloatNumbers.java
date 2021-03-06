/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author ELIZA
 */
public class CheckFloatNumbers {

   static Scanner sc = new Scanner(System.in);
   
    public static float checkFloatNumberForFees() {
        float fee = 0;
        do {
            //We apply "try-catch", in order to catch the exception if the user
            // does not give us a float number
            try {
                fee = sc.nextFloat();
            } catch (InputMismatchException ex) {
                sc.nextLine();
                System.out.println("Wrong Input! I need a number!");
            }
            // We also check if the user gave us negative number
            if (fee <= 0) {
                System.out.println("Give me a positive number");
            }
            // As long as the user gives us wrong inputs, the loop continues
        } while (fee <= 0);
        return fee;
    }

    public static float checkFloatNumberForOralMark() {

        float oralMark = 0;
        do {
           //We apply "try-catch", in order to catch the exception if the user
            // does not give us a float number
            try {
                oralMark = sc.nextFloat();
            } catch (InputMismatchException ex) {
                sc.nextLine();
                System.out.println("Wrong Input! I need a number!");
            }
            // We also check if the user gave us negative number or number>20
            if (oralMark <= 0 || oralMark > 20) {
                System.out.println("Give me a positive number up to 20: ");
            }
            // As long as the user gives us wrong inputs, the loop continues
        } while (oralMark <= 0 || oralMark > 20);
        return oralMark;
    }

    public static float checkFloatNumberForTotalMark(Float oralMark) {
        float totalMark = 0;
        do {
             //We apply "try-catch", in order to catch the exception if the user
            // does not give us a float number
            try {
                totalMark = sc.nextFloat();
            } catch (InputMismatchException ex) {
                sc.nextLine();
                System.out.println("Wrong Input! I need a number!");
            }
            // We also check if the user gave us a number< oralMark or number>80+oralMark
            if (totalMark <= oralMark || totalMark > (80+oralMark)) {
                System.out.println("Give me a positive number up to "+ (80+oralMark)+": ");
            }
            // As long as the user gives us wrong inputs, the loop continues
        } while (totalMark <= oralMark || totalMark > (80+oralMark));
        return totalMark;
    }

}
