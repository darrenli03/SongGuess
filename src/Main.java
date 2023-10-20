import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;


import javax.naming.directory.SearchResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        AnswerCheck instance = new AnswerCheck();
        Scanner scanner = new Scanner(System.in);
        double finalScore = 0;

        String apiKey = "AIzaSyDJ_iUELWlmMNW6qSXO9FdBDZGmu65oUzs";
        String filePath = "data/songs1.txt";
        VideoSearch vs = new VideoSearch();
        HashMap<String, String> videoMap = vs.getVideoMap();
//      comment these lines out to switch between youtube api call and getting titles from text file
        ArrayList<Map.Entry<String,String>> entryArrayList = new ArrayList<>(videoMap.entrySet());
//        ArrayList<String> entryArrayList = new ArrayList<>(TextFileReader.readLinesFromFile(filePath));

        System.out.println(entryArrayList.size());
        Collections.shuffle(entryArrayList);

//        System.out.println(entryArrayList.size());
//        Collections.shuffle(entryArrayList);

//        for(String entry : entryArrayList) {
//            System.out.println("answer is: " + entry);
//            System.out.println("Playing song... guess it");
//
//            String userAnswer = scanner.nextLine();
//
//            if(userAnswer.equals("/end")){
//                System.out.println("your total score: " + finalScore);
//                System.exit(0);
//            }
//
//            double num = 0.0;
//            while(num == 0.0) {
//                double scoreThisRound = instance.countPoints(entry, userAnswer );
//                if(scoreThisRound==0){
//                    System.out.println("That is not the song, try again!");
//                    System.out.println();
//                } else {
//                    num = scoreThisRound;
//                    finalScore += scoreThisRound;
//
//                }
//            }
//
//            System.out.println("points this round: " + num);
//            System.out.println();
//        }
//        System.out.println("your total score: " + finalScore);

        // code for youtube api and map
        for(Map.Entry<String, String> entry : entryArrayList) {
            System.out.println("videoID is: " + entry.getKey());
            System.out.println("Video Title is: " + entry.getValue());

            System.out.println("Playing song... guess it");


            double num = 0.0;
            while(num == 0.0) {

                double scoreThisRound = instance.countPoints(entry.getValue(), scanner.nextLine());
                if(scoreThisRound==0){
                    System.out.println("That is not the song, try again!");
                    System.out.println();
                } else {
                    num = scoreThisRound;
                    finalScore += scoreThisRound;

                }
            }

            System.out.println("points this round: " + num);
            System.out.println();
        }
        System.out.println("your total score: " + finalScore);


    }


    public static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

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
