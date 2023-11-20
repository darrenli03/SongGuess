import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        String filePath = "data/songs1.txt";//only used for getting song titles from text file
        GameRunnerFromTextFile gameRunnerFromTextFile = new GameRunnerFromTextFile();
        GameRunnerFromMap gameRunnerFromMap = new GameRunnerFromMap();
        VideoSearch vs = new VideoSearch();
        HashMap<String, String> videoMap = vs.getVideoMap();

//      comment these lines out to switch between YouTube API call and getting song titles from text file
        ArrayList<Map.Entry<String, String>> entryArrayList = new ArrayList<>(videoMap.entrySet());
//        ArrayList<String> entryArrayList = new ArrayList<>(TextFileReader.readLinesFromFile(filePath));

        System.out.println("number of entries: " + entryArrayList.size());
        Collections.shuffle(entryArrayList);
//        comment these lines out to switch between running game from ArrayList of Map.Entry<String,String> or ArrayList<String>
        gameRunnerFromMap.runGameFromMap(entryArrayList);
//        gameRunnerFromTextFile.runGameFromTextFile(entryArrayList);

    }
}
