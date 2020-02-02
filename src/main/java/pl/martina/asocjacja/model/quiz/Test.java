package pl.martina.asocjacja.model.quiz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
// @NoArgsConstructor // 1sposób na dodanie konstruktora bezargumentowego
public class Test extends EntityBase {

    private String name;

    public Test(String name) {
        this.name = name;
    }

    //2 sposob
    public Test(){
    }

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL) //mapujemy po tescie
    /*cascade, css - zagnieżdzanie jedno w drugim
    np. zagnieżdzamy w tescie pytania, dzięki temu usuwajac test, usuwamy tez pytania
    można zagnieżdżać encje w encji
    Klasa EntityBase - super klasa, po której będziemy dziedziczyć
    */


    private List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        question.setTest(this);  // przypisujemy, że pytanie nalezy do danego testu
        questions.add(question);  //dodajemy przypisane pytanie do testu
    }
}
