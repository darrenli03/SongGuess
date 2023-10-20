import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class GameRunnerFromMap {

    public void runGameFromMap (ArrayList<Map.Entry<String,String>> entryArrayList){
        double finalScore = 0;
        Scanner scanner = new Scanner(System.in);
        AnswerCheck instance = new AnswerCheck();

        for (Map.Entry<String, String> entry : entryArrayList) {
            System.out.println("videoID is: " + entry.getKey());
            System.out.println("Video Title is: " + entry.getValue());

            System.out.println("Playing song... guess it");


            double num = 0.0;
            while (num == 0.0) {
                String userInput = scanner.nextLine();
                if (userInput.equals("/end")) {
                    System.out.println("your total score: " + finalScore);
                    System.exit(0);
                }
                double scoreThisRound = instance.countPoints(entry.getValue(), userInput);
                if (scoreThisRound == 0) {
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
