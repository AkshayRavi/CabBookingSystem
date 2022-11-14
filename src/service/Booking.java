package service;

import model.Driver;
import model.User;
import repository.DriverRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Booking {

    private UserRepository userRepo;
    private DriverRepository driverRepo;

    public Booking(UserRepository userRepo, DriverRepository driverRepo) {
        this.userRepo = userRepo;
        this.driverRepo = driverRepo;
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public DriverRepository getDriverRepo() {
        return driverRepo;
    }

    public void setDriverRepo(DriverRepository driverRepo) {
        this.driverRepo = driverRepo;
    }


    /**
     *
     * Method to find the nearby drivers - Used the following stackoverflow answer to find the formula - https://stackoverflow.com/a/33245284
     *
     * @param name
     * @param sourceX
     * @param sourceY
     * @param destinationX
     * @param destinationY
     * @return List of Available Drivers
     */
    public List<Driver> findRide(String name, Integer sourceX, Integer sourceY, Integer destinationX, Integer destinationY) {

        List<Driver> nearbyAvailableDrivers = null;

        for (Driver driver: this.driverRepo.getDrivers()) {
            Integer distance = Math.abs(driver.getxCoordinate() - sourceX) + Math.abs(driver.getyCoordinate() - sourceY);

            System.out.println(distance);
            if(distance <= 5 && driver.getStatus().equals("Available")) {

                if(Objects.isNull(nearbyAvailableDrivers)) {
                    nearbyAvailableDrivers = new ArrayList<>();
                }
                nearbyAvailableDrivers.add(driver);
            }
        }

        return nearbyAvailableDrivers;
    }

    public Boolean bookRide(User user, Driver driver) {

        Boolean flag1 = this.userRepo.updateUser(user,driver.getName());
        Boolean flag2 = this.driverRepo.updateDriver(driver);

        return flag1 && flag2;
    }
    public Boolean endRide(User user) {
        Boolean success = this.userRepo.removeDriver(user);
        return success;
    }
}
