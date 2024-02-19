package test;

public class PalindromeChecker {
    public static boolean isPalindrome(String string) {
        String s = string.replaceAll("\\s+", "").toLowerCase();
        if (s == null || s.isEmpty()) {
            return false;
        }
        int length = s.length();
        int mid = length / 2;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
