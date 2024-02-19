package test;


import com.google.gson.Gson;
//import com.hcb.services.configuration.ConfigurationRestClient;
//import com.hcb.services.eyeid.EyeidRestClient;
//import com.hcb.services.eyeid.dto.Captures;
//import com.hcb.services.eyeid.hateos.CaptureResource;
//import com.hcb.services.eyeid.pojos.Capture;
//import com.hcb.services.eyeid.response.CaptureResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Logger log = LoggerFactory.getLogger(Main.class);
        try {

//            EyeidRestClient eyeidRestClient = new EyeidRestClient();
//            eyeidRestClient.setExternalCall(true);
//            eyeidRestClient.setServiceTie("server");
//            List<Capture> response = eyeidRestClient.getCaptures("1343e9303-e89b-12d3-a456-426614174");
//            log.info("Response {}", response)
//            eyeidRestClient.
//            ConfigurationRestClient configurationRestClient = new ConfigurationRestClient();
//            configurationRestClient.setBASE_URL("http://bioenroll-server-app.hcb/rest/");
//            CaptureResponse captureBySide = eyeidRestClient.getCaptureBySide("1343e9303-e89b-12d3-a456-426614174000", "LEFT");
//            log.info("Response {}", captureBySide);

//            CaptureResponse deleteCaptureBySide = eyeidRestClient.deleteCaptureBySide("1343e9303-e89b-12d3-a456-426614174", "right");
//            log.info("Response {}", deleteCaptureBySide);
            HashMap<String, String> filesUrl = new HashMap<>();
            filesUrl.put("client-app-installer-1.0-SNAPSHOT.jar", "http://bioenroll-server-app.hcb/rest/configuration/deployments/022af4a9-51c4-40cb-935a-213342820a7d/files/client-app-installer-1.0-SNAPSHOT.jar");
            filesUrl.put("configuration-war-1.0-SNAPSHOT.war", "http://bioenroll-server-app.hcb/rest/configuration/deployments/022af4a9-51c4-40cb-935a-213342820a7d/files/configuration-war-1.0-SNAPSHOT.war");

            for (String key : filesUrl.keySet()) {
                String originalUrl = filesUrl.get(key);
                String encodedUrl = URLEncoder.encode(originalUrl, "UTF-8");
                filesUrl.put(key, encodedUrl);
            }

            String applicationDirectory = "C:\\HCB\\Open Dock";
            File applicationPath = new File(applicationDirectory);

            String[] updaterArguments = new String[2];
            updaterArguments[0] = applicationDirectory.toString();
            Gson gson = new Gson();
            String filesHashMap = gson.toJson(filesUrl);
            updaterArguments[1] = filesHashMap;
            String jarPath = applicationPath.getAbsolutePath() + File.separator + "installer-updater-1.0-SNAPSHOT.jar";
            String fileData = readFile("C:\\Users\\ikechukwue\\Documents\\Works\\Study\\CodingTests\\installer-update.txt");
            System.out.println("FILE DATE: "+ fileData);
//            ProcessBuilder processBuilder = new ProcessBuilder(
//                    "java",
//                    "-jar",
//                    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005",
//                    jarPath,
//                    "\""+applicationDirectory.toString()+"\"",
//                    "\""+filesHashMap+"\""
//            );
////            processBuilder.command().addAll(Arrays.asList(updaterArguments));
//            processBuilder.directory(applicationPath);
//            processBuilder.redirectErrorStream(true);
//            Process process = processBuilder.start();
//            // Start a thread to monitor the process output
//            Thread outputThread = new Thread(() -> {
//                try (InputStream inputStream = process.getInputStream();
//                     BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
//
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        System.out.println(line);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            outputThread.start();
//
//            // Wait for the process to finish
//            int exitCode = process.waitFor();
//            outputThread.join();

//            System.out.println("Program finished with exit code: " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String filePath) throws Exception {
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
//            log.debug("Error reading file: {}", e.getMessage());
            throw new Exception("Error reading file: " + e.getMessage());
        }
    }

    public static int FirstFactorial(int num) {
        // code goes here
        int input = num;
        if ((num - 1) == 0) {
            return num;
        } else {
            for (int i = input; i >= 2; i--) {
                num = num * (i - 1);
            }
        }

        return num;

    }


    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length() || s == null || t == null) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
            }
        }

        return true;
    }

    public static String findIntersection(String[] strArr) {
        // code goes here
        String[] firstStringArr = strArr[0].split(",");
        String[] secondStringArr = strArr[1].split(",");
        StringBuilder intersection = new StringBuilder();
        for (int i = 0; i < firstStringArr.length; i++) {
            for (int j = 0; j < secondStringArr.length; j++) {
                if (firstStringArr[i].equals(secondStringArr[j])) {
                    intersection.append(firstStringArr[i]).append(",");
                }
            }
        }

        // if(intersection.isEmpty()){
        //   return "false"
        // }

        return intersection.length() == 0 ? "false" : intersection.toString().substring(0, intersection.length() - 1);
    }
}
