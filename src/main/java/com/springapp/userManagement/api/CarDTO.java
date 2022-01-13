package com.springapp.userManagement.api;

public class CarDTO {
    private long id;
    private String model;
    private String brand;
    private long user_id;


    public CarDTO(long id, String model, String brand, long user_id) {
        this.id = id;
        this.model  = model;
        this.brand  = brand;
        this.user_id = user_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_id="+ id +
                "user_id=" + user_id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

}
