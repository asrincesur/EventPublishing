package org.example.eventpublish;

import org.example.eventpublish.dataaccess.PersonalRepository;
import org.example.eventpublish.models.Personal;
import org.example.eventpublish.models.Products;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private final PersonalRepository personalRepository;


    public AppRunner(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Personal> all = personalRepository.findAll();
        Products product = new Products("Mouse", 25.0, 2);

        if (all.isEmpty()) {
            Personal person1 = new Personal(null, "Ahmet", "pala", "Ankara", 30, "ahmet.kaya@example.com", null);
            Personal person2 = new Personal(null, "Fatma", "Demir", "İstanbul", 28, "fatma.demir@example.com", List.of(product));
            personalRepository.save(person1);
            personalRepository.save(person2);
            System.out.println("record added");
        }

    }
}
