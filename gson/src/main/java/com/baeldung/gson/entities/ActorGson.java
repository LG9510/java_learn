package com.baeldung.gson.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Data
@AllArgsConstructor
public class ActorGson {
    private String imdbId;

    private Date dateOfBirth;

    private List<String> filmography;

    private String formatDateOfBirth() {
        final DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(dateFormat);
    }
}
