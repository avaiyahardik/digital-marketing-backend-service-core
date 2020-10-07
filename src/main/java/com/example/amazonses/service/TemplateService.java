package com.example.amazonses.service;

import com.example.amazonses.model.Template;
import com.example.amazonses.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    public Template createTemplate(Template template) {
        return templateRepository.save(template);
    }

    public List<Template> getAllTemplate() {
        return templateRepository.findAll();
    }

    public Template getSingleTemplate(Integer id){
        return templateRepository.findById(id).orElse(null);
    }

    public Template updateTemplate(Integer id, Template template) {
        template.setId(id);
        return templateRepository.save(template);
    }

    public void deleteAllTemplate(){
        templateRepository.deleteAll();
    }

    public void deleteSingleTemplate(Integer id){
        templateRepository.deleteById(id);
    }

}
