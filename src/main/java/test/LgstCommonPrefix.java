package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LgstCommonPrefix {
    static boolean hasCommonPrefix = false;

    public static void longestCommonPrefix(String[] strs) {
        List<String> strings = Arrays.asList(strs);
        System.out.println(strings);
        Set<Character> resultSet = new HashSet<>();
        //recurse from here
        int countIndex = 0;
        comparePrefix(countIndex, resultSet, strings);
        System.out.println(hasCommonPrefix ? resultSet : "nothing");

    }

    private static void comparePrefix(int countIndex, Set<Character> set, List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            set.add(strings.get(i).charAt(countIndex));
        }
        if (set.size() > (countIndex + 1)) {
            //abort -> output ""
            hasCommonPrefix = false;
        } else {
            hasCommonPrefix = true;
            countIndex++;
            comparePrefix(countIndex, set, strings);
        }

    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        longestCommonPrefix(strings);
    }
}
