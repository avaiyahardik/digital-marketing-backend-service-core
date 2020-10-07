package com.example.amazonses.controller;

import com.example.amazonses.model.EmailList;
import com.example.amazonses.model.Recipient;
import com.example.amazonses.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipient")
public class RecipientController {

    @Autowired
    private RecipientService recipientService;

    @PostMapping
    public Recipient createRecipient(@RequestBody Recipient recipient) {
        return recipientService.createRecipient(recipient);
    }

    @GetMapping
    public List<Recipient> getAllRecipient() {
        return recipientService.getAllRecipient();
    }

    @GetMapping("{id}")
    Recipient getSingleRecipient(@PathVariable Integer id) {
        return recipientService.getSingleRecipient(id);
    }

    @PutMapping("{id}")
    public Recipient updateRecipient(@PathVariable Integer id, @RequestBody Recipient recipient) {
        return recipientService.updateRecipient(id, recipient);
    }

    @DeleteMapping
    public void deleteAllRecipient() {
        recipientService.deleteAllRecipient();
    }

    @DeleteMapping("{id}")
    public void deleteSingleRecipient(@PathVariable Integer id) {
        recipientService.deleteSingleRecipient(id);
    }
}
