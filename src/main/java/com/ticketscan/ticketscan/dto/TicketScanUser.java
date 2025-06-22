package com.ticketscan.ticketscan.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ticket_scan_users")
public class TicketScanUser {
    @Id
    private String id;
    private String userName;
    private String name;
    private String email;
    private String password;
}