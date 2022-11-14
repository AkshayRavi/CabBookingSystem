package demo;

import model.Driver;
import model.User;
import repository.DriverRepository;
import repository.UserRepository;
import service.Booking;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DemoDriver {

    public static void sampleTest() {
        User user1 = new User("Akshay", "Male", 24);
        User user2 = new User("Ram", "Male", 24);
        User user3 = new User("Karan", "Male", 24);


        UserRepository userRepo = new UserRepository();

        userRepo.addUser(user1);
        userRepo.addUser(user2);
        userRepo.addUser(user3);

        Driver driver1 = new Driver("D1", "Male", 30, "KIA",15,3);
        Driver driver2 = new Driver("D2", "Male", 40, "ALTO",11,10);
        Driver driver3 = new Driver("D3", "Male", 50, "DEZIRE",5,3);

        DriverRepository driverRepo = new DriverRepository();

        driverRepo.addDriver(driver1);
        driverRepo.addDriver(driver2);
        driverRepo.addDriver(driver3);


        Booking booking = new Booking(userRepo,driverRepo);

        List<Driver> nearbyDriver = booking.findRide("Akshay",15,6,15,10);

        if(Objects.nonNull(nearbyDriver)) {
            for (Driver driver: nearbyDriver
            ) {
                System.out.println(driver.getName());
            }
        }
        Boolean bookSuccess = booking.bookRide(user1, nearbyDriver.get(0));
        Boolean endRide =  booking.endRide(user1);

        System.out.println(bookSuccess + " ---- " + endRide);
    }


    public static void main(String [] args) {
        sampleTest();


    }
}
