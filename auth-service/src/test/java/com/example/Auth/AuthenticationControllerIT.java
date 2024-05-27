package com.example.Auth;

import com.example.Auth.models.AuthentificationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/** Integration tests for {@link com.example.Auth.controllers.AuthenticationController} */
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerIT {

    private final MockMvc mockMvc;

    @Autowired
    public AuthenticationControllerIT(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void TestRegistration() throws Exception {
        String json = "{\n" +
                "\"firstName\": \"fname\",\n" +
                "\"lastName\": \"lname\",\n" +
                "\"login\": \"anonymous\",\n" +
                "\"email\": \"anonymous@gmail.com\",\n" +
                "\"password\": \"1234\"\n" +
                "}";

        MvcResult result = mockMvc
                .perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                        .characterEncoding("utf-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseString = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        AuthentificationResponse response = objectMapper.readValue(responseString, AuthentificationResponse.class);

        // Assertions to verify the response
        assertNotNull(response);
        assertNotNull(response.getToken());
    }

    @Test
    public void TestAuthentication() throws Exception {
        String json = "{\n" +
            "\"email\": \"said1@gmail.com\",\n" +
            "\"password\": \"1234\"\n" +
            "}";

        MvcResult result = mockMvc
                .perform(post("/api/auth/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .characterEncoding("utf-8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseString = result.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        AuthentificationResponse response = objectMapper.readValue(responseString, AuthentificationResponse.class);

        // Perform assertions on the response object
        assertNotNull(response.getToken());
        assertNotNull(response.getUserId());
        assertEquals("salhjef", response.getUserName());
        assertNotNull(response.getFriends());
    }
}
