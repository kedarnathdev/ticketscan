package com.ticketscan.ticketscan.controller;

import com.ticketscan.ticketscan.dto.TicketScanUser;
import com.ticketscan.ticketscan.service.TicketScanUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class TicketScanUserController {

    @Autowired
    private TicketScanUserServiceImpl ticketScanUserServiceImpl;

    @PostMapping("/register")
    public Mono<TicketScanUser> registerUser(@RequestBody TicketScanUser user) {
        return ticketScanUserServiceImpl.registerUser(user);
    }

    @PostMapping("/login")
    public Mono<TicketScanUser> loginUser(@RequestBody TicketScanUser user) {
        return ticketScanUserServiceImpl.loginUser(user);
    }

    @GetMapping("/test")
    public Mono<String> test() {
        System.out.println("TicketScan User Service is running!");
        return Mono.just("TicketScan User Service is running!");
    }

}
