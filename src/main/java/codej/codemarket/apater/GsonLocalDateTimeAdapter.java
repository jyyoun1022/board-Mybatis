package codej.codemarket.apater;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonLocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {


    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime));
    }

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return LocalDateTime.parse(jsonElement.getAsString(),DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
