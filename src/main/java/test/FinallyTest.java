package test;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FinallyTest {
    public static void main(String[] args) {
        hello();
    }

    public static void hello() {
        try {
           Path path = Paths.get("C:\\Users\\ikechukwue\\Documents\\Captura");
           Path newPath = path.resolve("newPath");
//           Files.createDirectories(path.resolve("newPath").resolve("one"));
//           Files.createDirectories(path.resolve("newPath").resolve("two"));
           FileUtils.deleteDirectory(newPath.toFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
