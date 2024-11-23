package com.example.building.model;

public class Building {
    private String name;
    private String  districtId;
    private String  wardName;
    private String StreetName;
    private Integer numberOfBasment;
    private String direction;
    private Integer level;
    private Float floorAreaLT;
    private Float floorAreaGT;
    private Float rentPriceLT;
    private Float rentPriceGT;
    private String manegerName;
    private String manegerrPhoneNumber;
    private String staffId;

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

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setStreetName(String streetName) {
        StreetName = streetName;
    }

    public Integer getNumberOfBasment() {
        return numberOfBasment;
    }

    public void setNumberOfBasment(Integer numberOfBasment) {
        this.numberOfBasment = numberOfBasment;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Float getFloorAreaLT() {
        return floorAreaLT;
    }

    public void setFloorAreaLT(Float floorAreaLT) {
        this.floorAreaLT = floorAreaLT;
    }

    public Float getFloorAreaGT() {
        return floorAreaGT;
    }

    public void setFloorAreaGT(Float floorAreaGT) {
        this.floorAreaGT = floorAreaGT;
    }

    public Float getRentPriceLT() {
        return rentPriceLT;
    }

    public void setRentPriceLT(Float rentPriceLT) {
        this.rentPriceLT = rentPriceLT;
    }

    public Float getRentPriceGT() {
        return rentPriceGT;
    }

    public void setRentPriceGT(Float rentPriceGT) {
        this.rentPriceGT = rentPriceGT;
    }

    public String getManegerName() {
        return manegerName;
    }

    public void setManegerName(String manegerName) {
        this.manegerName = manegerName;
    }

    public String getManegerrPhoneNumber() {
        return manegerrPhoneNumber;
    }

    public void setManegerrPhoneNumber(String manegerrPhoneNumber) {
        this.manegerrPhoneNumber = manegerrPhoneNumber;
    }
}
