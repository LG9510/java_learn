package com.baeldung.gson.serialization;

import com.baeldung.gson.entities.ActorGson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.List;

public class ActorGsonSerializer implements JsonSerializer<ActorGson> {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public JsonElement serialize(ActorGson actorGson, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject actorJsonObj = new JsonObject();
        actorJsonObj.addProperty("<strong>IMDB Code</strong>",actorGson.getImdbId());
        actorJsonObj.addProperty("<strong>Date Of Birth</strong>", actorGson.getDateOfBirth() != null ? sdf.format(actorGson.getDateOfBirth()) : null);
        actorJsonObj.addProperty("<strong>N° Film:</strong>", actorGson.getFilmography() != null ? actorGson.getFilmography().size() : null);
        actorJsonObj.addProperty("filmography", actorGson.getFilmography() != null ? convertFilmography(actorGson.getFilmography()) : null);

        return actorJsonObj;
    }

    private String convertFilmography(List<String> filmography) {
        return String.join("-", filmography);
    }
}
