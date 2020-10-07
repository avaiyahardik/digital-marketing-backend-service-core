package com.example.amazonses.controller;

import com.example.amazonses.model.EmailList;
import com.example.amazonses.model.Template;
import com.example.amazonses.service.EmailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emaillist")
public class EmaliListController {

    @Autowired
    private EmailListService emailListService;

    @PostMapping
    public EmailList createEmailList(@RequestBody EmailList emailList) {
        return emailListService.createEmailList(emailList);
    }

    @GetMapping
    public List<EmailList> getAllEmailList() {
        return emailListService.getAllEmailList();
    }

    @GetMapping("{id}")
    public EmailList getSingleEmailList(@PathVariable Integer id) {
        return emailListService.getSingleEmailList(id);
    }

    @PutMapping("{id}")
    public EmailList updateEmailList(@PathVariable Integer id, @RequestBody EmailList emailList) {
        return emailListService.updateEmailList(id, emailList);
    }

    @DeleteMapping
    public void deleteAllEmailList() {
        emailListService.deleteAllEmailList();
    }

    @DeleteMapping("{id}")
    public void deleteSingleEmailList(@PathVariable Integer id) {
        emailListService.deleteSingleEmailList(id);
    }
}
