package com.darkneees.tableuniversityelectronmongo.Controller;

import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;
import com.darkneees.tableuniversityelectronmongo.Service.TypeComponentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class IndexController {

    private final TypeComponentServiceImpl typeComponentService;

    public IndexController(TypeComponentServiceImpl typeComponentService) {
        this.typeComponentService = typeComponentService;
    }

    @GetMapping("/components")
    public String getIndexPage(){
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
}