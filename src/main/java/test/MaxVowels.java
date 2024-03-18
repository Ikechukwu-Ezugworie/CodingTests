package test;

import java.util.ArrayList;
import java.util.List;

public class MaxVowels {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static int maxVowels(String s, int k) {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int counter = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            int tempCounter = 0;
            if (vowels.contains(s.toCharArray()[i])) {
                tempCounter++;
            }
            counter = Math.max(tempCounter, counter);
        }

        return counter;
    }
}
