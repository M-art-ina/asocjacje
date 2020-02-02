package pl.martina.asocjacja.model.quiz;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
public class Answer extends EntityBase {

    private String name; //name - tresc odpowiedzi
    private boolean correct;

    @JoinColumn(name="question_id")
    @ManyToOne //z perspektywy odpowiedzi do pytania jest relacja many to one
    private Question question;

    public Answer(String name, boolean correct) {
        this.name = name;
        this.correct = correct;
    }

    public boolean isCorrect(){ //tworzymy gettery samemu bo lombok, czy IJ róznie nazywa gettery z automatu
        return correct;
    }


}
