package me.toyproject.springboottodoexample.todo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.toyproject.springboottodoexample.todo.domain.Todo;
import me.toyproject.springboottodoexample.todo.dto.TodoRequest;
import me.toyproject.springboottodoexample.todo.service.TodoService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WebMvcTest
public class TodoControllerTest {

    @MockBean
    TodoService todoService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("TodoList 저장")
    public void save_저장하기() throws Exception {

        //given
        String task = "go to bed";
        TodoRequest todoRequest = new TodoRequest(task);
        given(todoService.createNewTodo(ArgumentMatchers.any(TodoRequest.class))).willReturn(new Todo(task));

        //when
        ResultActions resultActions = mockMvc.perform(post("/todo_list")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(todoRequest)))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("task").value(task))
                .andExpect(jsonPath("done").value(false));
    }

    @Test
    @DisplayName("TodoList 불러오기")
    public void get_불러오기() throws Exception {

        //given
        Todo first = new Todo("first");
        Todo second = new Todo("second");
        given(todoService.findAll()).willReturn(Arrays.asList(
                first,
                second
        ));

        assertThat(first.getTask()).isEqualTo("first");

        //when
        ResultActions resultActions = mockMvc.perform(get("/todo_list"))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].task").value(first.getTask()))
                .andExpect(jsonPath("$[0].done").value(first.isDone()))
                .andExpect(jsonPath("$[1].task").value(second.getTask()))
                .andExpect(jsonPath("$[1].done").value(second.isDone()));
    }
}