package test;

import java.util.Arrays;
import java.util.Stack;

public class StackLeetCode {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }


    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                if (!sb.toString().isEmpty()){
                    sb.setLength(sb.length() -1);
                }
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

    public static String removeStarss(String s) {
        char arr[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char c:arr){
            if(c=='*'){
                sb.setLength(sb.length()-1);
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
