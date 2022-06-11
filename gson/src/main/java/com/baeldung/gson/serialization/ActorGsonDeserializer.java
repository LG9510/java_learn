package com.baeldung.gson.serialization;

import com.baeldung.gson.entities.ActorGson;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ActorGsonDeserializer implements JsonDeserializer<ActorGson> {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

    @Override
    public ActorGson deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final JsonElement jsonImdbId = jsonObject.get("imdbId");
        final JsonElement jsonDateOfBirth = jsonObject.get("dateOfBirth");
        final JsonArray jsonFilmography = jsonObject.getAsJsonArray("filmography");

        final ArrayList<String> filmList = new ArrayList<>();
        if (jsonFilmography != null) {
            for (int i = 0; i < jsonFilmography.size(); i++) {
                filmList.add(jsonFilmography.get(i).getAsString());
            }
        }
        ActorGson actorGson = null;
        try {
            actorGson = new ActorGson(jsonImdbId.getAsString(), sdf.parse(jsonDateOfBirth.getAsString()), filmList);
        } catch (ParseException e) {
            // TODO: 2022/5/29 Auto-generated catch block
            throw new RuntimeException(e);
        }
        return actorGson;
    }
}
