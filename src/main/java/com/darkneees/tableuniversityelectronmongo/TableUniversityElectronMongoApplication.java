package com.darkneees.tableuniversityelectronmongo;

import com.darkneees.tableuniversityelectronmongo.Entity.Component;
import com.darkneees.tableuniversityelectronmongo.Entity.Field;
import com.darkneees.tableuniversityelectronmongo.Entity.TypeComponent;
import com.darkneees.tableuniversityelectronmongo.Service.ComponentServiceImpl;
import com.darkneees.tableuniversityelectronmongo.Service.TypeComponentServiceImpl;
import com.darkneees.tableuniversityelectronmongo.Service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class TableUniversityElectronMongoApplication implements CommandLineRunner {

    private final UserServiceImpl userService;
    private final TypeComponentServiceImpl typeComponentService;
    private final ComponentServiceImpl componentService;

    public TableUniversityElectronMongoApplication(UserServiceImpl userService, TypeComponentServiceImpl typeComponentService, ComponentServiceImpl componentService) {
        this.userService = userService;
        this.typeComponentService = typeComponentService;
        this.componentService = componentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TableUniversityElectronMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setUsername("user");
//        user.setPassword("user");
//        user.setUserRoles(Set.of(new UserRole("OWNER")));
//
//        userService.createUser(user);

        TypeComponent typeComponent = new TypeComponent();
        typeComponent.setKey("resistor");
        typeComponent.setValue("Резисторы");

        typeComponentService.addTypeComponent(typeComponent);

        typeComponent.setKey("capacitor");
        typeComponent.setValue("Конденсаторы");

        typeComponentService.addTypeComponent(typeComponent);
        typeComponent.setKey("transistor");
        typeComponent.setValue("Транзисторы");

        typeComponentService.addTypeComponent(typeComponent);
        typeComponent.setKey("servo");
        typeComponent.setValue("Сервоприводы");

        typeComponentService.addTypeComponent(typeComponent);


        /////////////////////////////

        Component component = new Component();
        component.setKey(typeComponent.getKey());


        HashMap<String, Field> fields = new HashMap<>();
        fields.put("id", new Field(true, 2));
        fields.put("name", new Field(true, "Резистор чип, 1Вт, 1%"));
        fields.put("value", new Field(true, "4,7 кОм"));
        fields.put("package", new Field(true, "smd0805"));
        fields.put("amount", new Field(true, 10));
        fields.put("note", new Field(false, ""));
        fields.put("section", new Field(true, 2));
        fields.put("firstname", new Field(true, "Andrey"));
        component.addField(fields);
        componentService.addComponent(component);


    }
}
