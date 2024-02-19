package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskCompletion {

    public static void main(String[] args) {
        List<Integer> reward_1 = new ArrayList<>();
        reward_1.add(5);
        reward_1.add(4);
        reward_1.add(3);
        reward_1.add(2);
        reward_1.add(1);
        List<Integer> reward_2 = new ArrayList<>();
        reward_2.add(1);
        reward_2.add(2);
        reward_2.add(3);
        reward_2.add(4);
        reward_2.add(5);
        int k = 3;
        System.out.println(getMaximumRewardPoints(k, reward_1, reward_2));
    }


    private static int getMaximumRewardPoints(int k, List<Integer> reward_1, List<Integer> reward_2) {
        int result = 0;

        //sort the two lists
//        Collections.sort(reward_1);
//        Collections.sort(reward_2);

        //pick the sum of the first k elements from each of the list
        int summer1 = 0;
        int summer2 = 0;
        for (int i = 0; i < k; i++) {
            summer1 += reward_1.get(i);
            summer2 += reward_2.get(i);
        }
        int rewardLength = reward_1.size() - 1;
        int remainingSize = rewardLength - k;
        for (int i = rewardLength; i >= k; i--) {
            summer1 += reward_2.get(i);
            summer2 += reward_1.get(i);
        }

        // and save in a list
        //get the sum of the remaining element
        // and add to the initial sum list
        // compare and return the highest between the two

        System.out.println(summer1);
        System.out.println(summer2);
        return Math.max(summer1, summer2);
    }
}
