package com.coderslab.warsztaty_1;

import java.util.Random;
import java.util.Scanner;

public class Zadanie_1_Warsztat_1 {
    public static void main(String[] args) {
        Random random = new Random();
        int choosenNumber = random.nextInt(100);
        sprawdzanie(choosenNumber);

    }


    public static void sprawdzanie(int choosenNumber) {
        Scanner scanner = new Scanner(System.in);
        boolean wynik = false;
        System.out.println("Zgadnij liczbę");

        while (wynik == false) {

            String quess = scanner.nextLine();
            try {
                int checking = Integer.parseInt(quess);
            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba");
                continue;
            }

            int checking = Integer.parseInt(quess);

            if (checking == choosenNumber) {
                wynik = true;
            } else if (checking > choosenNumber) {
                System.out.println("Za dużo!");
            } else if (checking < choosenNumber) {
                System.out.println("Za mało!");
            }
        }
        scanner.close();
        System.out.println("Gratulacje, zgadłeś!");
    }

}