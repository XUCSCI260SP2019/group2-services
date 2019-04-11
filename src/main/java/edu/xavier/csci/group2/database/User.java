package edu.xavier.csci.group2.database;

public class User {
    private int user_id;
    private String user_name;
    private String password;

    public User(int user_id, String user_name, String password) {
        this.user_id = user_id;
        this.user_name= user_name;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format(
                "Username: %s User id: %d:",
                user_name, user_id);
    }
    public int getId() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }


}

