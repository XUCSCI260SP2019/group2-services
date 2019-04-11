package edu.xavier.csci.group2.database;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Scanner;


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

    @GetMapping("/login")
    public boolean login() {
        System.out.println("Enter your username: ");
        Scanner user = new Scanner(System.in);
        String username = user.nextLine();

        System.out.println("Enter your password: ");
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine();

        return(sampleService.login(username, password));
    }

    @GetMapping("/register")
    public String register() {
        System.out.println("Enter your allcard ID: ");
        Scanner ID = new Scanner(System.in);
        int allCard = ID.nextInt();

        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine();

       if(sampleService.register(allCard,username, password) == true){
           login();
       } else {
           return "Something went wrong!";
       }
       return "success";
    }
}
