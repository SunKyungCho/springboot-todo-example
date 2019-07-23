//package me.toyproject.springboottodoexample.domain.todo.api;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import me.toyproject.springboottodoexample.domain.account.AccountRole;
//import me.toyproject.springboottodoexample.domain.account.AccountService;
//import me.toyproject.springboottodoexample.domain.todo.domain.Todo;
//import me.toyproject.springboottodoexample.domain.todo.dto.TodoRequest;
//import me.toyproject.springboottodoexample.domain.todo.service.TodoService;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.JacksonJsonParser;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.Arrays;
//import java.util.Set;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@AutoConfigureMockMvc
//@SpringBootTest
//public class TodoControllerTest {
//
//    @MockBean
//    TodoService todoService;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Autowired
//    AccountService accountService;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    @DisplayName("TodoList 저장")
//    public void save_저장하기() throws Exception {
//
//        //given
//        String task = "go to bed";
//        TodoRequest todoRequest = new TodoRequest(task);
//        given(todoService.createNewTodo(ArgumentMatchers.any(TodoRequest.class))).willReturn(new Todo(task));
//
//        //when
//        ResultActions resultActions = mockMvc.perform(post("/todo_list")
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .content(objectMapper.writeValueAsString(todoRequest)))
//                .andDo(print());
//
//        //then
//        resultActions
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("task").value(task))
//                .andExpect(jsonPath("done").value(false));
//    }
//
//    @Test
//    @DisplayName("TodoList 불러오기")
//    public void get_불러오기() throws Exception {
//
//        //given
//        Todo first = new Todo("first");
//        Todo second = new Todo("second");
//        given(todoService.findAll()).willReturn(Arrays.asList(
//                first,
//                second
//        ));
//
//        assertThat(first.getTask()).isEqualTo("first");
//
//        //when
//        ResultActions resultActions = mockMvc.perform(get("/todo_list")
//        .header(HttpHeaders.AUTHORIZATION, "Bearer" + obtainAccessToken()))
//                .andDo(print());
//
//        //then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].task").value(first.getTask()))
//                .andExpect(jsonPath("$[0].done").value(first.isDone()))
//                .andExpect(jsonPath("$[1].task").value(second.getTask()))
//                .andExpect(jsonPath("$[1].done").value(second.isDone()));
//    }
//
//    private String obtainAccessToken() throws Exception {
//
//        String clientId = "myApp";
//        String clientSecret = "pass";
//
//        String username= "tester";
//        String pass= "test";
//        Account account = Account.builder()
//                .name(username)
//                .password(passwordEncoder.encode(pass))
//                .roles((Set.of(AccountRole.USER, AccountRole.ADMIN)))
//                .build();
//
////        accountService.saveAccount(account);
//
//        ResultActions resultActions = this.mockMvc.perform(post("/oauth/token")
//                .with(httpBasic(clientId, clientSecret))
//                .param("username", username)
//                .param("password", pass)
//                .param("grant_type", "password")
//        )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("access_token").exists());
//
//        String resultString = resultActions.andReturn().getResponse().getContentAsString();
//
//        JacksonJsonParser jsonParser = new JacksonJsonParser();
//        return jsonParser.parseMap(resultString).get("access_token").toString();
//    }
//}