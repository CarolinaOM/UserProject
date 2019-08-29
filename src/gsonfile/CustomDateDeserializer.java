package gsonfile;

import java.lang.reflect.Type;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonParseException;

import java.time.format.DateTimeParseException;

//JSON to Java Object
public class CustomDateDeserializer implements JsonDeserializer<OffsetDateTime>{

    //Format: 2007-12-03T10:15:30+01:00
    private static final DateTimeFormatter formatTime = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
 
    @Override
    public OffsetDateTime deserialize(JsonElement date, Type typeOfSrc, JsonDeserializationContext context) {
        try {
            //Obtains an instance of OffsetDateTime from a text string
            return OffsetDateTime.parse(date.getAsString(), this.formatTime);
        }catch(DateTimeParseException | IllegalStateException | JsonParseException | ClassCastException ex){
            System.out.println("Error " + ex.getMessage());
        }
        return null;
    }
    
}
