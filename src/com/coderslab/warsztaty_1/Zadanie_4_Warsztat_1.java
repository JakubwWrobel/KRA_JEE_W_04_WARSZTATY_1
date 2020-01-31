package com.coderslab.warsztaty_1;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Zadanie_4_Warsztat_1 {
    public static void main(String[] args) {
        boolean checkingRun = false;
        while (checkingRun == false) {
            try {
                System.out.println("Podaj format kostki do rzucenia: xDy+z");
                Scanner scanner = new Scanner(System.in);

                String userInput = scanner.nextLine();

                String numberOfThrows = userInput.substring(0, userInput.indexOf("D"));
                if (numberOfThrows.isEmpty()) {
                    numberOfThrows = "1";
                }

                int count = 0;
                for (int i = 0; i < userInput.length(); i++) {
                    if (userInput.charAt(i) == '+') {
                        count = 1;
                    } else if (userInput.charAt(i) == '-') {
                        count = 2;
                    }
                }

                if (count == 1) {
                    int typeOfCube = Integer.parseInt(userInput.substring(userInput.indexOf("D") + 1, userInput.indexOf("+")));
                    String additionalNumber = userInput.substring(userInput.indexOf("+") + 1);
                    cubeThrowsMoreThan1(typeOfCube, additionalNumber, numberOfThrows);
                    cubeThrowsLessThanOne(typeOfCube, additionalNumber, numberOfThrows);

                } else if (count == 2) {
                    int typeOfCube = Integer.parseInt(userInput.substring(userInput.indexOf("D") + 1, userInput.indexOf("-")));
                    String additionalNumber = '-' + userInput.substring(userInput.indexOf("-") + 1);
                    cubeThrowsMoreThan1(typeOfCube, additionalNumber, numberOfThrows);
                    cubeThrowsLessThanOne(typeOfCube, additionalNumber, numberOfThrows);

                } else {
                    int typeOfCube = Integer.parseInt(userInput.substring(userInput.indexOf("D") + 1));
                    String additionalNumber = "0";
                    cubeThrowsMoreThan1(typeOfCube, additionalNumber, numberOfThrows);
                    cubeThrowsLessThanOne(typeOfCube, additionalNumber, numberOfThrows);
                }
                checkingRun = true;
                scanner.close();
            } catch (NumberFormatException e) {
                System.out.println("Niepoprawny format pliku: xDy+z");

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Niepoprawny format pliku: xDy+z");
            }
        }

    }

    public static void cubeThrowsMoreThan1(int typeOfCube, String additionalNumber, String numberOfThrows) {
        Random random = new Random();
        int result;
        int additionalNumberSumInteger = Integer.parseInt(additionalNumber);

        if (Integer.parseInt(numberOfThrows) >= 1) {
            int liczbaRzutow = Integer.parseInt(numberOfThrows);
            int ileRzut = 1;
            if (additionalNumberSumInteger > 0) {
                System.out.println("Rzuciłem kostką: " + numberOfThrows + " razy.");
                int[] tableOfThrows = new int[liczbaRzutow];
                for (int i = 0; i < tableOfThrows.length; i++) {
                    tableOfThrows[i] = ThreadLocalRandom.current().nextInt(1, typeOfCube);
                    System.out.println("Rzut nr: " + ileRzut + ": " + tableOfThrows[i]);
                    ileRzut++;
                }
                System.out.println("oraz dodałem: " + additionalNumber);
                System.out.println();
                result = ((IntStream.of(tableOfThrows).sum()) + additionalNumberSumInteger);
                System.out.println("Suma wylosowanych liczb to: " + result);
            } else if (additionalNumberSumInteger <= 0) {
                System.out.println("Rzuciłem kostką: " + numberOfThrows + " razy.");
                int[] tableOfThrows = new int[liczbaRzutow];
                for (int i = 0; i < tableOfThrows.length; i++) {
                    tableOfThrows[i] = ThreadLocalRandom.current().nextInt(1, typeOfCube);
                    ;
                    System.out.println("Rzut nr: " + ileRzut + ": " + tableOfThrows[i]);
                    ileRzut++;
                }
                System.out.println("oraz dodałem: " + additionalNumber);
                System.out.println();
                result = ((IntStream.of(tableOfThrows).sum()) - additionalNumberSumInteger);
                System.out.println("Suma wylosowanych liczb to: " + result);

            }
        }
    }

    public static void cubeThrowsLessThanOne(int typeOfCube, String additionalNumber, String numberOfThrows) {
        Random random = new Random();
        int result;
        int additionalNumberSumInteger = Integer.parseInt(additionalNumber);

        if (Integer.parseInt(numberOfThrows) < 1) {
            if (additionalNumberSumInteger < 1) {
                int liczbaRzutow = Integer.parseInt(numberOfThrows);
                int ileRzut = 1;

                if (additionalNumberSumInteger >= 0) {
                    System.out.println("Rzuciłem kostką: " + numberOfThrows + " razy.");
                    int[] tableOfThrows = new int[liczbaRzutow];
                    for (int i = 0; i < tableOfThrows.length; i++) {
                        tableOfThrows[i] = ThreadLocalRandom.current().nextInt(1, typeOfCube);
                        ;
                        System.out.println("Rzut nr: " + ileRzut + ": " + tableOfThrows[i]);
                        ileRzut++;
                    }
                    System.out.println("oraz dodałem: " + additionalNumber);
                    System.out.println();
                    result = ((IntStream.of(tableOfThrows).sum()) + additionalNumberSumInteger);
                    System.out.println("Suma wylosowanych liczb to: " + result);
                } else if (additionalNumberSumInteger < 0) {
                    System.out.println("Rzuciłem kostką: " + numberOfThrows + " razy.");
                    int[] tableOfThrows = new int[liczbaRzutow];
                    for (int i = 0; i < tableOfThrows.length; i++) {
                        tableOfThrows[i] = ThreadLocalRandom.current().nextInt(1, typeOfCube);
                        System.out.println("Rzut nr: " + ileRzut + ": " + tableOfThrows[i]);
                        ileRzut++;
                    }
                    System.out.println("oraz dodałem: " + additionalNumber);
                    System.out.println();
                    result = (IntStream.of(tableOfThrows).sum() + additionalNumberSumInteger);
                    System.out.println("Suma wylosowanych liczb to: " + result);

                }
            }
        }
    }
}


