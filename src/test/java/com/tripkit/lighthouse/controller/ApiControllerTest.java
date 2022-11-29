package com.tripkit.lighthouse.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc   // -> webAppContextSetup(webApplicationContext)
@AutoConfigureRestDocs  // -> apply(documentationConfiguration(restDocumentation))
@SpringBootTest
class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    private ManualRestDocumentation restDocumentation = new ManualRestDocumentation();

    @Test
    void getTest() throws Exception{
        mockMvc.perform(get("/api/")).andExpect(status().isOk());
    }

    @Test
    void getTest2() {
    }
}