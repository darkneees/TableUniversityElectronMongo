package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.TemplateField;
import com.darkneees.tableuniversityelectronmongo.Repository.TemplateFieldRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateFieldServiceImpl implements TemplateFieldService {

    private final TemplateFieldRepository templateFieldRepository;

    public TemplateFieldServiceImpl(TemplateFieldRepository templateFieldRepository) {
        this.templateFieldRepository = templateFieldRepository;
    }

    @Override
    public List<TemplateField> getAllTemplateFields() {
        return null;
    }

    @Override
    public void addTemplateField(TemplateField templateField) {
        templateFieldRepository.save(templateField);
    }

    @Override
    public TemplateField getTemplateFieldByKey(String key) {
        return templateFieldRepository.findById(key).orElse(new TemplateField());
    }

}
