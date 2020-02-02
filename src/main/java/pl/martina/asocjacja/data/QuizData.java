package pl.martina.asocjacja.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.martina.asocjacja.model.quiz.Answer;
import pl.martina.asocjacja.model.quiz.Question;
import pl.martina.asocjacja.model.quiz.Test;
import pl.martina.asocjacja.repository.TestRepository;

@Component
public class QuizData implements CommandLineRunner { //CommandLineRunner- interfejs, ktory uruchamia sie jako pierwszy


    @Autowired
    TestRepository testRepository;

    @Override
    public void run(String... args) throws Exception {

        Test test = new Test("Test of knowledge");
        Question question1 = new Question("What is the Capitol of Poland");
        question1.addAnswer(new Answer("Warsaw",true));
        question1.addAnswer(new Answer("Mumbai",false));
        question1.addAnswer(new Answer("Kolkatta",false));

        Question question2 = new Question("Who is CEO of Tesla Motors?");
        question2.addAnswer(new Answer("Bill Gates",false));
        question2.addAnswer(new Answer("Steve Jobs",false));
        question2.addAnswer(new Answer("Elon Musk",true));



        test.addQuestion(question1);
        test.addQuestion(question2);
     
        testRepository.save(test); //do naszej bazy danych testRepository zapisalismy nasz test
    }
}
