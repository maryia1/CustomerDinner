package com.intercom.main;

import com.intercom.filter.IUserFilter;
import com.intercom.filter.UserFilter;
import com.intercom.streamer.FileStreamer;
import com.intercom.streamer.IStreamer;
import com.intercom.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.geom.Point2D;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Main application class
 *
 * @author mtatarnikava
 */
public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    private static final Point2D DUBLIN_COORDINATES = new Point2D.Double(53.339428, -6.257664);
    private static final double MAX_DISTANCE_IN_KM = 100;

    private static final String CURRENT_DIR = Paths.get(".").toAbsolutePath().toString();
    private static final String INPUT_FILENAME = "input.txt";
    private static final String OUTPUT_FILENAME = "output.txt";

    private static final IStreamer fileStreamer = new FileStreamer();
    private static final IUserFilter userFilter = new UserFilter();

    public static void main(String[] args){
        String inputFilename;
        if(args.length > 0)
            inputFilename = args[0];
        else
            inputFilename = INPUT_FILENAME;
        Path inputFilenamePath = Paths.get(CURRENT_DIR, inputFilename);
        log.debug("Input user list filename path: " + inputFilenamePath.toString());

        List<User> inputCustomerList = fileStreamer.read(inputFilenamePath.toAbsolutePath());
        log.debug("Reading from " + inputFilenamePath + " was successful.");

        userFilter.filterUsersByDistance(inputCustomerList, DUBLIN_COORDINATES, MAX_DISTANCE_IN_KM);
        log.debug("User list was filtered successfully.");

        Collections.sort(inputCustomerList);

        Path outputFilenamePath = Paths.get(CURRENT_DIR, OUTPUT_FILENAME);
        log.debug("User list was sorted, starting writing to " + outputFilenamePath);
        fileStreamer.write(inputCustomerList, outputFilenamePath);
        log.debug("Completed successfully, please check " + outputFilenamePath);
    }
}
