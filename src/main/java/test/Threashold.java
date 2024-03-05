package test;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Threashold {
    public static void main(String[] args) {
//        apiCall(1, )
    }

    static List<?> apiCall(int pageNumber, String statusQuery, List<?> totalResponse){
        try {

            String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery + "&page="+ pageNumber;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                Gson gson = new Gson();
                Map<?, ?> resultMap = gson.fromJson(response.toString(), Map.class);
                List<?> data = (List<?>) resultMap.get("data");
                int totalPage = (Integer) resultMap.get("total_pages");
                int totalNumberOfData = (Integer) resultMap.get("total");
                int currentPage = (Integer) resultMap.get("page");
//                totalResponse.addAll(data);
                while (currentPage < totalPage && data.size() != totalNumberOfData){
                    currentPage += 1;
                    apiCall(currentPage, statusQuery, totalResponse);
                }
            } else {
                System.out.println("Error: Unable to retrieve data. Status code: " + responseCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return totalResponse;
    }

//    public static int numDevices(String statusQuery, int threshold, String dateStr){
//        try {
////            String apiUrl = "https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode;
//            String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=" + statusQuery;
//
//            //method to make apiCall
//
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                String line;
//                StringBuilder response = new StringBuilder();
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//                reader.close();
//                Gson gson = new Gson();
//                Map<?, ?> resultMap = gson.fromJson(response.toString(), Map.class);
//                List<?> data = (List<?>) resultMap.get("data");
//                int totalPage = (Integer) resultMap.get("total_pages");
//                int totalNumberOfData = (Integer) resultMap.get("total");
//                int currentPage = (Integer) resultMap.get("page");
//                while (currentPage != totalPage){
//
//                }
//
//                if (data.isEmpty()) {
//                    return -1;
//                }
//                Map<?,?> dataMap = (Map<?, ?>) data.get(0);
//            } else {
//                System.out.println("Error: Unable to retrieve data. Status code: " + responseCode);
//            }
//            connection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
