package com.baeldung.gson.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class StringDateMapDeserializer implements JsonDeserializer<Map<String, Date>> {
    private static final Logger logger = LoggerFactory.getLogger(StringDateMapDeserializer.class);

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    @Override
    public Map<String, Date> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        System.out.println("Deserializer called");
        logger.info("Deserializer called");
        return jsonElement.getAsJsonObject().entrySet().stream()
                .filter(e -> e.getValue().isJsonPrimitive())
                .filter(e -> e.getValue().getAsJsonPrimitive().isString())
                .collect(Collectors.toMap(Map.Entry::getKey, e -> formatDate(e.getValue())));
    }

    private Date formatDate(JsonElement value) {
        try {
            return format.parse(value.getAsString());
        } catch (ParseException e) {
            throw new JsonParseException(e);
        }
    }
}