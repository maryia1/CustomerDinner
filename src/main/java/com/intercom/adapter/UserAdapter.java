package com.intercom.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.intercom.user.User;

import java.lang.reflect.Type;

/**
 * Class for deserialization(also could be added serialization in future) for different types of {@link User} objects
 *
 * Used when interacting with resources (in particularly, in {@link com.intercom.parser.JsonParser}
 *
 * @author mtatarnikava
 */
public class UserAdapter implements JsonDeserializer<User> {
    /**
     * Deserialize json element to {@link User} object
     * Uses {@link UserTypeAdapterFactory} to get concrete type of {@link User}
     * @return base object - {@link com.intercom.user.User}
     */
    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return jsonDeserializationContext.deserialize(jsonElement, UserTypeAdapterFactory.get());
    }
}
