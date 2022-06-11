package com.baeldung.gson.serialization;

import com.baeldung.gson.entities.Employee;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

public class MapDeserializer implements JsonDeserializer<Map<String, Object>> {
    @Override
    public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        return jsonElement.getAsJsonObject().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().isJsonPrimitive() ?
                                toPrimitive(e.getValue().getAsJsonPrimitive(), context) : context.deserialize(e.getValue(), Employee.class)));
    }

    private Object toPrimitive(JsonPrimitive jsonValue, JsonDeserializationContext context) {
        if (jsonValue.isBoolean()) {
            return jsonValue.getAsBoolean();
        } else if (jsonValue.isString()) {
            return jsonValue.getAsString();
        } else {
            BigDecimal bigDecimal = jsonValue.getAsBigDecimal();
            Long l;
            Integer i;
            if ((i = toInteger(bigDecimal)) != null) {
                return i;
            } else if ((l = toLong(bigDecimal)) != null) {
                return l;
            } else {
                return bigDecimal.doubleValue();
            }
        }
    }

    private Long toLong(BigDecimal val) {
        try {
            return val.toBigIntegerExact().longValue();
        } catch (ArithmeticException e) {
            return null;
        }
    }

    private Integer toInteger(BigDecimal val) {
        try {
            return val.intValueExact();
        } catch (Exception e) {
            return null;
        }
    }
}
