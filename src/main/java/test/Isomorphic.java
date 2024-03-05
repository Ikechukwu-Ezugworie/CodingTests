package test;

import com.hcb.services.utils.Base64Converter;

import java.util.HashMap;
import java.util.UUID;

public class Isomorphic {
    public static void main(String[] args) {
//        System.out.println(isIsomorphic("badc", "baba"));
        String uuid = "404b6368-78a8-402e-aecd-2bdf61efcc79";
        String base64 = Base64Converter.getBase64(uuid);
        System.out.println(base64);
    }

//    public static boolean isIsomorphic(String firstString, String secondString){
//        char[] firstInput = firstString.toCharArray();
//        char[] secondInput = secondString.toCharArray();
//        String newString = secondString;
//
//        for (int i = 0; i < firstInput.length; i++){
//            char sourceChar = firstInput[i];
//            char targetChar = secondInput[i];
//            for (char val : secondInput){
//                if (val == targetChar){
//                    newString = newString.replace(val, sourceChar);
//                }
//            }
//        }
//
//        System.out.println(firstString);
//        System.out.println(secondString);
//        System.out.println(newString);
//        return newString.equals(secondString);
//    }



    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] firstInput = s.toCharArray();
        char[] secondInput = t.toCharArray();

        String resultString = s;
        for (int i = 0; i < secondInput.length; i++) {
            char targetVal = firstInput[i];
            for (char val: firstInput){
                if (targetVal == val){
                  resultString = resultString.replace(String.valueOf(val),String.valueOf(secondInput[i]));
                }
            }
        }

        return resultString.equals(t);
    }
}
