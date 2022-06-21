package com.example.newsapi.service;

import com.example.newsapi.model.Subscription;
import com.example.newsapi.model.SubscriptionDto;
import com.example.newsapi.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserService userService;

    public Subscription createSubscription(SubscriptionDto subscription){
        Subscription newSubscription = new Subscription();
        newSubscription.setUser(userService.getUserById(subscription.getUser()));
        newSubscription.setPlan(subscription.getPlan());
        return subscriptionRepository.save(newSubscription);
    }
}
