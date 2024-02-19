package test;

import java.util.*;

public class WordTransformation {
    public static int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(end))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[j] == c)
                            continue;

                        chars[j] = c;
                        String transformed = new String(chars);
                        if (transformed.equals(end))
                            return level + 1;

                        if (dict.contains(transformed)) {
                            queue.offer(transformed);
                            dict.remove(transformed);
                        }
                    }
                    chars[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
//        String start = "hit";
//        String end = "cog";
//        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
//
//        int length = ladderLength(start, end, wordList);
//        System.out.println("Shortest transformation length: " + length);
        System.out.println(System.getenv("HOSTNAME"));
    }
}
