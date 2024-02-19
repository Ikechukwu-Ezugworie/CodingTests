package test;

import java.util.Arrays;
import java.util.Collections;

public class ClosestToZero {

    public static void main(String[] args) {
        int[] arr = {2, 4, 88, -2, -4, 3};
        System.out.println(closestToZero(arr));
        System.out.println(closestToZero2(arr));
    }

    static int closestToZero(int[] ints) {
        int result = 0;
        if (ints == null)
            return result;

        Arrays.sort(ints);
        result = ints[0];
        for (int i = 0; i < ints.length; i++) {
            int targetValue = ints[i];
            int absoluteVal = Math.abs(ints[i]);
            int absResult = Math.abs(result);
            if ( targetValue != 0 && absResult >= absoluteVal){
                result = targetValue;
            }
        }
        return result;

    }

    static int closestToZero2(int[] ints){
        if (ints == null || ints.length == 0) {
            return 0; // Return 0 for null or empty array
        }

        int closest = ints[0]; // Initialize with the first element

        for (int num : ints) {
            // Check if the absolute value of the current number is closer to zero
            if (Math.abs(num) < Math.abs(closest) || (Math.abs(num) == Math.abs(closest) && num > closest)) {
                closest = num;
            }
        }

        return closest;
    }
}
