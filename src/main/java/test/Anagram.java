package test;

public class Anagram {

    public static void main(String[] args) {
         // Label for the outer loop
       String s= "aacc";
       String t = "ccac";
        System.out.println(isAnagram(s,t));
    }


    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        if(s.length() == 1 && s.equals(t)){
            return true;
        }

        boolean result = false;
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < sb.length(); j++){
                if (s.charAt(i) == sb.charAt(j)){
                    sb.deleteCharAt(j);
                    j = s.length(); //exit the loop
                    result = true;
                }else{
                    if (j == sb.length() - 1) return false;
                    result = false;
                }
            }
        }

        return result;
    }
}
