package test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class RotateArray {

    private static void timeSpent(LocalDateTime startTime) {
        long duration = Duration.between(startTime, LocalDateTime.now()).toNanos();
        System.out.println("Time taken: " + duration + " nano seconds");
    }

    //using deque
    public static Deque<Integer> rotateArrayUsingDeque(int[] array, int k) {
        if (k > array.length) {
            k = k % array.length;
        }
        LocalDateTime startTime = LocalDateTime.now();
        ArrayDeque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            if (i <= (array.length - k - 1)) {
                list.add(array[i]);
            } else {
                list.addFirst(array[i]);
            }
        }
        timeSpent(startTime);
        return list;
    }

    //using array
    public static List<Integer> rotateArrayUsingArrayList(int[] array, int k) {
        if (k > array.length) {
            k = k % array.length;
        }
        LocalDateTime startTime = LocalDateTime.now();
        List<Integer> result = new ArrayList<>();
        List<Integer> tempArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (i <= array.length - k - 1) {
                tempArray.add(array[i]);
            }else {
                result.add(0, array[i]);
            }
        }
        result.addAll(tempArray);
        timeSpent(startTime);
        return result;
    }

    //using array



}
