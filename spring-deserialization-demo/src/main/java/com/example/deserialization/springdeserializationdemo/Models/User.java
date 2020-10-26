package com.example.deserialization.springdeserializationdemo.Models;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -7222079236427045003L;
    private final String username;
    private final String avatarFileName;

    public User(String username, String avatarFileName) {
        this.username = username;
        this.avatarFileName = avatarFileName;
    }

    public String getAvatarFileName() {
        return avatarFileName;
    }

    public String getUsername() {
        return username;
    }

    public String listStatistics(){
        // Fetch this users statistics from the Database
        return "Wins: 5, losses: 6, remis: 1";
    }

}