package com.example.mehed.heterogeneousrecyclerview.models;

public class Car {

    private int carImage;
    private String carName;
    private String companyName;

    public Car(String carName, String companyName, int carImage) {
        this.carName = carName;
        this.companyName = companyName;
        this.carImage = carImage;
    }

    public int getCarImage() {
        return carImage;
    }

    public String getName() {
        return carName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
