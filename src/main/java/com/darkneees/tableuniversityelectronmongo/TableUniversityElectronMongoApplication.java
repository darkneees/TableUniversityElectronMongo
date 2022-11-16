package com.darkneees.tableuniversityelectronmongo;

import com.darkneees.tableuniversityelectronmongo.Entity.*;
import com.darkneees.tableuniversityelectronmongo.Service.TypeComponentServiceImpl;
import com.darkneees.tableuniversityelectronmongo.Service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Set;

@SpringBootApplication
public class TableUniversityElectronMongoApplication implements CommandLineRunner {

    private final UserServiceImpl userService;
    private final TypeComponentServiceImpl typeComponentService;

    public TableUniversityElectronMongoApplication(UserServiceImpl userService, TypeComponentServiceImpl typeComponentService) {
        this.userService = userService;
        this.typeComponentService = typeComponentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TableUniversityElectronMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setUserRoles(Set.of(new UserRole("OWNER")));

        userService.createUser(user);



        /////////////////////////////

//        TypeComponent typeComponent = new TypeComponent("resistor", "Резисторы");
//        typeComponentService.addTypeComponent(typeComponent);
//        TypeComponent typeComponent = typeComponentService.getTypeComponentByKey("resistor");
//
//        HashMap<String, Field> fields = new HashMap<>();
//        fields.put("id", new Field(true, 521));
//        fields.put("name", new Field(true, "Резистор чип, 100Вт, 1%"));
//        fields.put("value", new Field(true, "1,dsa7 кОм"));
//        fields.put("package", new Field(true, "smd0dasd805"));
//        fields.put("amount", new Field(true, 132123));
//        fields.put("note", new Field(false, "dsafsa"));
//        fields.put("section", new Field(true, 2));
//
//        typeComponent.addComponent(fields);
//        typeComponentService.addTypeComponent(typeComponent);
    }
}
