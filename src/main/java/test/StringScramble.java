package test;

public class StringScramble {
    //String Scramble
    //Have the function StringScramble(str1,str2) take both parameters being passed and
    // return the string true if a portion of str1 characters can be rearranged
    // to match str2, otherwise return the string false. For example: if str1 is
    // "rkqodlw" and str2 is "world" the output should return true. Punctuation and
    // symbols will not be entered with the parameters.

    public static boolean stringScramble(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        for (char c : str2Arr) {
            if (!contains(str1Arr, c)) {
                return false;
            }
        }
        return true;

    }

    private static boolean contains(char[] arr, char c) {
        for (char a : arr) {
            if (a == c) {
                return true;
            }
        }
        return false;
    }
}
