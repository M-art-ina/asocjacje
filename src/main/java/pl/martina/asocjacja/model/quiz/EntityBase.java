package pl.martina.asocjacja.model.quiz;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass //pozwala na mapowanie jej przez dziecko, jęsli jakas klasa dziedziczy po EntityBase
                // i jest mapowana hibernatem   -na bazach danych dziedziczenie przez dziedziczenie nie działa
                //adnotacja ta pozwala na dziedziczenie przez dziecko z matki i z poziomu wyzej

public class EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
