package com.example.amazonses.service;

import com.example.amazonses.dto.smtp.SMTPEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SmtpService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(SMTPEmailRequest request) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(request.getFrom());
//        message.setTo(request.getTo());
//        message.setSubject(request.getSubject());
//        message.setText(request.getBody());
//        javaMailSender.send(message);

        MimeMessage msg = javaMailSender.createMimeMessage();
        try {
            // true = multipart message
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setFrom(request.getFrom());
            helper.setSubject(request.getSubject());
            helper.setTo(request.getTo());
            helper.setText(request.getBody(), true);
            javaMailSender.send(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
