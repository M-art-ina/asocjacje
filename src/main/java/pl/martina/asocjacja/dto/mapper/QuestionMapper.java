package pl.martina.asocjacja.dto.mapper;

import org.springframework.stereotype.Component;
import pl.martina.asocjacja.dto.QuestionDto;
import pl.martina.asocjacja.model.quiz.Answer;
import pl.martina.asocjacja.model.quiz.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMapper {

    //chcemy przyjac Question a oddac obiekt DTO
    public QuestionDto mapToQuestionDto(Question question){
        QuestionDto questionDto = new QuestionDto(question.getContent()); //wyciagamy content
        questionDto.setId(question.getId()); //wyciagamy id z Question

        List<Answer> answers = question.getAnswers();

        /*//1 sposob - iterowanie po tablicy Answear, tworzac tablice Stringow
        List<String> answersName = new ArrayList<>();
        for (int i = 0; i < answersName.size(); i++) {
            answersName.add(answers.get(i).getName());
        }*/

        //2 sposob - poprzez stream
        List<String> answersName2 = answers.stream()
                .map(x -> x.getName())
                .collect(Collectors.toList());

        questionDto.setOptions(answersName2);

        //1 sposob przez petle, wyciagamy booleana czy odp jest poprawna
        String correctAnswer = "";
        for (int i = 0; i < answers.size(); i++) {
            if(answers.get(i).isCorrect()){
                correctAnswer = answers.get(i).getName();
            }
        }
        questionDto.setAnswer(correctAnswer);

        return questionDto; //mamy question dto zawierajacy prawidlowe odpowiedzi
    }
     //Liste obiektow typu Question mapujemy na listę obiektow typu QuestionDto
    public List<QuestionDto> mapToListQuestionDto(List<Question> questions){
        return questions.stream()
                .map(question -> mapToQuestionDto(question))
                .collect(Collectors.toList());
    }
}
