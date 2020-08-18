package com.intercom.calculatorUtils;

import com.intercom.user.User;

import java.awt.geom.Point2D;

/**
 * Util class for calculating distance between points
 * Used in {@link com.intercom.filter.UserFilter}
 *
 * @author mtatarnikava
 */
public class DistanceCalculator {
    private static final double EARTH_RADIUS_IN_KM = 6371.0;
    private static final double HALF_CIRCLE_DEGREES = 180.0;

    /**
     * Static method for calculating distance between two points, each of them has longitude, latitude
     * Used {@link com.intercom.filter.UserFilter} for filtering {@link User}
     * @param point1 - first point coordinates
     * @param point2 - second point coordinates
     * @return double value - distance in km
     */
    public static double getDistanceInKm(Point2D point1, Point2D point2) {
        double deltaLambda = deg2rad(point1.getX() - point2.getX());
        double fi1 = deg2rad(point1.getY());
        double fi2 = deg2rad(point2.getY());

        double deltaSigma = Math.acos(Math.sin(fi1)*Math.sin(fi2) + Math.cos(fi1)*Math.cos(fi2)*Math.cos(deltaLambda));

        return EARTH_RADIUS_IN_KM * deltaSigma;
    }

    /**
     * Converts degrees to radians
     * @param deg - degrees to be converted
     * @return radian converted double value
     */
    private static double deg2rad(double deg) {
        return (deg * Math.PI / HALF_CIRCLE_DEGREES);
    }
}
