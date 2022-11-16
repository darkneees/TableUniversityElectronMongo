package com.darkneees.tableuniversityelectronmongo.Controller;

import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;
import com.darkneees.tableuniversityelectronmongo.Service.MapperTemplateField;
import com.darkneees.tableuniversityelectronmongo.Service.TemplateFieldService;
import com.darkneees.tableuniversityelectronmongo.Service.TypeComponentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class IndexController {

    private final TypeComponentServiceImpl typeComponentService;
    private final MapperTemplateField mapperTemplateField;
    private final TemplateFieldService templateFieldService;

    public IndexController(TypeComponentServiceImpl typeComponentService, TemplateFieldService templateFieldService) {
        this.typeComponentService = typeComponentService;
        this.templateFieldService = templateFieldService;
        this.mapperTemplateField = new MapperTemplateField();
    }

    @GetMapping("/")
    public String getIndexPage(Model model){
        model.addAttribute("type_components", typeComponentService.getAllTypeComponents());
        return "index";
    }

    @GetMapping("/type_components")
    public String getConstructorPage(Model model) {
        model.addAttribute("type_components_list", typeComponentService.getAllTypeComponents());
        return "type_components";
    }

    @PostMapping("/type_components")
    @ResponseBody
    public Map<String, Object> addTypeComponent(@RequestParam("key") String key, @RequestParam("value") String value) {
        if(key.equals("") || value.equals("")) throw new RuntimeException("Empty fields");
        TypeComponent typeComponent = new TypeComponent(key, value);
        typeComponentService.addTypeComponent(typeComponent);
        return Map.of("result", "success", "key", key, "value", value);
    }

    @PostMapping("/type_components/delete/{key}")
    @ResponseBody
    public Map<String, String> deleteTypeComponent(@PathVariable("key") String key) {
        typeComponentService.deleteTypeComponent(key);
        return Map.of("result", "success");
    }

    @GetMapping("/type_components/constructor/{key}")
    public String getPageWithTypeConstructor (@PathVariable("key") String key) {
        return "constructor";
    }

    @PostMapping("/type_components/constructor/{key}")
    @ResponseBody
    public Map<String, String> addTypeConstructorForComponent(@PathVariable("key") String key,
                                                              @RequestParam(required = false, name="data") String data) throws JsonProcessingException {
        templateFieldService.addTemplateField(mapperTemplateField.getTemplateFieldsForString(data, key));
        return Map.of("result", "success");
    }
}