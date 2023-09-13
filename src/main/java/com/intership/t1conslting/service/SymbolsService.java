package com.intership.t1conslting.service;

import com.intership.t1conslting.dto.SymbolsDto;

import java.util.Map;

public interface SymbolsService {

    Map<String, Integer> findSymbolsFrequency(SymbolsDto symbols);
}
