package pl.martina.asocjacja.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data //gettery, settery z TestDto
public class TestDto {

    private String name;

    private List<QuestionDto> questions = new ArrayList<>();

}
