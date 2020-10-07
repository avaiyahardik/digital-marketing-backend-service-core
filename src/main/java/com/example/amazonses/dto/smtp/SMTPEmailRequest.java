package com.example.amazonses.dto.smtp;

import lombok.Data;

@Data
public class SMTPEmailRequest {
    private String to;
    private String body;
    private String from;
    private String subject;
}
