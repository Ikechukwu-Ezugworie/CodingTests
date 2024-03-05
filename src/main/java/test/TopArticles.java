package test;

//import org.json.JSONArray;
//import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TopArticles {

    public static void main(String[] args) {
        int limit = 2;
        List<String> topArticles = topArticles(limit);
        for (String a: topArticles){
            System.out.println(a);
        }
    }

    public static List<String> topArticles(int limit) {
        String baseUrl = "https://jsonmock.hackerrank.com/api/articles?page=3";
        List<String> result = new ArrayList<>();

        try {
            URL url = new URL(baseUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = reader.readLine()) != null) {
                    response.append(inputLine);
                }

                JsonObject jsonResponse = new JsonObject();
                jsonResponse.getAsJsonObject("data");
                JsonArray data = jsonResponse.getAsJsonArray("data");

//                sort the data by the num_comments field
                List<JsonObject> dataList = new ArrayList<>();
                for (int i = 0; i < data.size(); i++) {
                    dataList.add(data.get(i).getAsJsonObject());
                }

                dataList.sort((a, b) -> b.get("num_comments").getAsInt() - a.get("num_comments").getAsInt());

//                add only the first limit number of articles to the result list
                for (int i = 0; i < limit; i++) {
                    result.add(String.valueOf(dataList.get(i).get("title")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(result.size());
        return result;
    }
}
