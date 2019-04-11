package edu.xavier.csci.group2.database;

public class User {
    private int user_id;
    private String user_name;

    public User(int id, String user_name){
        this.user_id = user_id;
        this.user_name = user_name;
    }
    @Override
    public String toString(){
        return String.format(
                "User name: ", user_name);

    }
    public int getId() {
        return user_id;
    }

    public String getUser_name(){
        return user_name;
    }
}
