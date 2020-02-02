package pl.martina.asocjacja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.martina.asocjacja.dto.TestDto;
import pl.martina.asocjacja.dto.mapper.TestMapper;
import pl.martina.asocjacja.repository.TestRepository;

@RestController //zmieniamy Controller(zwraca html - widok) na RestController(zwraca dane czyli np w jsona)
@CrossOrigin //nie blokuje zapytan z zewnątrz
@RequestMapping("/tests") //każde zapytanie, ktor idzie z adresu /tests trafi do tego TestController

public class TestController {

    @Autowired //wstrzykiwanie zależności, Beana
    private TestMapper testMapper; //obiekty tej klasy zostana utworzone i usuniete dokldnie wtedy kiedy Spring tego chce

    @Autowired
    private TestRepository testRepository;

    @GetMapping("/{id}")    // @GetMapping - polaczenie miedzy przegladarka a IJ, "/" -adres bazowy
        public TestDto sayHello(@PathVariable Long id){
        return testMapper.mapToTestDto(testRepository.findById(id).get());
    }

}
