package Warsztaty_1.src;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Zadanie_5_Warsztat_1 {
    public static void main(String[] args) {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        Path allWordsOnPage = Paths.get("whole_words.txt");
        Path wordsWithoutRepeated = Paths.get("filtered_popular_words.txt");
//CHECK IF FILES ALREADY EXIST:
        if (!Files.exists(allWordsOnPage)) {
            try {
                Files.createFile(allWordsOnPage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!Files.exists(wordsWithoutRepeated)) {
            try {
                Files.createFile(wordsWithoutRepeated);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//WRITE ALL LINES OF TEXT INTO ONE DOC
        try {
            try {
                Document document = connect.get();
                Elements links = document.select("span.title");
                FileWriter fileWriter = new FileWriter("whole_words.txt");

                for (Element elem : links) {
                    try {
                        fileWriter.append(elem.text() + "\n");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Problem z połączeniem ze stroną internetową");
            }
//SEPARATE THE SINGLE WORDS FROM LINES
            File allWordsOnPageFile = new File("whole_words.txt");
            Scanner scanner = new Scanner(allWordsOnPageFile);
            String word;
            StringBuilder stringBuilder = new StringBuilder();

            for (String line : Files.readAllLines(allWordsOnPage)) {
                word = scanner.next();
                stringBuilder.append(word + "\n");
            }
            String[] temporary = stringBuilder.toString().toLowerCase().split("\n");

//IS LONGER THAT 3 CHAR?
            for (int i = 0; i < temporary.length; i++) {
                if (temporary[i].length() <= 3) {
                    temporary[i] = null;
                }
            }
//EXISTS IN FORBIDDEN LIST?
            isForbidden(temporary);

//WRITE ALL WORDS INTO NEW FILE EXCLUDING THE FILTERED WORDS
            String[] finalListOfWords;
            FileWriter fileWriter = new FileWriter("filtered_popular_words.txt");
            finalListOfWords = stringBuilder.toString().split(" \n");
            for (int i = 0; i < temporary.length; i++) {
                if (temporary[i] != null) {
                    fileWriter.append(temporary[i] + "\n");
                    stringBuilder.append(temporary[i] + "\n");
                }
            }
            fileWriter.close();
            finalListOfWords = stringBuilder.toString().split("\n");
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }

    public static String[] isForbidden(String[] str) {
        String[] fobiddenList = new String[6];
        fobiddenList[0] = "ponieważ";
        fobiddenList[1] = "oraz";
        fobiddenList[2] = "tymczasem";
        fobiddenList[3] = "wówczas";
        fobiddenList[4] = "jednakże";
        fobiddenList[5] = "coraz";
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < fobiddenList.length; j++) {
                if (str[i] == fobiddenList[j]) {
                    str[i] = null;
                }
            }
        }
        return str;
    }


}

