import java.util.HashSet;
import java.util.List;
public class AnswerCheck {
    /**
     *Returns a double that represents the points a player's answer would receive based on the correct answer.
     * <p>
     * @param correctAnswer a String that represents the correct answer for that song, includes artist name and song title separated by spaces (in no particular order)
     * @param input a String that represents what the player enters, will be compared to correctAnswer to determine score
     */
    public double countPoints (String correctAnswer, String input){
        double points = 0;
        String[] inputWords = input.trim().toLowerCase().split(" ");
        String[] answerWords = correctAnswer.trim().toLowerCase().split(" ");
//        System.out.println(Arrays.toString(answerWords));
        String[] excludedWords = {"and", "featuring", "feat.", "(feat.", "(featuring", "the", "by", "or", "a", "-", "+", "I", "(official", "music", "video)", "official", "video"};
        HashSet<String> correctInputWords = new HashSet<>();
        HashSet<String> answerWordsSet = new HashSet<>(List.of(answerWords));
        //remove excluded words from answerWordsSet
        for(String s : excludedWords){
            if(answerWordsSet.contains(s)){
                answerWordsSet.remove(s);
//                System.out.println("removed " + s);
            }
        }

//        System.out.print("answerWordsSet: ");
//        for (String value : answerWordsSet) {
//            System.out.print(value + " ");
//        }
//        System.out.println();

        for(String s : inputWords){
            if(answerWordsSet.contains(s)){
                correctInputWords.add(s);
//                System.out.println(s);
            }
        }

        System.out.print("correctInputWords: ");
        for (String value : correctInputWords) {
            System.out.print(value + " ");
        }
        System.out.println("");
        for(int i=0;i< correctInputWords.size();i++){
            points+=1;
        }

        return points;
    }
}
