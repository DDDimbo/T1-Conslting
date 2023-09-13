package com.intership.t1conslting;

import com.intership.t1conslting.dto.SymbolsDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@JsonTest
public class SymbolsDtoJsonTest {

    @Autowired
    private JacksonTester<SymbolsDto> json;

    private final SymbolsDto symbolsDto = new SymbolsDto("abcd");

    @Test
    void testUserDto() throws Exception {
        JsonContent<SymbolsDto> result = json.write(symbolsDto);
        assertThat(result).extractingJsonPathStringValue("$.text").isEqualTo("abcd");
    }
}