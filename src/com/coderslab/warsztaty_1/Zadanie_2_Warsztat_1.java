package com.coderslab.warsztaty_1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zadanie_2_Warsztat_1 {

    public static void main(String[] args) {
        int[] numbers = new int[6];
        System.out.println("Podaj numer 1");
        numbers[0] = checking(numbers);
        System.out.println("Podaj numer 2");
        numbers[1] = checking(numbers);
        System.out.println("Podaj numer 3");
        numbers[2] = checking(numbers);
        System.out.println("Podaj numer 4");
        numbers[3] = checking(numbers);
        System.out.println("Podaj numer 5");
        numbers[4] = checking(numbers);
        System.out.println("Podaj numer 6");
        numbers[5] = checking(numbers);

        Arrays.sort(numbers);
        haveYouWon(lottoMachine(), numbers);
    }

    public static int checking(int[] numbers) {
        boolean correctness = false;
        int isInteger;
        int result;
        Scanner scanner = new Scanner(System.in);

        String checkingNumber = scanner.nextLine();
        while (correctness == false) {

            try {
                isInteger = Integer.parseInt(checkingNumber);
                if (isInteger < 1 || isInteger > 49) {
                    throw new IndexOutOfBoundsException();
                }
                if (wasBefore(isInteger, numbers) == false) {
                    throw new NullPointerException();
                }

            } catch (NumberFormatException e) {
                System.out.println("To nie jest liczba");
                checkingNumber = scanner.nextLine();
                continue;
            } catch (IndexOutOfBoundsException r) {
                System.out.println("Ta liczba nie bierze udziału w losowaniu");
                checkingNumber = scanner.nextLine();
                continue;
            } catch (NullPointerException t) {
                System.out.println("Podany numer już istnieje");
                checkingNumber = scanner.nextLine();
                continue;
            }

            result = Integer.parseInt(checkingNumber);
            return result;

        }
        scanner.close();
        return -1;
    }

    public static boolean wasBefore(int result, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == result) {
                return false;
            }
        }
        return true;
    }

    public static int[] lottoMachine() {
        int[] lottoNumbers = new int[6];
        Random random = new Random();
        System.out.println("Komputer wylosował poniższe liczby:");
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.ints(1, 49).findFirst().getAsInt();
            System.out.print(lottoNumbers[i] + " ");
        }
        System.out.println();
        Arrays.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static void haveYouWon(int[] lottoNumbers, int[] userNumbers) {
        int winNumber = 0;
        for (int i = 0; i < 6; i++) {
            if (lottoNumbers[i] == userNumbers[i]) {
                winNumber++;
            }
        }
        System.out.println("Ty wybrałeś poniższe liczby:");
        for(int i = 0; i < userNumbers.length; i++){
            System.out.print(userNumbers[i] + " ");
        }
        System.out.println();


        switch (winNumber){
            case 3:
                System.out.println("Bravo, trafiłeś trójkę");
                break;
            case 4:
                System.out.println("Bravo, trafiłeś czwórkę");
                break;
            case 5:
                System.out.println("Bravo, trafiłeś piątkę");
                break;
            case 6:
                System.out.println("Bravo, trafiłeś szóstkę");
                break;
            default:
                System.out.println("Przykro mi, tym razem nic nie wygrałeś");
                break;
        }
    }
}
