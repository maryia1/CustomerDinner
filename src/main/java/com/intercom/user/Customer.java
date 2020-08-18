package com.intercom.user;

/**
 * Customer is the main entity we'll be using for reading and manipulating with, used when parsing json.
 *
 * Please see the {@link User} class for the base entity
 * @author mtatarnikava
 */
public class Customer extends User implements Comparable {
    private int userId;
    private String name;

    public Customer(int userId, String name, double longitude, double latitude) {
        super(longitude, latitude);
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) obj;
        if(this.getUserId() == customer.getUserId()
                && this.getName().equals(customer.getName())
                && this.getLongitude() == customer.getLongitude()
                && this.getLatitude() == customer.getLatitude())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Id = " + this.getUserId() + ", Name = " + this.getName();
    }

    @Override
    public int compareTo(Object o) {
        return  (Integer.compare(this.getUserId(), ((Customer) o).getUserId()));
    }
}
