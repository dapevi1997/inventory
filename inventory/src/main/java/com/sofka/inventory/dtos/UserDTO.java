package com.sofka.inventory.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String userLastName;
    private String userPassword;
    private String userEmail;
    private String userRole;
}
