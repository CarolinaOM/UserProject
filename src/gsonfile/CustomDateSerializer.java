package gsonfile;

import java.lang.reflect.Type;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

//Java Object to JSON
public class CustomDateSerializer implements JsonSerializer<OffsetDateTime> {
    
    //Format: 2007-12-03T10:15:30+01:00
    private static final DateTimeFormatter formatTime = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
 
    @Override   //Serializer: Convert Java date to JSON string
    public JsonElement serialize(OffsetDateTime date, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(this.formatTime.format(date));
    }
    
}
