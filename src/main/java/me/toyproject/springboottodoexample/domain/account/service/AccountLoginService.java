package me.toyproject.springboottodoexample.domain.account.service;

import me.toyproject.springboottodoexample.domain.account.dto.LoginRequest;
import me.toyproject.springboottodoexample.domain.account.dto.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountLoginService {

    private final static String GRANT_TYPE_PASSWORD = "password";
    private final static String AUTHORIZATION_URL = "http://localhost:8080/oauth/token";

    @Autowired
    RestTemplate AuthRestTemplate;

    public Token fetchToken(LoginRequest user) {

        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.postForObject(AUTHORIZATION_URL, getStringObjectMultiValueMap(user), Token.class);
    }

    private MultiValueMap<String, Object> getStringObjectMultiValueMap(LoginRequest user) {
        MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
        postParameters.add("grant_type", GRANT_TYPE_PASSWORD);
        postParameters.add("username", user.getName());
        postParameters.add("password", user.getPassword());
        return postParameters;
    }

    private RestTemplate getRestTemplate() {
        return new RestTemplateBuilder()
                    .basicAuthentication("myApp", "pass")
                    .build();
    }
}
