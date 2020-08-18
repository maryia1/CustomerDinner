package com.intercom.filter;

import com.intercom.user.Customer;
import com.intercom.user.User;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit test for {@link UserFilter}
 *
 * @author mtatarnikava
 */
public class UserFilterTest {
    private static final Point2D DUBLIN_COORDINATES = new Point2D.Double(53.339428, -6.257664);
    private static final double MAX_DISTANCE_IN_KM = 100;

    private static final UserFilter userFilter = new UserFilter();

    @Test
    public void filterUsersByDistance_NonEmptyUserList_Success() {
        List<User> actualUserList = configureUserList();

        userFilter.filterUsersByDistance(actualUserList, DUBLIN_COORDINATES, MAX_DISTANCE_IN_KM);

        assertThat("User list after filtering was not as expected", actualUserList, is(expectedFilteredUserList()));
    }

    @Test
    public void filterUsersByDistance_EmptyUserList_Success() {
        List<User> actualUserList = new ArrayList<>();

        userFilter.filterUsersByDistance(actualUserList, DUBLIN_COORDINATES, MAX_DISTANCE_IN_KM);

        assertThat("User list after filtering must be empty", actualUserList, is(new ArrayList<>()));
    }

    private List<User> configureUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new Customer(12, "Christina McArdle", -6.043701, 52.986375));
        userList.add(new Customer(1, "Alice Cahill", 53.329328, -6.235564));
        userList.add(new Customer(2, "Ian McArdle", -10.4240951, 51.8856167));
        userList.add(new Customer(3, "Jack Enright", 53.338428, -6.227654));
        userList.add(new Customer(28, "Charlie Halligan", 53.328528, -6.227654));

        return userList;
    }

    private List<User> expectedFilteredUserList() {
        List<User> userList = new ArrayList<>();
        userList.add(new Customer(1, "Alice Cahill", 53.329328, -6.235564));
        userList.add(new Customer(3, "Jack Enright", 53.338428, -6.227654));
        userList.add(new Customer(28, "Charlie Halligan", 53.328528, -6.227654));

        return userList;
    }
}
