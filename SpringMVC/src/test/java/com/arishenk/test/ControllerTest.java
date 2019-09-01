package com.arishenk.test;

import com.arishenk.WebController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileReader;
import java.util.Scanner;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private WebController controller;

    @Test
    public void contextLoads() throws Exception {
        org.assertj.core.api.Assertions.assertThat(controller).isNotNull();
    }

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void getUser() throws Exception {
        StringBuilder response = new StringBuilder();
        FileReader fr = new FileReader("src/main/resources/templates/response.html");
        Scanner inFile = new Scanner(fr);
        while (inFile.hasNextLine()) {
            response.append(inFile.nextLine());
            response.append("\n");
        }
        response.deleteCharAt(response.length() - 2);
        response.deleteCharAt(response.length() - 1);
        fr.close();

        this.mockMvc.perform(get("http://localhost:8081/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(response.toString())));
    }
}