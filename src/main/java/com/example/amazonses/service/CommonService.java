package com.example.amazonses.service;

import com.example.amazonses.dto.request.TriggerTemplateRequest;
import com.example.amazonses.dto.smtp.SMTPEmailRequest;
import com.example.amazonses.model.EmailList;
import com.example.amazonses.model.Recipient;
import com.example.amazonses.model.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired
    private TemplateService templateService;

    @Autowired
    private EmailListService emailListService;

    @Autowired
    private RecipientService recipientService;

    @Autowired
    private SmtpService smtpService;

    public void triggerTemplate(TriggerTemplateRequest triggerTemplateRequest) {
        Template template = templateService.getSingleTemplate(triggerTemplateRequest.getTemplateId());
        EmailList emailList = emailListService.getSingleEmailList(triggerTemplateRequest.getEmailListId());

        List<Recipient> recipientList = recipientService.getRecipientByIds(emailList.getRecipientIDs());
        recipientList.stream().forEach(r -> processRecipient(template, r));
    }

    private void processRecipient(Template template, Recipient recipient) {
        SMTPEmailRequest request = new SMTPEmailRequest();
        // TODO: Make this configurable
        request.setFrom("avaiyahm@gmail.com");
        request.setTo(recipient.getEmail());
        request.setSubject(template.getSubject());
        request.setBody(template.getContent());
        smtpService.send(request);
    }
}
