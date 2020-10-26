package com.example.deserialization.springdeserializationdemo.Models;

public class AdminUser extends User{
    public AdminUser(String username, String avatarFileName) {
        super(username, avatarFileName);
    }

    @Override
    public String listStatistics(){
        // Fetch all user statistics from Database
        return  "\nuser1, Wins: 5, losses: 6, remis: 1,\n" +
                "user2, Wins: 7, losses: 1, remis: 4,\n" +
                "user3, Wins: 2, losses: 7, remis: 0";
    }
}
