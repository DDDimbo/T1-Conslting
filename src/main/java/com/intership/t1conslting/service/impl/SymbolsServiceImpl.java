package com.intership.t1conslting.service.impl;

import com.intership.t1conslting.dto.SymbolsDto;
import com.intership.t1conslting.service.SymbolsService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SymbolsServiceImpl implements SymbolsService {

    @Override
    public Map<String, Integer> findSymbolsFrequency(SymbolsDto symbols) {
        final String text = symbols.getText();
        final Map<String, Integer> hashMap = new HashMap<>();
        String c;
        for (int i = 0; i < text.length(); i++) {
            c = String.valueOf(text.charAt(i));
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
        // Сортировка списка по значению в убывающем порядке
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        // Создание отсортированной LinkedHashMap
        LinkedHashMap<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }


}
