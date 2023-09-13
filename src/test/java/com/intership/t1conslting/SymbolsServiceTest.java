package com.intership.t1conslting;

import com.intership.t1conslting.dto.SymbolsDto;
import com.intership.t1conslting.service.SymbolsService;
import com.intership.t1conslting.service.impl.SymbolsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(MockitoExtension.class)
public class SymbolsServiceTest {

    private final SymbolsService symbolsService = new SymbolsServiceImpl();

    @Test
    void findSymbolsFrequency() {
        final SymbolsDto symbols = new SymbolsDto("aaaccbbbb");

        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("b", 4);
        hashMap.put("a", 3);
        hashMap.put("c", 2);
        final var result = symbolsService.findSymbolsFrequency(symbols);

        assertThat(result, equalTo(hashMap));
    }

    @Test
    void findSymbolsFrequencyWithSameValueCount() {
        final SymbolsDto symbols = new SymbolsDto("aaccbb");

        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 2);
        hashMap.put("b", 2);
        hashMap.put("c", 2);
        final var result = symbolsService.findSymbolsFrequency(symbols);

        assertThat(result, equalTo(hashMap));
    }

    @Test
    void findSymbolsFrequencyWithNumber() {
        final SymbolsDto symbols = new SymbolsDto("11111ccbbbb");

        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("1", 5);
        hashMap.put("b", 4);
        hashMap.put("c", 2);
        final var result = symbolsService.findSymbolsFrequency(symbols);

        assertThat(result, equalTo(hashMap));
    }

    @Test
    void findSymbolsFrequencyBlank() {
        final SymbolsDto symbols = new SymbolsDto("   ");

        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put(" ", 3);
        final var result = symbolsService.findSymbolsFrequency(symbols);

        assertThat(result, equalTo(hashMap));
    }

    @Test
    void findSymbolsFrequencyWithSpace() {
        final SymbolsDto symbols = new SymbolsDto("aaa ccbb");

        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a", 3);
        hashMap.put("b", 2);
        hashMap.put("c", 2);
        hashMap.put(" ", 1);
        final var result = symbolsService.findSymbolsFrequency(symbols);

        assertThat(result, equalTo(hashMap));
    }

    @Test
    void findSymbolsFrequencyOtherSymbols() {
        final SymbolsDto symbols = new SymbolsDto("aaacccc❤❤");

        final Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("c", 4);
        hashMap.put("a", 3);
        hashMap.put("❤", 2);
        final var result = symbolsService.findSymbolsFrequency(symbols);

        assertThat(result, equalTo(hashMap));
    }
}