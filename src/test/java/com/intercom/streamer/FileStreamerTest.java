package com.intercom.streamer;

import com.intercom.user.Customer;
import com.intercom.user.User;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for {@link FileStreamer}
 *
 * @author mtatarnikava
 */
public class FileStreamerTest {
    private static final IStreamer fileStreamer = new FileStreamer();

    @Test
    public void read_CorrectFile_Success() {
        Path filenamePath = Paths.get("src","test","resources", "customerTest_Success.txt");
        List<User> expectedUserList = configureUserList();

        List<User> actualUserList = fileStreamer.read(filenamePath);

        assertTrue("Number of users read from file was not as expected", actualUserList.equals(expectedUserList));
    }

    @Test
    public void read_NonExistentFile_ExceptionThrown() {
        Path filenamePath = Paths.get("src","test","resources", "nonExistentFile.txt");

        List<User> actualUserList = fileStreamer.read(filenamePath);

        assertTrue("Number of users read from file must be zero", actualUserList.isEmpty());
    }

    private List<User> configureUserList() {
        return Arrays.asList(
            new Customer(12, "Christina McArdle", -6.043701, 52.986375),
            new Customer(1, "Alice Cahill", -10.27699, 51.92893),
            new Customer(2, "Ian McArdle", -10.4240951, 51.8856167),
            new Customer(3, "Jack Enright", -8.5072391, 52.3191841),
            new Customer(28, "Charlie Halligan", -7.714444, 53.807778));
    }
}
