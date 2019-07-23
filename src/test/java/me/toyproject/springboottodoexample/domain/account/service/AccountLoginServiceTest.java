package me.toyproject.springboottodoexample.domain.account.service;

import me.toyproject.springboottodoexample.domain.account.dto.LoginRequest;
import me.toyproject.springboottodoexample.domain.account.dto.Token;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class AccountLoginServiceTest {

    @Test
    void fetchToken() {
        AccountLoginService accountLoginService = new AccountLoginService();
        LoginRequest loginRequest = new LoginRequest("tester", "test");

        Token token = accountLoginService.fetchToken(loginRequest);
        assertThat(token.getAccessToken()).isNotEmpty();
        assertThat(token.getRefreshToken()).isNotEmpty();
    }
}