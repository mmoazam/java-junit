package org.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WordAnalyserTest {

    @Test
    void findLongestWords() {
        //arrange
        WordAnalyser wordAnalyser = new WordAnalyser();
        String input = "Hi Hello Howdy, how are yous?";
        String[] expected = {"Howdy,"};

        //act
        String[] actual = wordAnalyser.findLongestWords(input);

        //assert
        assertArrayEquals(expected, actual);
    }

    @Test
    void findLongestWordsAgain() {
        //arrange
        WordAnalyser wordAnalyser = new WordAnalyser();
        String input = "aaa aaa aaaaa aaaaa aaaaa";
        String[] expected = {"aaaaa", "aaaaa", "aaaaa"};

        //act
        String[] actual = wordAnalyser.findLongestWords(input);

        //assert
        assertArrayEquals(expected, actual);
    }



    @Test
    void calculateLetterFrequencyReturnsEmptyMap() {
        //arrange
        WordAnalyser wordAnalyser = new WordAnalyser();
        //String input = "aaabbbbccccc";
        String input = "";
        Map<Character, Integer> expected = new HashMap<Character, Integer>();

        //act
        Map<Character, Integer> actual = wordAnalyser.calculateLetterFrequency(input);

        //assert returns a map
        assertEquals(expected, actual);
    }

    @Test
    void calculateLetterFrequency() {
        //arrange
        WordAnalyser wordAnalyser = new WordAnalyser();
        String input = "aaa hello world bbbbccccc";
        int expected = 3;

        //act
        Map<Character, Integer> returnedMap = wordAnalyser.calculateLetterFrequency(input);
        int actual = returnedMap.get('a');

        //assert returns a map
        assertEquals(expected, actual);
    }

    @Test
    void calculateLetterFrequencyNoLetterInString() {
        //arrange
        WordAnalyser wordAnalyser = new WordAnalyser();
        String input = "aaa hello world bbbbccccc";

        //act
        Map<Character, Integer> returnedMap = wordAnalyser.calculateLetterFrequency(input);
        Object actual = returnedMap.get('z');

        //assert returns null
        assertNull(actual);
    }
}