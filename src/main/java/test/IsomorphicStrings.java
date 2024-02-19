package test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
//        String s = "foo";
//        String t = "bar";
//        isIsomorphic(s,t);
        System.out.println("Time is " + LocalDateTime.now());
        System.out.println(LocalDateTime.now());
    }

    public static boolean isIsomorphic(String s, String t){
        boolean result = false;
        if (s.length() != t.length()){
            return result;
        }


        String[] sArr = s.split("");
        String[] tArr = s.split("");
        String[] newString = new String[sArr.length];



        //every occurrence of a positional character should be replaced with the corresponding character
        //in the second string to form a new string
        //compare the new string and the second string to verify if they are the same
        //if they are the same they are isomorphic else they are not.

        for (int i = 0; i < tArr.length; i++){
            for (int j = 0; j < sArr.length; j++) {
                if (tArr[i].equals(sArr[j])){

                }

            }
        }


//        HashMap<Character, Character>
        return result;
    }
}
