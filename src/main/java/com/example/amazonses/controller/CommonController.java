package com.example.amazonses.controller;

import com.example.amazonses.dto.request.TriggerTemplateRequest;
import com.example.amazonses.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @PostMapping("/trigger")
    public void triggerTemplate(@RequestBody TriggerTemplateRequest triggerTemplateRequest) {
        commonService.triggerTemplate(triggerTemplateRequest);
    }


}
