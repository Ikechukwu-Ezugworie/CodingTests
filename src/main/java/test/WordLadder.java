package test;

import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.*;


public class WordLadder {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new TreeSet<>(List.of("hot","dot","dog","lot","log"));
        System.out.println(findShortestTransformation(start, end, dict));
         String ENV_PROPERTIES_FILE = "hcb\\services\\configuration\\env.properties";
        String workingDirectory = System.getProperty("user.dir");
        Yaml yaml = new Yaml();

        String userHome = System.getProperty("user.home");
        File envPropertyFile = new File(userHome + File.separator + ENV_PROPERTIES_FILE);
        if (envPropertyFile.exists()){
            try (InputStream envPropertyInputStream = new FileInputStream(envPropertyFile);
                 InputStream applicationYamlInputStream = new FileInputStream(workingDirectory + File.separator + "application.yaml")) {
                Properties properties = new Properties();
                properties.load(envPropertyInputStream);
                String deployEnvironment = properties.getProperty("deployment.environment");
//                switch (deployEnvironment)

                Map<String, Object> applicationYamlData = yaml.load(applicationYamlInputStream);
                Map<String, Object> hcb = (Map<String, Object>) applicationYamlData.get("hcb");
                Map<String, Object> services = (Map<String, Object>) hcb.get("services");
                String baseurl = (String) services.get("demourl");
                System.out.println(baseurl);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("apple", 5);
//        hashMap.put("banana", 3);
//        hashMap.put("orange", 7);
//
//        // Define the file path
//        String filePath = "installer-update.txt";
//
//        Gson gson = new Gson();
//
//        // Convert the HashMap to JSON
//        String json = gson.toJson(hashMap);
//
//        try {
//            // Create a FileWriter to write to the file
//            FileWriter fileWriter = new FileWriter(filePath);
//
//            // Write the JSON data to the file
//            fileWriter.write(json);
//
//            // Close the FileWriter
//            fileWriter.close();
//
//            System.out.println("HashMap data written to " + filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



    }


    public static int findShortestTransformation(String start, String end, Set<String> dict) {
        if (requiresOneChange(start, end)) {
            return 2;
        }
        int count = 0;
        for (String val : dict) {
            if (requiresOneChange(start, val)) {
                //goto line 16
                count++;
                if (requiresOneChange(val, end)) {
                    return count + 2;
                }
            }
        }

        return count + 2;
    }


    private static boolean requiresOneChange(String first, String second) {
        char[] firstArr = first.toCharArray();
        char[] secondArr = second.toCharArray();
        int count = 0;
        for (int i = 0; i < firstArr.length; i++) {
            if (!String.valueOf(firstArr[i]).equals(String.valueOf(secondArr[i]))) {
                count++;
            }
        }
        return count == 1;
    }
}

