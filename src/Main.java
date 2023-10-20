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
        String apiKey = "AIzaSyDJ_iUELWlmMNW6qSXO9FdBDZGmu65oUzs";
        String filePath = "data/songs1.txt";
        VideoSearch vs = new VideoSearch();
        GameRunnerFromMap gameRunnerFromMap = new GameRunnerFromMap();
        GameRunnerFromTextFile gameRunnerFromTextFile = new GameRunnerFromTextFile();
        HashMap<String, String> videoMap = vs.getVideoMap();
//      comment these lines out to switch between youtube api call and getting titles from text file
//        ArrayList<Map.Entry<String, String>> entryArrayList = new ArrayList<>(videoMap.entrySet());
        ArrayList<String> entryArrayList = new ArrayList<>(TextFileReader.readLinesFromFile(filePath));

        System.out.println("number of entries: " + entryArrayList.size());
        Collections.shuffle(entryArrayList);
//        comment these lines out to switch between running game from ArrayList of Map.Entry<String,String> or ArrayList<String>
//        gameRunnerFromMap.runGameFromMap(entryArrayList);
        gameRunnerFromTextFile.runGameFromTextFile(entryArrayList);

    }
}
