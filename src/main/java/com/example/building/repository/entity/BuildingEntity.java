package com.example.building.repository.entity;

public class BuildingEntity {
    private String name;
    private String numberOfBasement;
    private String ward;
    private String street;
    private String district;
    private String managerName;
    private String managerPhoneNumber;
    private Float brokerAgeFee;
    private Float floorArea;
    private Float rentPrice;
    private String staffId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Float getBrokerAgeFee() {
        return brokerAgeFee;
    }

    public void setBrokerAgeFee(Float brokerAgeFee) {
        this.brokerAgeFee = brokerAgeFee;
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
