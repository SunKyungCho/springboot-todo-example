package me.toyproject.springboottodoexample.domain.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String name;
    private String password;
    private String grant_type;

    public LoginRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
