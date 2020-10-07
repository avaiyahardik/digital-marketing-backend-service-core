package com.example.amazonses.service;

import com.example.amazonses.model.Recipient;
import com.example.amazonses.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;
import java.util.stream.Collectors;

@Service
public class RecipientService {

    @Autowired
    private RecipientRepository recipientRepository;

    public Recipient createRecipient(Recipient recipient) {
        return recipientRepository.save(recipient);
    }

    public List<Recipient> getAllRecipient() {
        return recipientRepository.findAll();
    }

    public Recipient getSingleRecipient(Integer id) {
        return recipientRepository.findById(id).orElse(null);
    }

    public Recipient updateRecipient(Integer id, Recipient recipient) {
        recipient.setId(id);
        return recipientRepository.save(recipient);
    }

    public void deleteAllRecipient() {
        recipientRepository.deleteAll();
    }

    public void deleteSingleRecipient(Integer id) {
        recipientRepository.deleteById(id);
    }

    public List<Recipient> getRecipientByIds(String ids) {
        List<Integer> idList = Arrays.stream(ids.split(",")).mapToInt(id -> Integer.parseInt(id.trim())).boxed().collect(Collectors.toList());
        return recipientRepository.findByIdIn(idList);
    }
}
