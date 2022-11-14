package repository;

import model.Driver;

import java.util.ArrayList;

/**
 * Repository class for Drivers
 */
public class DriverRepository {

    private  final Integer MAX_DRIVERS = 10;
    private ArrayList<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>(MAX_DRIVERS);
    }


    public String addDriver(Driver driver) {
        drivers.add(driver);
        return driver.getName();
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }


    public Boolean updateDriver(Driver driver) {
        Boolean success = false;
        for (Driver regDriver : drivers) {
            if(regDriver.getName().equals(driver.getName())) {
                regDriver.setStatus("Not Available");
                success = true;
            }
        }
        return success;
    }
}
