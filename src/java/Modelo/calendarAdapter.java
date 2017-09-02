package Modelo;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class calendarAdapter implements JsonSerializer<Calendar>{

    @Override
    public JsonElement serialize(Calendar t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", t.getId());
        jsonObject.addProperty("title", t.getTitle());
        jsonObject.addProperty("start", t.getStart());
        jsonObject.addProperty("end", t.getEnd());
        jsonObject.addProperty("color", t.getColor());
        return jsonObject; 
    }
    
}
