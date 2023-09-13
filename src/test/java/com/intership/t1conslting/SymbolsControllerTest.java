package com.intership.t1conslting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intership.t1conslting.dto.SymbolsDto;
import com.intership.t1conslting.service.SymbolsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SymbolsControllerTest {
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SymbolsService service;

    private final SymbolsDto symbols = new SymbolsDto("aaaccbbbb");

    /**
     * Тест на проверку метода findSymbolsFrequencyTest
     */

    @Test
    void findSymbolsFrequency() throws Exception {
        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("b", 4);
        hashMap.put("a", 3);
        hashMap.put("c", 2);

        String json = mapper.writeValueAsString(hashMap);
        when(service.findSymbolsFrequency(any())).
                thenReturn(hashMap);

        MvcResult result = mvc.perform(get("/t1-consulting/symbols_frequency")
                        .content(mapper.writeValueAsString(symbols))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertEquals(response, json);
    }


    /**
     * Тест на проверку метода serverCheck
     */

    @Test
    void serverCheck() throws Exception {
        mvc.perform(get("/t1-consulting")
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
