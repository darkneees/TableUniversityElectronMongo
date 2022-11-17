package com.darkneees.tableuniversityelectronmongo.Service;

import com.darkneees.tableuniversityelectronmongo.Entity.TemplateField;

import java.util.List;

public interface TemplateFieldService {

    List<TemplateField> getAllTemplateFields();
    void addTemplateField(TemplateField templateField);
    TemplateField getTemplateFieldByKey(String key);
    void deleteTemplateFields(String key);

}
