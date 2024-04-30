package org.example;
import java.util.*;

public class WordAnalyser {
    public String[] findLongestWords(String text) {
        // "Hi Hello Howdy, how are yous?"
        // TODO: Implement the logic to find the longest word(s) in the given text
       String[] allWords = text.split(" ");

       int maxLength = 0;
       for (String word : allWords) {
           if (word.length() > maxLength) {
               maxLength = word.length();
           }
       }

       // Collect words with the longest length
        List<String> longestWords = new ArrayList<>();
       for (String word : allWords) {
           if (word.length() == maxLength) {
               longestWords.add(word);
           }
       }

       // convert the list to an array
        String [] result = new String[longestWords.size()];
        longestWords.toArray(result);

        return result;
    }



    public Map<Character, Integer> calculateLetterFrequency(String text) {
        // TODO: Implement the logic to calculate the frequency of each letter in the given text
        Map<Character, Integer> letterFrequency = new HashMap<>();

        for (char c : text.toCharArray()) {
            if (!letterFrequency.containsKey(c)) {
                letterFrequency.put(c, 1);
            } else {
                letterFrequency.put(c, letterFrequency.get(c) + 1);
            }
        }


        return letterFrequency;
    }
}
