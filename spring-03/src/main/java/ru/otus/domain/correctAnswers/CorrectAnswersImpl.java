package ru.otus.domain.correctAnswers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ru.otus.domain.questions.Questions;
import java.io.IOException;
import java.util.*;


@Component
@ConditionalOnProperty(
        value="enable.bean",
        havingValue="true"
)
public class CorrectAnswersImpl implements CorrectAnswers {

    @Autowired
    private Questions questions;

    private  List<Integer> answers;


    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    @Override
    public List<Integer> print() throws IOException {

        ResourceBundle bundle=ResourceBundle.getBundle("messages",new Locale("ru","RU"));

        List<String> question = questions.getQuestions();
         answers= new ArrayList<>();

        for (int i = 0; i < question.size(); i++) {
            System.out.println(bundle.getString("mas"+i));
            Scanner sc = new Scanner(System.in);
            answers.add(i,sc.nextInt());
        }

        return answers;
    }



}
