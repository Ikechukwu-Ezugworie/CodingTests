package test;

public class BracketCombinations {

    public static void main(String[] args) {
       int result = bracketCombinations(2);
        System.out.println(result);
    }


    public static int bracketCombinations(int num) {
        if (num == 0) {
            // Base case: no more parentheses pairs left, return 1
            return 1;
        } else {
            int count = 0;
            // Try placing an opening parenthesis and recursively solve for the remaining pairs
            for (int i = 0; i < num; i++) {
                count += bracketCombinations(i) * bracketCombinations(num - i - 1);
            }
            return count;
        }
    }
}
