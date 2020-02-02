package pl.martina.asocjacja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.martina.asocjacja.model.quiz.Test;

@Repository
public interface TestRepository extends CrudRepository<Test,Long> {

    /*CrudRepository lub JpaRepository,
    -dziedziczymy po jednym lub drugim,
     w zalezności od tego jakie metody nas interesują
    -to nic innego jak po prostu zbior metod
    */


}
