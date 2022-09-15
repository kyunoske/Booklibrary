package com.example.booklibrary.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DirtiesContext
    @Test
    void getAllBooks() throws Exception {
        //given
        String books = """
                [
                    {
                        "title": "Hans im Glück",
                        "author": "Jacob Grimm",
                        "id": "1"
                    },
                    {
                        "title": "Java ist auch eine Insel",
                        "author": "Christian Ullenboom",
                        "id": "2"
                    },
                    {
                        "title": "Die besten Flachwitze für Coaches",
                        "author": "Dominic",
                        "id": "3"
                    }
                ]
                """;

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/book"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [
                            {
                                "title": "Hans im Glück",
                                "author": "Jacob Grimm",
                                "id": "1"
                            },
                            {
                                "title": "Java ist auch eine Insel",
                                "author": "Christian Ullenboom",
                                "id": "2"
                            },
                            {
                                "title": "Die besten Flachwitze für Coaches",
                                "author": "Dominic",
                                "id": "3"
                            }
                        ]
                        """));

    }

    @DirtiesContext
    @Test
    void getBookById() throws Exception {
        //given
        String id = "2";

        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/book/"+id))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                                                        "title": "Java ist auch eine Insel",
                                                        "author": "Christian Ullenboom",
                                                        "id": "2"
                                                    }
                """));
    }

    @DirtiesContext
    @Test
    void addBook() throws Exception {
        //Given
        String requestedBody = """
                {
                    "id": "4",
                    "title": "A Cat Named Garfield",
                    "author": "Odie"
                }
                """;

        String expectedResponseBody = """
                {
                    "id": "4",
                    "title": "A Cat Named Garfield",
                    "author": "Odie"
                }
                """;

        //When & Then
        mockMvc.perform(
                post("/book")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .content(requestedBody))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponseBody));
    }
}