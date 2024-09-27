package com.automation.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserPojo {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
