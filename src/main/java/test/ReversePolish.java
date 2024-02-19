package test;

import java.util.ArrayList;
import java.util.List;

public class ReversePolish {

    public static int computeExpression(String expression) {
        int result = 0;
        String operator;
        int firstOperand, secondOperand;
        List<Integer> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        String[] expArr = expression.split(",");
        for (int i = expArr.length; i > 0; i--){
            String val = expArr[i];
            if (!isNumber(val)){
                operators.add(val);
            }else {
                operands.add(Integer.parseInt(val));
            }
        }


        return result;
    }


    private static boolean isNumber(String s){
        try {
            Integer.parseInt(s);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
