package org.example.eventpublish.controllers;

import org.example.eventpublish.business.PurchaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
public class PurcasheApi {

    private final PurchaseService orderService;

    public PurcasheApi(final PurchaseService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/purchase")
    public String purcashe(@RequestBody Map<String, String> stringMap) {
        return orderService.purchase(stringMap);
    }

    @PostMapping("/update-purchased-item")
    public String updatePurchasedItem(@RequestBody Map<String, String> stringMap) {
        return orderService.updatePurchasedItem(stringMap).toString();
    }
}
