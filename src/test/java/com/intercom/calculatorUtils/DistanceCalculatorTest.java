package com.intercom.calculatorUtils;

import org.junit.Test;

import java.awt.geom.Point2D;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for {@link DistanceCalculator}
 *
 * @author mtatarnikava
 */
public class DistanceCalculatorTest {
    @Test
    public void getDistanceInKm_Success() {
        double expectedDistance = 1.346789140021012;
        Point2D point1 = new Point2D.Double(53.339428, -6.257664);
        Point2D point2 = new Point2D.Double(53.327428, -6.255564);

        double actualDistance = DistanceCalculator.getDistanceInKm(point1, point2);

        assertThat("Distance between two points was calculated incorrectly", actualDistance, is(expectedDistance));
    }
}
