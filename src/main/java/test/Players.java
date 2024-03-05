package test;

import java.util.Arrays;

public class Players {
    public static void main(String[] args) {
        int[] scores = {100, 50, 50, 25};
        int k = 3;
        System.out.println(numPlayers(k, scores)); // Output: 3
    }

    public static int numPlayers(int k, int[] scores) {
        Arrays.sort(scores);
        int qualifiedRank = scores.length - k;
        int qualifiedScore = scores[qualifiedRank];
        int count = 0;
        for (int score : scores) {
            if (score >= qualifiedScore && score > 0) {
                count++;
            }
        }
        System.out.println("'Count " + count);
        return count;
    }
}