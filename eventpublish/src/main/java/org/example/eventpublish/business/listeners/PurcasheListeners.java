package org.example.eventpublish.business.listeners;

import lombok.extern.slf4j.Slf4j;
import org.example.eventpublish.models.Products;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PurcasheListeners {

    @EventListener
    public void billingNotification(Products products){
        log.info("purchased: {}", products);
    }

}
