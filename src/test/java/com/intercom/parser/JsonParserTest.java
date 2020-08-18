package com.intercom.parser;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.intercom.adapter.UserAdapter;
import com.intercom.user.Customer;
import com.intercom.user.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for {@link JsonParser}
 *
 * @author mtatarnikava
 */
public class JsonParserTest {
    private static final Gson gsonParser = configureGsonParser();

    private static Gson configureGsonParser() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(User.class, new UserAdapter())
                .create();
    }

    @Test
    public void parse_AllFieldsPresent_Success() {
        String inputJson = "{\"latitude\": \"52.986375\", \"user_id\": 1, \"name\": \"John Duffield\", " +
                "\"longitude\": \"-6.043701\"}";
        User expectedUser = new Customer(1, "John Duffield", -6.043701, 52.986375);

        User actualUser = gsonParser.fromJson(inputJson, User.class);

        assertThat("Expected and parsed from json customer objects are not equal", actualUser, is(expectedUser));
    }

    @Test
    public void parse_NotAllFieldsPresent_SetDefaultValue() {
        String inputJson = "{\"latitude\": \"52.986375\", \"user_id\": 1, \"longitude\": \"-6.043701\"}";

        User actualUser = gsonParser.fromJson(inputJson, User.class);

        assertThat("Skipped field value must be set to default",
                ((Customer)actualUser).getName(), equalTo(null));
    }

    @Test
    public void parse_ExtraFieldInJson_FieldSkipped() {
        String inputJson = "{\"latitude\": \"52.986375\", \"dummy_field\": abc, \"name\": \"John Duffield\", " +
                "\"longitude\": \"-6.043701\", \"user_id\": 1}";
        User expectedUser = new Customer(1, "John Duffield", -6.043701, 52.986375);

        User actualUser = gsonParser.fromJson(inputJson, User.class);

        assertThat("Users must be equal - even when json contains extra fields", actualUser, is(expectedUser));
    }
}
