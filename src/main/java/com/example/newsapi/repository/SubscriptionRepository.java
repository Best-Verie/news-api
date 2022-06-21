package com.example.newsapi.repository;

import com.example.newsapi.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
