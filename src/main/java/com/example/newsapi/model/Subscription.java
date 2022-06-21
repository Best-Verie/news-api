package com.example.newsapi.model;

import com.example.newsapi.enumerations.EPlans;

import javax.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private EPlans plan;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Subscription() {

    }

    public Subscription(Long id, EPlans plan, User user) {
        this.id = id;
        this.plan = plan;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EPlans getPlan() {
        return plan;
    }

    public void setPlan(EPlans plan) {
        this.plan = plan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
