package busDriverManagement;

import driver.Driver;
import route.Route;

public class BusDriverManagement {

    private Driver driver;

    private Route route;

    public BusDriverManagement(Driver driver, Route route) {
        this.driver = driver;
        this.route = route;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "BusDriverManagement{" +
                "driver=" + driver +
                ", route=" + route +
                '}';
    }


}
