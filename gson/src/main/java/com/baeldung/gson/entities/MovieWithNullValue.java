package com.baeldung.gson.entities;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieWithNullValue {
    @Expose
    private String imdbId;

    private String director;

    @Expose
    private List<ActorGson> actors;
}
