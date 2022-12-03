package com.test.web3labs;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Enter wheel information : (2 for two wheeler/ 4 for four wheeler / E for exit)");
            String inputWheelNumber = input.nextLine();
            switch (inputWheelNumber) {
                case "2", "two" -> System.out.println("Its  A BIKE ");
                case "4", "four" -> System.out.println("iTS A CAR");
                case "E", "e", "exit" -> {
                    input.close();
                    System.exit(0);
                }
                default -> System.out.println("Please enter valid option");
            }
        }
    }
}
