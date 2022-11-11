package com.cognixia.progresstracker.view;

import java.util.Scanner;

public class View {
    private final static Scanner sc = new Scanner(System.in);

    public View() {

    }

    public int menu() {
        print("Main Menu");
        print("1. Login");
        print("2. Register an Account");
        print("0. Exit");

        return readInt("Please select from the above choices.", 0, 2);
    }



    public static void print(String msg) {
        System.out.println(msg);
    }

    public static String readString(String msgPrompt) {
        System.out.println(msgPrompt);
        return sc.nextLine();
    }

    public static int readInt(String msgPrompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                String stringValue = readString(msgPrompt);
                num = Integer.parseInt(stringValue);
                invalidInput = false;
            } catch (NumberFormatException e) {
                print("Input error. Please try again.");
            }
        }
        return num;
    }

    public static int readInt(String msgPrompt, int min, int max) {
        int result;
        do {
            result = readInt(msgPrompt);
        } while (result < min || result > max);

        return result;
    }
}
