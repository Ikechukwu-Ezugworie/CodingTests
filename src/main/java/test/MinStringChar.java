package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStringChar {
    public static void main(String[] args) {
        String s = "()))";
//        String s = "(())";
        int result = minInsertionsToBalanceParentheses(s);
        System.out.println(result);
    }


    public static void getMin(String s){
//        int result = 0;
//        char[] inputArray = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        map.put("open", 0);
//        map.put("close", 0);
//
//        for (int i = 0; i < inputArray.length; i++){
//            if (String.valueOf(inputArray[i]).equals(")")){
//                map.put("open")
//            }
//        }
//        return result;
    }

    public static int minInsertionsToBalanceParentheses(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }

        count += stack.size();  // Add remaining unmatched opening parentheses

        return count;
    }
}
