package test;

import java.util.Arrays;

public class SearchInsertPosition {

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
//        int target = 7;
//        System.out.println(searchInsert(nums, target));
//        System.out.println(binarySearch(nums, target));
        System.out.println(divide(10, 3));
    }

    private static int searchInsert(int[] nums, int target) {
        //loop through and get the
        //index of the array that is == target
        //or index + 1 that is > target
        int resultIndex = 0;
        //get the half range

        for (int i = 0; i < nums.length; i++) {

            int halfRange = nums.length / 2;
//            if (target >= halfRange) {// change the start to halfRange and loop
//                long elCount = Arrays.stream(nums).count();
//                i = (int) (elCount / 2);
//            }

            if (nums[i] > target || nums[i] == target) {
                resultIndex = i;
                break;
            } else {
                resultIndex++;
            }
        }
        return resultIndex;
    }


    private static int binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            // Check if target is present at mid
            if (arr[mid] == target){
                return mid;
            }

            // If target greater, ignore left half
            if (arr[mid] < target){
                left = mid + 1;
            } else { // if target is smaller, ignore the right half
                right = mid - 1;
            }
        }

        //target is not found in array
        return -1;
    }

    public static int divide(int dividend, int divisor) {
        int quotient = 0;
        boolean isBothNegative = false;
        boolean isOneNegative = false;
        if (dividend == 0) return 0;
        if(dividend < 0 && divisor < 0){
            isBothNegative = true;
        }else if(dividend < 0){
            isOneNegative = true;
        }else if(divisor < 0){
            isOneNegative = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend != 0 && dividend > divisor ){
            dividend -= divisor;
            quotient++;
        }
        if (isOneNegative){
            return -quotient;
        } else if(isBothNegative){
            return quotient;
        }
        return quotient;
    }
}
