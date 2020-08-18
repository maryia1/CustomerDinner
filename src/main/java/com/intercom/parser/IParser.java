package com.intercom.parser;

import com.intercom.user.User;

/**
 * Interface for parsing string from different format to base entity {@link com.intercom.user.User}
 *
 * @author mtatarnikava
 */
public interface IParser {
    /**
     * Parse input string to base {@link com.intercom.user.User}
     * @param lineToParse - input string for parsing
     * @return base object - {@link com.intercom.user.User}
     */
    User parse(String lineToParse);
}
