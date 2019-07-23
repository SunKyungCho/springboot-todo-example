package me.toyproject.springboottodoexample.domain.account;


import me.toyproject.springboottodoexample.domain.account.dto.LoginRequest;
import me.toyproject.springboottodoexample.domain.account.dto.Token;
import me.toyproject.springboottodoexample.domain.account.service.AccountLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AccountLoginService accountLoginService;

    @PostMapping("/login")
    public ResponseEntity<Token> login(LoginRequest request) {
        return new ResponseEntity<>(accountLoginService.fetchToken(request), HttpStatus.OK);
    }
}
