package pl.martina.asocjacja.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

    private Long id;    //id naszego zapytania do bazy, a nie id w bazie
    private String content;
    private List<String> options = new ArrayList<>(); //lista niepoprawnych odp
    private String answer; //lista poprawnych odpowiedzi

    public QuestionDto(String content) {
        this.content = content;
    }
}
