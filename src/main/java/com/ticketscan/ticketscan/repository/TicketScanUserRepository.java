package com.ticketscan.ticketscan.repository;

import com.ticketscan.ticketscan.dto.TicketScanUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface TicketScanUserRepository extends ReactiveMongoRepository<TicketScanUser, String> {
    Mono<TicketScanUser> findByUserName(String userId);
    Mono<TicketScanUser> findByEmailAndPassword(String email, String password);
    Mono<TicketScanUser> findByUserNameAndPassword(String userName, String password);
}
