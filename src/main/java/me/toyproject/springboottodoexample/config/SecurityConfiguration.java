package me.toyproject.springboottodoexample.config;


import me.toyproject.springboottodoexample.Accounts.domain.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService)
                .passwordEncoder(passwordEncoder);
    }

    //    시큐리티 필터 적용여부
    @Override
    public void configure(WebSecurity web) throws Exception {
        //시큐리티가 걸리지 않도록 처리한다.
        web.ignoring().mvcMatchers("/");
        //정적 Path는 무시
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

//    이건 form 인증
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .anonymous()
//                .and()
//                .formLogin()
//                .and()
//                .authorizeRequests()
//                .mvcMatchers(HttpMethod.GET, "todo_list")
//                .anonymous()
//                .anyRequest().authenticated();
//    }
}
