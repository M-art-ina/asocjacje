package pl.martina.asocjacja.model.quiz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Question extends EntityBase { //chcemy miec id w tej encji wiec dziedziczymy

    @JoinColumn(name="test_id")
    @ManyToOne //z perspektywy pytania mamy wiele pytan do jedego testu
    private Test test; //enkapsulacja - obiekt typu Test jest tworzony w typie Question

    private String content;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL) //jedno pytanie - wiele odpowiedzi
    private List<Answer> answers = new ArrayList<>();

    public Question(String content){
        this.content = content;
    }


    public void addAnswer(Answer answer) {
        answer.setQuestion(this); //na obiekcie odpowiedz ustalamy wartosc answer
        answers.add(answer);
    }
}
