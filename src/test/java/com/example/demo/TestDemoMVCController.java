package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class TestDemoMVCController {

    @Autowired
    private MockMvc mock;

    @Test
    public void testHello() throws Exception {
        this.mock.perform(get("/hello")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Ynov")));
    }
}
