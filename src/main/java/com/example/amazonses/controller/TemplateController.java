package com.example.amazonses.controller;

import com.example.amazonses.model.Template;
import com.example.amazonses.repository.TemplateRepository;
import com.example.amazonses.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping
    public Template createTemplate(@RequestBody Template template) {
        return templateService.createTemplate(template);
    }

    @GetMapping
    public List<Template> getAllTemplate() {
        return templateService.getAllTemplate();
    }

    @GetMapping("{id}")
    public Template getSingleTemplate(@PathVariable Integer id) {
        return templateService.getSingleTemplate(id);
    }

    @PutMapping("{id}")
    public Template updateTemplate(@PathVariable Integer id, @RequestBody Template template) {
        return templateService.updateTemplate(id, template);
    }

    @DeleteMapping
    public void deleteAllETemplate() {
        templateService.deleteAllTemplate();
    }

    @DeleteMapping("{id}")
    public void deleteSingleTemplate(@PathVariable Integer id) {
        templateService.deleteSingleTemplate(id);
    }

}
