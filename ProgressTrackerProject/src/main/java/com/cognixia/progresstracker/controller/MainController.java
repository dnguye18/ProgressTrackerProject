package com.cognixia.progresstracker.controller;

import com.cognixia.progresstracker.view.View;

public class MainController {
    private View view = new View();

    boolean running = true;

    public void run() {


        while (running) {

            int choice = view.menu();

            switch (choice) {

                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println();

            }
            System.out.println();
            System.out.println();
        }
    }

    private void login() {

    }

    private void signup() {

    }

    private void exit() {
        view.print("Bye");
        running = false;
    }
}
