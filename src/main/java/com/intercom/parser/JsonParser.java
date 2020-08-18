package com.intercom.parser;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intercom.adapter.UserAdapter;
import com.intercom.user.User;

/**
 * Json implementation of {@link IParser} interface for parsing data from strings
 * Uses {@link Gson} object for parsing from json format to base {@link User} object
 *
 * @author mtatarnikava
 */
public class JsonParser implements IParser{
    /**
     * Configuring instance of {@link Gson} object for parsing from json format
     * with naming policy - lower case with underscores,
     * registering adapter - @see {@link UserAdapter} object
     * in order to allow to parse different types of base {@link User} entities
     */
    private static final Gson jsonParser = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(User.class, new UserAdapter())
            .create();

    @Override
    public User parse(String jsonToParse){
        return jsonParser.fromJson(jsonToParse, User.class);
    }
}
