package com.airtripe.studentmanagement.util;

import java.util.Scanner;
import com.airtripe.studentmanagement.exception.InvalidDataException;

public class InputValidator {

    private static final Scanner SCANNER = new Scanner(System.in); // static variable

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Please try again.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = SCANNER.nextLine();
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    public static String readNonEmptyString(String prompt) throws InvalidDataException {
        System.out.print(prompt);
        String input = SCANNER.nextLine();
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidDataException("Input cannot be empty.");
        }
        return input.trim();
    }
}
