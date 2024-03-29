package test;

public class LongestPrefix {

    public static void main(String[] args) {
        String[] array = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(array));
    }

    // Intuition: The idea is to iterate through each character position in the first string
    // and compare it with the corresponding characters in the other strings.

    // Approach: Use nested loops to iterate through characters in the first string
    // and compare with the corresponding characters in the rest of the strings.
    // If a mismatch is found or if the index goes beyond the length of any string, return the current prefix.
    public static String longestCommonPrefix(String[] strs) {
        // Initialize an empty string to store the longest common prefix.
        String s = "";

        // Iterate through each character position in the first string (strs[0]).
        for (int i = 0; i < strs[0].length(); i++) {
            // Iterate through the other strings starting from index 1.
            for (int j = 1; j < strs.length; j++) {
                // Check if the current index i is out of bounds for the current string (strs[j])
                // or if the characters at position i are different between strs[j] and strs[0].
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    // Return the current prefix as the result.
                    return s;
                }
            }
            // Append the current character to the common prefix.
            s = s + strs[0].charAt(i);
        }

        // Return the final common prefix.
        return s;
    }

}
