package com.hackerrank.github.dto;

import java.sql.Timestamp;

public class EventDTO {

    private Long id;
    private String type;
    private ActorDTO actor;
    private RepoDTO repo;

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    private Timestamp createdAt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ActorDTO getActor() {
        return actor;
    }

    public void setActor(ActorDTO actor) {
        this.actor = actor;
    }

    public RepoDTO getRepo() {
        return repo;
    }

    public void setRepo(RepoDTO repo) {
        this.repo = repo;
    }
}
