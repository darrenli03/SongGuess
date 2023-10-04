import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReader {

    public static ArrayList<String> readLinesFromFile(String filePath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            // Create a File object with the specified file path
            File file = new File(filePath);

            // Create a Scanner object to read from the file
            Scanner scanner = new Scanner(file);

            // Read lines from the file and add them to the list
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }

            // Close the scanner when done
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }

        return lines;
    }

}
