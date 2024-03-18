package test;

import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

//    public static boolean isValid(String input) {
//        boolean result = false;
//        char[] inputArray = input.toCharArray();
//        HashMap<Character, Integer> inputMap = new HashMap<>();
//        inputMap.put('(', 5);
//        inputMap.put(')', 10);
//        inputMap.put('{', 30);
//        inputMap.put('}', 60);
//        inputMap.put('[', 50);
//        inputMap.put(']', 100);
//        // "("  ")"  "{"  "}"  "["  "]"
//        for (int i = 0; i < inputArray.length; i++) {
//            if (i+1 > inputArray.length){
//                return false;
//            }
//            int target = inputMap.get(inputArray[i]);
//            int nextTarget = inputMap.get(inputArray[i+1]);
//            if ((target * 2) != nextTarget){
//                return false;
//            }else {
//                result = true;
//                i+=1;
//            }
//        }
//
//
//        return result;
//    }

    public static boolean isValid(String input) {
        boolean isValid = false;
        // sliding windows of static size 2
        //create a stack of characters
        // get each string
        /**
         | ( | - 1
         | ) | - 2
         | { | - 3
         | } | - 4
         | [ | - 5
         | ] | - 6

         Map<Character, Integer> inputMap =Map.of('(',1, ')',2, '{',3, ')' ...)

         */
        //if the first character is a closing character return false
        Stack<Character> inputValidator = new Stack<>();
        if (input.length() % 2 == 0) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.toCharArray()[i];
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                inputValidator.push(currentChar);
            } else {
                char topCharInStack = inputValidator.peek();
                if (topCharInStack == '(' && currentChar == ')') {
                    inputValidator.push(currentChar);
                } else if (topCharInStack == '{' && currentChar == '}') {
                    inputValidator.push(currentChar);
                } else if (topCharInStack == '[' && currentChar == ']') {
                    inputValidator.push(currentChar);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    class Solution {
        public boolean isValid(String s) {
            char[] input = s.toCharArray();
            List<Character> charIntegers = new ArrayList<>();
            for (char inputChar : input) {
                charIntegers.add(inputChar);
            }
            int openBracketCount = Collections.frequency(charIntegers, '(');
            int closeBracketCount = Collections.frequency(charIntegers, ')');
            int openSquareBracketCount = Collections.frequency(charIntegers, '[');
            int closeSquareBracketCount = Collections.frequency(charIntegers, ']');
            int openCurlyBracketCount = Collections.frequency(charIntegers, '{');
            int closeCurlyBracketCount = Collections.frequency(charIntegers, '}');
            if (openBracketCount != closeBracketCount || openSquareBracketCount != closeSquareBracketCount || openCurlyBracketCount != closeCurlyBracketCount) {
                return false;
            }
            for (int i = 0; i < charIntegers.size(); i++) {
                if ((charIntegers.get(i) == 40 && charIntegers.get(++i) != 41) || (charIntegers.get(i) == 91 && charIntegers.get(++i) != 93) || (charIntegers.get(i) == 123 && charIntegers.get(++i) != 125)) {
                    return false;
                }
            }
            return true;
        }
    }

}
