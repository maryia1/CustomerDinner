package com.intercom.filter;

import com.intercom.calculatorUtils.DistanceCalculator;
import com.intercom.user.User;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * Class implementing {@link IUserFilter} interface for filtering {@link User} object list based on some criteria
 *
 * @author mtatarnikava
 */
public class UserFilter implements IUserFilter {
    @Override
    public void filterUsersByDistance(List<User> userList, Point2D centerCoordinatesInDegrees, double distanceInKm) {
        userList.removeIf(user -> DistanceCalculator.getDistanceInKm(new Point2D.Double(user.getLongitude(),
                user.getLatitude()), centerCoordinatesInDegrees) >  distanceInKm);
    }
}
