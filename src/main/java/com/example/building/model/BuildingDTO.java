package com.example.building.model;

import java.util.List;

public class BuildingDTO {
    private String name;
    private String address;
    private String numberOfBasement;
    private String managerName;
    private String managerPhoneNumber;
    private Float floorArea;
    private Float rentPrice;
    private Float brokerAgeFee;
    private String staffId;


    public Float getBrokerAgeFee() {
        return brokerAgeFee;
    }

    public void setBrokerAgeFee(Float brokerAgeFee) {
        this.brokerAgeFee = brokerAgeFee;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public Float getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Float floorArea) {
        this.floorArea = floorArea;
    }

    public Float getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Float rentPrice) {
        this.rentPrice = rentPrice;
    }
}
