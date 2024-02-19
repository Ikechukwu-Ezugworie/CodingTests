package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ValidParenthesis {
    public static void main(String[] args) {

    }

    public static boolean isValid(String input) {
        boolean result = false;
        char[] inputArray = input.toCharArray();
        HashMap<Character, Integer> inputMap = new HashMap<>();
        inputMap.put('(', 5);
        inputMap.put(')', 10);
        inputMap.put('{', 30);
        inputMap.put('}', 60);
        inputMap.put('[', 50);
        inputMap.put(']', 100);
        // "("  ")"  "{"  "}"  "["  "]"
        for (int i = 0; i < inputArray.length; i++) {
            if (i+1 > inputArray.length){
                return false;
            }
            int target = inputMap.get(inputArray[i]);
            int nextTarget = inputMap.get(inputArray[i+1]);
            if ((target * 2) != nextTarget){
                return false;
            }else {
                result = true;
                i+=1;
            }
        }


        return result;
    }

    class Solution {
        public boolean isValid(String s) {
            char[] input  = s.toCharArray();
            List<Character> charIntegers = new ArrayList<>();
            for (char inputChar: input ){
                charIntegers.add(inputChar);
            }
            int openBracketCount = Collections.frequency(charIntegers, '(');
            int closeBracketCount = Collections.frequency(charIntegers, ')');
            int openSquareBracketCount = Collections.frequency(charIntegers, '[');
            int closeSquareBracketCount = Collections.frequency(charIntegers, ']');
            int openCurlyBracketCount = Collections.frequency(charIntegers, '{');
            int closeCurlyBracketCount = Collections.frequency(charIntegers, '}');
            if (openBracketCount != closeBracketCount || openSquareBracketCount != closeSquareBracketCount ||           openCurlyBracketCount != closeCurlyBracketCount){
                return false;
            }
            for (int i = 0; i < charIntegers.size(); i ++) {
                if ((charIntegers.get(i) == 40 && charIntegers.get(++i) != 41)
                        || (charIntegers.get(i) == 91 && charIntegers.get(++i) != 93)
                        || (charIntegers.get(i) == 123 && charIntegers.get(++i) != 125)) {
                    return false;
                }
            }
            return true;
        }
    }
}
