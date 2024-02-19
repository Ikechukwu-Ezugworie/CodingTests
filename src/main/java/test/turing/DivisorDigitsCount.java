package test.turing;

public class DivisorDigitsCount {
    public static int countDivisorDigits(int num) {
        int count = 0;
        int originalNum = num;

        while (num > 0) {
            int digit = num % 10;
            if (digit != 0 && originalNum % digit == 0) {
                count++;
            }
            num /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        int num = 8124;
        int result = countDivisorDigits(num);
        System.out.println("Number of digits that can divide " + num + " without a remainder: " + result);
    }
}
