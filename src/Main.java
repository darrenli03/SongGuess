import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;


import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        AnswerCheck instance = new AnswerCheck();
        Scanner scanner = new Scanner(System.in);
//        List<Map.Entry<String, String>> bob = new LinkedList<>();
        double finalScore = 0;
        String apiKey = "AIzaSyDJ_iUELWlmMNW6qSXO9FdBDZGmu65oUzs";
        VideoSearch vs = new VideoSearch();
        HashMap<String, String> videoMap = vs.getVideoMap();
        ArrayList<Map.Entry<String,String>> entryHashSet = new ArrayList<>(videoMap.entrySet());
        System.out.println(entryHashSet.size());
        Collections.shuffle(entryHashSet);

//        bob.addAll(videoMap.entrySet());


        for(Map.Entry<String, String> entry : entryHashSet) {
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


}
