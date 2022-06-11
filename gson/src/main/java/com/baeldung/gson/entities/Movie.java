package com.baeldung.gson.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Movie {
    private String imdbId;

    private String director;

    private List<ActorGson> actors;
}
