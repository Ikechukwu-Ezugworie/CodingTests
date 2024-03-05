package test;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DiscountedPrices {

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(74001755));
    }

    public static int getDiscountedPrice(int barcode) {
        int discountedPrice = 0;
        try {
//            String apiUrl = "https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode;
            String apiUrl = "https://jsonmock.hackerrank.com/api/iot_devices/search?status=STOPPED";
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

                if (data.isEmpty()) {
                    return -1;
                }
                Map<?,?> dataMap = (Map<?, ?>) data.get(0);
            } else {
                System.out.println("Error: Unable to retrieve data. Status code: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return discountedPrice;
    }
}
