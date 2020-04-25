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
public class CheckIntegerNumbers {

    static Scanner sc = new Scanner(System.in);

    public static int insertAndCheckIntNumberInARange(int min, int max) {
        int num = max + 1;
        do {
             //We apply "try-catch", in order to catch the exception if the user
            // does not give us an integer number
            try {
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                sc.nextLine();
                System.out.println("Wrong Input! I need a number!: ");
                continue;
            }
            // We also check if the user gave us a number out of bounds
            if (num < min || num > max) {
                System.out.println("I need a number between " + min + "-" + max + " :");
            }
        } while (num < min || num > max);
        return num;
    }
}
