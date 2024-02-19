package test;

public class MinimumSlidingWindow {

    public static void main(String[] args) {
        String[] arr = new String[] {"aabdccdbcacd", "aad"};
        System.out.println(minWindowSubstring(arr));
    }


    public static String minWindowSubstring(String[] strArr) {
        String N = strArr[0];
        String K = strArr[1];
        int[] targetFreq = new int[26];
        int[] windowFreq = new int[26];

        // Count the frequency of characters in K
        for (char ch : K.toCharArray()) {
            targetFreq[ch - 'a']++;
        }

        int left = 0;  // Left pointer of the window
        int right = 0;  // Right pointer of the window
        int minLength = Integer.MAX_VALUE;
        int minStart = -1;

        while (right < N.length()) {
            char currChar = N.charAt(right);
            windowFreq[currChar - 'a']++;

            // Shrink the window from the left side if all characters in K are found
            while (containsAllChars(windowFreq, targetFreq)) {
                int windowSize = right - left + 1;
                if (windowSize < minLength) {
                    minLength = windowSize;
                    minStart = left;
                }

                char leftChar = N.charAt(left);
                windowFreq[leftChar - 'a']--;
                left++;
            }

            right++;
        }

        if (minStart == -1) {
            return "";  // No valid substring found
        }

        return N.substring(minStart, minStart + minLength);
    }

    private static boolean containsAllChars(int[] windowFreq, int[] targetFreq) {
        for (int i = 0; i < 26; i++) {
            if (targetFreq[i] > 0 && windowFreq[i] < targetFreq[i]) {
                return false;
            }
        }
        return true;
    }

}
