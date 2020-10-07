package com.example.amazonses.service;

import com.example.amazonses.model.EmailList;
import com.example.amazonses.model.Template;
import com.example.amazonses.repository.EmailListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailListService {

    @Autowired
    private EmailListRepository emailListRepository;

    public EmailList createEmailList(EmailList emailList) {
        return emailListRepository.save(emailList);
    }

    public List<EmailList> getAllEmailList() {
        return emailListRepository.findAll();
    }

    public EmailList getSingleEmailList(Integer id) {
        return emailListRepository.findById(id).orElse(null);
    }

    public EmailList updateEmailList(Integer id, EmailList emailList) {
        emailList.setId(id);
        return emailListRepository.save(emailList);
    }

    public void deleteAllEmailList() {
        emailListRepository.deleteAll();
    }

    public void deleteSingleEmailList(Integer id) {
        emailListRepository.deleteById(id);
    }
}
