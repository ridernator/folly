package com.rider.folly.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * TypeAdaptor for the Date class which can be given to Gson. Betfair's API-NG
 * requires all dates to be serialized in ISO8601 UTC.
 */
public class ISO8601DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
    public static final String ISO_8601_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String ISO_8601_TIMEZONE = "UTC";

    private final DateFormat dateFormat;

    public ISO8601DateTypeAdapter() {
        dateFormat = new SimpleDateFormat(ISO_8601_FORMAT_STRING);
        dateFormat.setTimeZone(TimeZone.getTimeZone(ISO_8601_TIMEZONE));
    }

    @Override
    public synchronized JsonElement serialize(final Date date,
                                              final Type type,
                                              final JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(dateFormat.format(date));
    }

    @Override
    public synchronized Date deserialize(final JsonElement jsonElement,
                                         final Type type,
                                         final JsonDeserializationContext jsonDeserializationContext) {
        try {
            return dateFormat.parse(jsonElement.getAsString());
        } catch (final ParseException exception) {
            throw new JsonParseException(exception);
        }
    }
}
