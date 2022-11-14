package repository;

import model.User;

import java.util.ArrayList;

/**
 * Repository class for Users
 */
public class UserRepository {

    private  final Integer MAX_USERS = 10;
    private ArrayList<User> users;

    public UserRepository() {
        this.users = new ArrayList<>(MAX_USERS);
    }

    public String addUser(User user) {
        users.add(user);
        return user.getName();
    }

    public Boolean updateUser(User user, String driverName) {

        Boolean success = false;
        for (User regUser: this.users) {
            if(regUser.getName().equals(user.getName())) {
                regUser.setAssignedDriver(driverName);
                success = true;
            }
        }
        return success;
    }

    public Boolean removeDriver(User user) {
        Boolean success = false;
        for (User regUser: this.users) {
            if (regUser.getName().equals(user.getName())) {
                regUser.setAssignedDriver(null);
                success = true;
            }
        }
        return success;
    }


}
