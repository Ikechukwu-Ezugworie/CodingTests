package test;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class IPMatcher {
    private static final String IP_ADDRESS_PATTERN =
//            "^((\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])$";
//            "^((0|[1-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(0|[1-9]\\d?|1\\d{2}|2[0-4]\\d|25[0-5])$";
"^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nextLine = true;
        while (nextLine) {
            try{
                String input = scanner.nextLine().trim();
                System.out.println(validateIP(input));
            } catch (NoSuchElementException e){
                nextLine = false;
                Integer.valueOf("1");
            }

        }
    }

    private static boolean validateIP(final String ipAddress) {
        return ipAddress.matches(IP_ADDRESS_PATTERN);
    }
}
