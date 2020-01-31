package com.coderslab.warsztaty_1;

import java.util.Scanner;

public class Zadanie_3_Warsztat_1 {
    public static void main(String[] args) {
        System.out.println("Pomyśl liczbę z zakresu 0 - 1000, a ja odgadnę w max. 10 próbach");
        int min = 0;
        int max = 1000;


        boolean didIget = false;
        int count = 0;
        while (didIget == false && count < 10) {
            int guess = ((max - min) / 2) + min;
            System.out.print("Zgaduje: ");
            Scanner scanner = new Scanner(System.in);
            System.out.println(guess);

            System.out.println("Poinformuj mnie czy: \n \"Za dużo\", \"Za mało\" czy \"Zgadłeś\"?");
            String userInput = scanner.nextLine();

            if (userInput.equals("Zgadłeś")) {
                System.out.println("Wygrałeś");
                break;
            } else if (userInput.equals("Za dużo")) {
                max = guess;
                count++;
                continue;
            } else if (userInput.equals("Za mało")) {
                min = guess;
                count++;
                continue;
            } else {
                System.out.println("Nie oszukuj!!!");
            }

        }

    }
}
