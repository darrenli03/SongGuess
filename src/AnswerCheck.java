import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AnswerCheck {
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
