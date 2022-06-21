package com.example.newsapi.model;

import com.example.newsapi.enumerations.EPlans;

public class SubscriptionDto {
    private Long user;
    private EPlans plan;

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public EPlans getPlan() {
        return plan;
    }

    public void setPlan(EPlans plan) {
        this.plan = plan;
    }
}
