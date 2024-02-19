package test.turing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialCards {
    public static int sumOfUniqueElements(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int sum = 0;

        // Calculate the sum of elements that appear only once
        for (int num : frequencyMap.keySet()) {
            if (frequencyMap.get(num) == 1) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,3};
        int uniqueSum = sumOfUniqueElements(array);
        System.out.println(uniqueSum);

    }
}


