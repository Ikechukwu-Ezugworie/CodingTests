package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        String str = "";
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumOptimzed(nums, target)));
    }

    //O(n^2) approach
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //most optimal approach
    public static int[] twoSumOptimzed(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
//                result[0] = map.get(diff);
//                result[1] = i;
//                return result;
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum found");
    }
}
