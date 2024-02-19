package test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PerfectPairs {
    public static void main(String[] args) {
        // Your original path
        String originalPath = "C:\\HCB\\Open Dock\\jre\\bin";

        // Convert the string path to a Path object
        Path path = Paths.get(originalPath);

        // Get the parent path of the given path
        Path parentPath = path.getParent().getParent();

        if (parentPath != null) {
            String resultPath = parentPath.toString();
            System.out.println(resultPath);
        } else {
            System.out.println("Given path has no parent.");
        }
    }


}
