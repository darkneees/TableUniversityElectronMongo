package com.darkneees.tableuniversityelectronmongo.Entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;

@Document
public class UserRole implements GrantedAuthority {
    private @MongoId String authority;
    private String nameRole;

    public UserRole() {
    }

    public UserRole(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
