package edu.xavier.csci.group2.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/insert")
    public void insert() {
        sampleService.insertSomeData();
    }

    @GetMapping("/show")
    public Event[] show() {
        return sampleService.getEvent(10);
    }
}
