package com.intercom.adapter;

import com.intercom.user.Customer;

/**
 * Class for getting the type of {@link com.intercom.user.User} - to be parsed from a file, used in {@link UserAdapter} only
 *
 * @author mtatarnikava
 */
public class UserTypeAdapterFactory {
    /**
     * @return class Class - {@link Customer} - as it's the only subclass of {@link com.intercom.user.User},
     * but could be extended later
     */
    public static Class get() {
        return Customer.class;
    }
}
