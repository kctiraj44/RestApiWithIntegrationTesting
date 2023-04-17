package com.example.springbootfull.entity;

import javax.persistence.Entity;

@Entity
public class MemberSchema {
    private String fullName;
    private  String username;
    private String password;
    private  String task;
    private String teams;
    private Boolean admin;

    public MemberSchema(String fullName, String username, String password, String task, String teams, Boolean admin) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.task = task;
        this.teams = teams;
        this.admin = admin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
