package com.intership.t1conslting.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
public class SymbolsDto {


    @NotNull
    private String text;
}
