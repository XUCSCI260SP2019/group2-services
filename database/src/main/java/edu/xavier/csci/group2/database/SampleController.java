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

    }

    @GetMapping("/show")
    public Customer[] show() {
        return sampleService.getCustomers();
    }
}
