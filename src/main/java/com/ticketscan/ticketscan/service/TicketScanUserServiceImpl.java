package com.ticketscan.ticketscan.service;

import com.ticketscan.ticketscan.dto.TicketScanUser;
import com.ticketscan.ticketscan.repository.TicketScanUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TicketScanUserServiceImpl {

    @Autowired
    private TicketScanUserRepository ticketScanUserRepository;

    public Mono<TicketScanUser> registerUser(TicketScanUser user) {
        return ticketScanUserRepository.save(user);
    }

    public Mono<TicketScanUser> loginUser(TicketScanUser user) {
        return ticketScanUserRepository.findByEmailAndPassword(user.getEmail(), user.getPassword())
                .switchIfEmpty(ticketScanUserRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()));
    }

}
