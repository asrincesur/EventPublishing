package org.example.eventpublish.business;

import org.example.eventpublish.dataaccess.PersonalRepository;
import org.example.eventpublish.models.Personal;
import org.example.eventpublish.models.ProductProjection;
import org.example.eventpublish.models.Products;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PersonalRepository personalRepository;

    private final ApplicationEventPublisher eventPublisher;


    public PurchaseService(PersonalRepository personalRepository, ApplicationEventPublisher eventPublisher) {
        this.personalRepository = personalRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public String purchase(Map<String, String> stringMap) {
        Optional<Personal> byEmail = personalRepository.findByEmail(stringMap.get("email"));
        byEmail.ifPresent(personal -> {
            if (personal.getProducts() != null) {
                personal.getProducts().add(new Products("Battery", 3L, 12));
            } else {
                personal.setProducts(List.of(new Products("Battery", 3L, 12)));
            }
            personalRepository.save(byEmail.get());
        });
        eventPublisher.publishEvent(new Products("SD Card", 12L, 1));
        return "purchased";
    }




    @Transactional
    public Personal updatePurchasedItem(Map<String, String> stringMap) {
        Optional<Personal> productsByEmail = personalRepository.findByEmail(stringMap.get("email"));
        productsByEmail.ifPresent(x->{

            x.getProducts().getFirst().setProductName("TESTTTTTTTT");// set something logic.
        });
        //u can save or leave it to dirtychenking
        return productsByEmail.get();
    }
}
