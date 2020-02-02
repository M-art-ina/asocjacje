package pl.martina.asocjacja.dto.mapper;

import org.springframework.stereotype.Component;
import pl.martina.asocjacja.dto.TestDto;
import pl.martina.asocjacja.model.quiz.Test;

@Component //najbardziej ogolna adnotacja
public class TestMapper {

    private QuestionMapper questionMapper = new QuestionMapper();

    public TestDto mapToTestDto(Test test){ //przyjmujemy obiekt Test
        TestDto testDto = new TestDto();

        testDto.setName(test.getName()); //obiekt test ma nazwe, wiec ja wyciagamy do MapperTest

        testDto.setQuestions(questionMapper.mapToListQuestionDto(test.getQuestions())); //struktura pyan zawiera się
        // z pytan i odpowiedzi, potrzebny dto, który zawiera 2 różne kolumny

        return testDto;
    }

}
