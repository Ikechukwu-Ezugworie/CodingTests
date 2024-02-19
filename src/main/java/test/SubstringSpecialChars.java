package test;

public class SubstringSpecialChars {
    public static int getSpecialSubstring(String s, int k, String charValue) {
        int[] charValueArray = new int[26];
        for (int i = 0; i < charValue.length(); i++) {
            charValueArray[i] = charValue.charAt(i) - '0';
        }

        int left = 0;
        int normalCount = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            if (charValueArray[s.charAt(right) - 'a'] == 0) {
                normalCount++;
            }

            if (normalCount > k) {
                if (charValueArray[s.charAt(left) - 'a'] == 0) {
                    normalCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        String s = "giraffe";
        int k = 2;
        String charValue = "01111001111111111011111111";

        int result = getSpecialSubstring(s, k, charValue);
        System.out.println(result);  // Output: 5
    }
}