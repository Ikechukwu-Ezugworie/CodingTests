package test;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] array = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(array));
    }


    public static String longestCommonPrefix(String[] strs) {
        int smallestLength = Integer.MAX_VALUE;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            int tempSmallestLength = strs[i].length();
            if (smallestLength > tempSmallestLength) {
                smallestLength = tempSmallestLength;
            }
        }

        for (int i = 0; i < smallestLength - 1; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (!builder.toString().isEmpty()) {
                    String targetChar = String.valueOf(strs[j].charAt(i));
                    if ((builder.toString().length() == i - 1) &&
                            !builder.toString().equals(targetChar)) {
                        return "";
                    }
                }
                // else {
                //builder.append(strs[i].charAt(i));

                //  }
            }
//            if (builder.toString().isEmpty()) {
            builder.append(strs[i].charAt(i));
//            }

        }
        return builder.toString();
    }
}
