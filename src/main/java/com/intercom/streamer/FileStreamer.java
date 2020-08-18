package com.intercom.streamer;

import com.intercom.parser.IParser;
import com.intercom.parser.JsonParser;
import com.intercom.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * File implementation of {@link IStreamer}
 * Uses {@link IParser} for parsing file
 *
 * @author mtatarnikava
 */
public class FileStreamer implements IStreamer {
    private static final IParser jsonParser = new JsonParser();
    private static final Logger log = LogManager.getLogger(FileStreamer.class);

    @Override
    public List<User> read(Path filePath) {
        List<User> userList = new ArrayList<>();

        try (Stream<String> lineStream = Files.lines(filePath)) {
            lineStream.forEach( line -> userList.add(jsonParser.parse(line)));
        } catch (IOException exc) {
            log.error("Error occurred while writing to file: " + filePath, exc);
        }
        return userList;
    }

    @Override
    public void write(List<User> userList, Path filePath) {
        clearFileContent(filePath);

        userList.forEach(user -> {
            try{
                Files.write(filePath, (user.toString() + System.lineSeparator()).getBytes(UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException exc) {
                log.error("Error occurred while writing to file: " + filePath, exc);
            }
        });
    }

    private void clearFileContent(Path filePath) {
        try{
            Files.write(filePath, new byte[0]);
        } catch (IOException exc) {
            log.error("Error occurred while writing to file: " + filePath, exc);
        }
    }
}
