package com.baeldung.gson.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String address;
}
