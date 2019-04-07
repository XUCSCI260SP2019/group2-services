package edu.xavier.csci.group2.database;

public class Event {
    private int event_id;
    private String event_name;
    private int start_time;
    private int end_time;
    private int room_number;

    public Event(int id, String event_name, int start_time, int end_time, int room_number) {
        this.event_id = event_id;
        this.event_name= event_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.room_number = room_number;
    }

    @Override
    public String toString() {
        return String.format(
                "Event Name: %s Time: %d:00 - %d:00 Room Number : %s",
                event_name, start_time, end_time, room_number);
    }
    public int getId() {
        return event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public int getStart_time() {
        return start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public int getRoom_number() {
        return room_number;
    }

}
