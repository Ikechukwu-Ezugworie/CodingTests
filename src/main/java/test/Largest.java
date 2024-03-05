package test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import java.util.List;

public class Largest {
    public static void main(String[] args) {
//        List<List<Integer>> samples = List.of(
//                List.of(1, 1, 1),
//                List.of(1, 1, 0),
//                List.of(1, 0, 1)
//        );
//        System.out.println(findLargestSquareSize(samples)); // Output: 2
//



//        isTimestampInRange(1552070631752, "04-2019");
    }

    public static int findLargestSquareSize(List<List<Integer>> samples) {
        int maxSize = 0;
        int[][] dp = new int[samples.size()][samples.get(0).size()];

        for (int i = 0; i < samples.size(); i++) {
            for (int j = 0; j < samples.get(0).size(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = samples.get(i).get(j);
                } else if (samples.get(i).get(j) == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }

                maxSize = Math.max(maxSize, dp[i][j]);
            }
        }

        return maxSize;
    }

    public static boolean isTimestampInRange(Long timestamp, String dateString) {
        // Parse the date string to get the month and year
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-YYYY");
        LocalDate targetDate = LocalDate.parse(dateString, formatter);

        // Convert timestamp to LocalDate
        LocalDate timestampDate = LocalDate.ofInstant(java.time.Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

        // Check if timestamp is in the same month and year as the target date
        return timestampDate.getMonth() == targetDate.getMonth() &&
                timestampDate.getYear() == targetDate.getYear();
    }

}
