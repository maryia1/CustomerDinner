package com.intercom.streamer;

import com.intercom.user.User;

import java.nio.file.Path;
import java.util.List;

/**
 * IReader - interface for reading data from different resources
 *
 * @author mtatarnikava
 */
public interface IStreamer {
    /**
     * Reads data from a resource.
     * @param resourcePath - path of a resource to get the data
     * @return list of basic objects - {@link com.intercom.user.User}
     */
    List<User> read(Path resourcePath);

    /**
     * Writes data to resource.
     * @param userList - objects {@link com.intercom.user.User} to be written to resource
     * @param resourcePath - path of a resource to put the data
     */
    void write(List<User> userList, Path resourcePath);
}
