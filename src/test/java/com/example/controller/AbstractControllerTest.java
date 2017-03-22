package com.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

/**
 * Created by NeverForgive on 2017-03-22.
 */
@RunWith(MockitoJUnitRunner.class)
public class AbstractControllerTest {

    protected MockMvc mockMvc;

    protected void setUp(Object object){
        mockMvc = MockMvcBuilders.standaloneSetup(object).build();
    }

    protected String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(object);
    }

    protected <T> T mapFromJson(String content, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(content, clazz);
    }

}
