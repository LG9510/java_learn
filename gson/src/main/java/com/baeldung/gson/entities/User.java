package com.baeldung.gson.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private int id;

    private String name;

    private transient String nationality;

    public User(int id, String name) {
        this(id, name, null);
    }
}
