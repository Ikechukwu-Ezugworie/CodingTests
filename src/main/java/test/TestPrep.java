package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class TestPrep {

    public static void main(String[] args) {

    }


    public List<Integer> fibonacciSequenceGenerator(int numOfDigits) {
        int currentDigit = 1;
        int nextDigit = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= numOfDigits; i++){
            result.add(currentDigit);
            nextDigit = currentDigit + (currentDigit - i);
            currentDigit = nextDigit;

        }

        return result;
    }

    //fibonacci sequence
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    // 1, 2, 3, 4, 5, 6, 7,  8,  9, 10
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    // 1, 2, 3, 4, 5, 6, 7,  8,  9, 10
    // 1, 1, 2, 3, 5, 8, 13, 21, 34, 55


    /**
     * Closes to zero solution
     *
     * @param ints
     * @return
     */
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
            if (targetValue != 0 && absResult >= absoluteVal) {
                result = targetValue;
            }
        }
        return result;

    }

    static int closestToZero2(int[] ints) {
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


    /**
     * Exists in array solution
     */
    static boolean exists(int[] ints, int k) {
        int start = 0;
        int end = ints.length - 1;

        while (start < end) {
            int mid = (int) Math.floor((start + end) / 2);
            if (ints[mid] == k) {
                return true;
            } else {
                if (ints[mid] < k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;

    }


    public static boolean exists2(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is equal to the target
            if (arr[mid] == target) {
                return true;
            }
            // If the target is less than the middle element, search in the left half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If the target is greater than the middle element, search in the right half
            else {
                left = mid + 1;
            }
        }
        // If the target is not found, return false
        return false;
    }
}
