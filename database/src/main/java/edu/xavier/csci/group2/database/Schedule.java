package edu.xavier.csci.group2.database;

public class Schedule {
    private int user_id;
    private int event_id;
    private String event_name;
    private int room_number;


    public Schedule(int id, int event_id, String event_name, int room_number) {
        this.user_id = user_id;
        this.event_id = event_id;
        this.event_name = event_name;
        this.room_number = room_number;

    }
    @Override
    public String toString(){
        return String.format(
                "Event Name: %s Time: %d:00 - %d:00 Room Number : %s", event_name, room_number);
    }
    public int getId(){
        return user_id;
    }
    public int getEventId(){
        return event_id;
    }
    public String getEvent_name(){
        return event_name;
    }
    public int getRoom_number(){
        return room_number;
    }
}