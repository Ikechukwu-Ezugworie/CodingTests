package test;

import java.util.*;
import java.util.stream.Collectors;

public class SentenceRearranger {
    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        Map<String, Integer> wordFreq = new HashMap<>();

        // Count the frequency of each word in the wordSet
        for (String word : wordSet) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        int[] result = new int[sentences.size()];

        for (int i = 0; i < sentences.size(); i++) {
            String sentence = sentences.get(i);
            String[] words = sentence.split(" ");
            int count = 0;

            for (String word : words) {
                int[] freqArray = new int[26]; // Frequency array for the current word

                // Count the frequency of each character in the word
                for (char c : word.toCharArray()) {
                    freqArray[c - 'a']++;
                }

                // Check if the word can be rearranged using the words in the wordSet
                for (String validWord : wordSet) {
                    if (isValidRearrangement(validWord, freqArray, wordFreq.get(validWord))) {
                        count++;
                        break;
                    }
                }
            }

            result[i] = count;
        }

        return Arrays.stream(result)
                .boxed()
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    // Helper method to check if the word can be rearranged using the frequency array and required count
    private static boolean isValidRearrangement(String word, int[] freqArray, int requiredCount) {
        int[] tempArray = new int[26]; // Frequency array for the current word

        // Count the frequency of each character in the word
        for (char c : word.toCharArray()) {
            tempArray[c - 'a']++;
        }

        // Check if the frequency arrays are equal and the count is sufficient
        for (int i = 0; i < 26; i++) {
            if (tempArray[i] != freqArray[i]) {
                return false;
            }
        }

        return requiredCount > 0;
    }

    public static void main(String[] args) {
        List<String> wordSet = Arrays.asList("listen", "silent", "it", "is");
        List<String> sentences = Arrays.asList("listen it is silent", "silent it is listen");

        List<Long> result = countSentences(wordSet, sentences);
        System.out.println(result);
        // Output: [4, 4]
    }
}
