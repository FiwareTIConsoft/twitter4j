package twitter4j.util;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonUtils {

    public static String serialize(Object obj) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
                .create();
        return gson.toJson(obj);
    }

    public static class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {

        @Override
        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDateTime.toString());
        }
    }
}
