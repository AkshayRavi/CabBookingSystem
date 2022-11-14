package model;

import java.util.Map;

/**
 * Model class for Driver
 */
public class Driver {

    private String name;
    private String gender;
    private Integer age;
    private String carModel;
    private Integer xCoordinate;
    private Integer yCoordinate;

    private String status;

    public Driver(String name, String gender, Integer age, String carModel, Integer xCoordinate, Integer yCoordinate) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.carModel = carModel;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.status = "Available";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
