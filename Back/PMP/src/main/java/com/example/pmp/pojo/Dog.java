package com.example.pmp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dandan
 * @date 2024/1/25 12:45
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    private String breed;
    private int size;
    private String colour;
    private int age;

}
