package com.baeldung.gson.entities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    @SerializedName(value = "location", alternate = "place")
    private String location;

    @SerializedName(value = "temp", alternate = "temperature")
    private int temp;

    @SerializedName(value = "outlook", alternate = "weather")
    private String outlook;
}
