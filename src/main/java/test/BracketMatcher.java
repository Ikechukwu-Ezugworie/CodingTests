package test;

import java.util.Stack;

public class BracketMatcher {
    public static void main(String[] args) {
        System.out.println(bracketMatcher("(coder)(byte))"));
    }

    public static String bracketMatcher(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return String.valueOf(0);
                }
                stack.pop(); // Matched opening and closing brackets
            }
        }

        return stack.isEmpty() ? String.valueOf(1) : String.valueOf(0);
    }
}
