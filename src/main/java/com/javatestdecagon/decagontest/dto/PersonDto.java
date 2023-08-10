package com.javatestdecagon.decagontest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {


    @NotBlank(message = "email should not be blank")
    private String email;
    private String name;

    private int age;
}
