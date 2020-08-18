package com.intercom.filter;

import com.intercom.user.User;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Interface for filtering {@link User} objects on some criteria
 *
 * @author mtatarnikava
 */
public interface IUserFilter {
    /**
     * Filtering {@link com.intercom.user.User} list based on certain distance from the given center point
     * In the list will remain only those users, that will be not farther than distance, others will be removed
     *
     * @param userList - input user list to be filtered
     * @param centerCoordinatesInDegrees - center point coordinates
     * @param distanceInKm - double value, max allowed distance in km from the center point
     */
    void filterUsersByDistance(List<User> userList, Point2D centerCoordinatesInDegrees, double distanceInKm);
}
