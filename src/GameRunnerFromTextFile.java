import java.util.ArrayList;
import java.util.Scanner;

public class GameRunnerFromTextFile {
    public void runGameFromTextFile(ArrayList<String> entryArrayList) {
        double finalScore = 0;
        Scanner scanner = new Scanner(System.in);
        AnswerCheck instance = new AnswerCheck();

        for (String entry : entryArrayList) {
            System.out.println("answer is: " + entry);
            System.out.println("Playing song... guess it");

            String userAnswer = scanner.nextLine();

            if (userAnswer.equals("/end")) {
                System.out.println("your total score: " + finalScore);
                System.exit(0);
            }

            double num = 0.0;
            while (num == 0.0) {
                double scoreThisRound = instance.countPoints(entry, userAnswer);
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


