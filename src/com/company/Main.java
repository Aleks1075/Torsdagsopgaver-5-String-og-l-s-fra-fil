package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws Exception {

        File file = new File("src/com/company/data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                                // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }
        //mellemrum eller ikke logisk punktum
        text = inputFromFile.split(" |\\. ");                    // Creates and array of strings, where each element is a single word from the file.


        //test dine metoder ved at kalde dem her:
        System.out.println("\n" + "The longest word is: " + printLongestWord() + "\n");
        System.out.println(printFirstHalfOfEachWord() + "\n");
        mostRepeatedWord();
    }

    //skriv dine metoder herunder:
    //Task 1
    public static String printLongestWord() throws FileNotFoundException {

        String longest_word = "";
        String current;
        Scanner sc = new Scanner(new File("src/com/company/data.txt"));

        while (sc.hasNext()) {
            current = sc.next();
            if (current.length() > longest_word.length()) {
                longest_word = current;
            }

        }
        return longest_word;
    }

    //Task 2
    public static String printFirstHalfOfEachWord() throws FileNotFoundException {
        System.out.println("The first half of each word:");
        for (String s : text) // for each word in text
        {
            System.out.println(s.substring(0, s.length() / 2));
        }
        return null;
    }

    //Task 3
    public static void mostRepeatedWord() throws Exception {
                String line, word = "";
                int count = 0, maxCount = 0;
                ArrayList<String> words = new ArrayList<String>();

                //Opens file in read mode
                FileReader file = new FileReader("src/com/company/data.txt");
                BufferedReader br = new BufferedReader(file);

                //Reads each line
                while((line = br.readLine()) != null) {
                    String string[] = line.toLowerCase().split("([,.\\s]+)");
                    //Adding all words generated in previous step into words
                    for(String s : string){
                        words.add(s);
                    }
                }

                //Determine the most repeated word in a file
                for(int i = 0; i < words.size(); i++){
                    count = 1;
                    //Count each word in the file and store it in variable count
                    for(int j = i+1; j < words.size(); j++){
                        if(words.get(i).equals(words.get(j))){
                            count++;
                        }
                    }
                    //If maxCount is less than count then store value of count in maxCount
                    //and corresponding word to variable word
                    if(count > maxCount){
                        maxCount = count;
                        word = words.get(i);
                    }
                }

                System.out.println("The most frequent word is: " + word);
                br.close();
            }
    //Task 4
    //public static void leastRepeatedWord() throws Exception {


        }