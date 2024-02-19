package test.turing;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public static void main(String[] args) {
        String[] arr = {"5","2","C", "D", "+"};
        calPoint(arr);
    }


    private static int calPoints(String[] ops){
        int result = Integer.MIN_VALUE;
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < ops.length; i++){
            if (isNumber(ops[i])){
                numbers.add(Integer.valueOf(ops[i]));
            }else if (ops[i].equals("+")){
                numbers.add(Integer.parseInt(ops[i-1]) + Integer.parseInt(ops[i-2]));
            }else if (ops[i].equals("D")){
                numbers.add((Integer.parseInt(ops[i-1]) * 2));
            } else if (ops[i].equals("C")){
                numbers.remove(i-1);
            }
        }

        System.out.println(numbers);
        return result;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str); // Try to parse the string as a double
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int calPoint(String[] ops) {
        int scores[] = new int[ops.length];
        int pointer = 0;
        int totalScore = 0;

        for(int i =0;i<ops.length;i++){
            if(ops[i].equals("C")){
                totalScore -= scores[pointer-1];
                pointer--;
            }
            else if(ops[i].equals("D")){
                int doubled = scores[pointer-1]*2;
                totalScore += doubled;
                scores[pointer++] = doubled;
            }
            else if(ops[i].equals("+")){
                int added = scores[pointer-1] + scores[pointer-2];
                totalScore += added;
                scores[pointer++] = added;
            }
            else{
                int roundScore = Integer.parseInt(ops[i]);
                scores[pointer++] = roundScore;
                totalScore += roundScore;
            }
        }
        System.out.println(totalScore);
        return totalScore;
    }
}
