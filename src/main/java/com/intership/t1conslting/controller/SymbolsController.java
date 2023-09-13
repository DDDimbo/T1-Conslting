package com.intership.t1conslting.controller;

import com.intership.t1conslting.dto.SymbolsDto;
import com.intership.t1conslting.service.SymbolsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/t1-consulting")
@RequiredArgsConstructor
public class SymbolsController {

    private final SymbolsService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void serverCheck() {
        log.info("Server check");
    }

    @PostMapping("/symbols_frequency")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Integer> findSymbolsFrequency(@RequestBody @Valid SymbolsDto symbols) {
        log.info("Get symbols frequency in descending order.");
        return service.findSymbolsFrequency(symbols);
    }
}
