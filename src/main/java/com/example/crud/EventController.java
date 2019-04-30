package com.example.crud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    private List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        eventRepository.findAll().forEach(event -> events.add(event));
        for(int i = 0; i < events.size(); i++){
            if(!events.get(i).getStatus()){
                events.remove(i);
            }
        }
        return events;
    }

    @GetMapping("/pending")
    private List<Event> getAllPending() {
        List<Event> events = new ArrayList<Event>();
        List<Event> pend = new ArrayList<Event>();
        eventRepository.findAll().forEach(event -> events.add(event));
        for(int i = 0; i < events.size(); i++){
            if(!events.get(i).getStatus()){
                pend.add(events.get(i));
            }
        }
        return pend;
    }

    @GetMapping("/events/{id}")
    private Event getEvent(@PathVariable("id") int id) {
        if(eventRepository.findById(id).get().getStatus()){
            return eventRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("/events/room/{room}")
    private List<Event> getEventBySlot(@PathVariable("room") int room) {
        List<Event> events = new ArrayList<Event>();
        List<Event> refinedEvents = new ArrayList<Event>();
        eventRepository.findAll().forEach(event -> events.add(event));

            for(int i = 0; i < events.size(); i++){
                if(events.get(i).getRoom() == room ){
                    if(events.get(i).getStatus()) {
                        refinedEvents.add(events.get(i));
                    }
                }
            }
        return refinedEvents;
    }

    void removeAll(List<Integer> list, int element) {
        list.removeIf(n -> Objects.equals(n, element));
    }

    @GetMapping("/events/time/{time}")
    private List<Integer> getEventByTime(@PathVariable("time") int time) {
        List<Event> events = new ArrayList<Event>();
        List<Integer> refinedRooms = new ArrayList<Integer>();
        List<Integer> blacklistedRooms = new ArrayList<Integer>();
        eventRepository.findAll().forEach(event -> events.add(event));

        for(int i = 0; i < events.size(); i++) {
            if (events.get(i).getStartTime() != time) {
                if (events.get(i).getStatus()) {
                    if(!refinedRooms.contains(events.get(i).getRoom()))
                    refinedRooms.add(events.get(i).getRoom());
                }
            } else {
                blacklistedRooms.add(events.get(i).getRoom());
            }
        }

            for (int k = 0; k < blacklistedRooms.size(); k++) {
                removeAll(refinedRooms,blacklistedRooms.get(k));
            }

        return refinedRooms;
    }

    @DeleteMapping("/events/{id}")
    private void deleteEvent(@PathVariable("id") int id) {
        eventRepository.deleteById(id);
    }

    @PostMapping("/events")
    private void postEvent(@RequestBody Event event){
        eventRepository.save(event);
    }

    @PostMapping("/confirm")
    private void confirm(@RequestBody Event event) {
    event.setStatus(true);
    eventRepository.save(event);

    }
}