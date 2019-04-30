package com.example.crud;
import javax.persistence.*;

@Entity
public class Event {
    @Id
    private int id;
    private String name;
    private int startTime;
    private String requestor;
    private int roomNumber;
    private boolean isConfirmed;

    public Event() {
    }

    public Event(int id, String name, int startTime, String requestor, int roomNumber) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.requestor = requestor;
        this.roomNumber = roomNumber;
        this.isConfirmed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public String getRequestor() {
        return requestor;
    }

    public int getRoom() {
        return roomNumber;
    }

    public boolean getStatus() {
        return isConfirmed;
    }

    public void setStatus(boolean status) {
        this.isConfirmed = status;
    }

}