package com.example.newsapi.controller;

import com.example.newsapi.model.Subscription;
import com.example.newsapi.model.SubscriptionDto;
import com.example.newsapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping("/create")
    public Subscription createSubscription(@RequestBody SubscriptionDto subscriptionDto){
        return subscriptionService.createSubscription(subscriptionDto);
    }
}
