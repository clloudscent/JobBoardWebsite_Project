package com.example.project_careerwebsite.domain;

import jakarta.persistence.*;

@Entity
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private JobPosting jobPosting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobPosting getJobPosting() {
        return jobPosting;
    }

    public void setJobPosting(JobPosting jobPosting) {
        this.jobPosting = jobPosting;
    }
}
