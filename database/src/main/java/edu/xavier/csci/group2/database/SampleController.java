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
    public int insert() {
    return 21;
    }

    @GetMapping("/show")
    public Event[] show() {
        return sampleService.getEvent(1);
    }
}
