package com.example.building.repository.impl;

import com.example.building.model.Building;
import com.example.building.repository.BuildingReponsitory;
import com.example.building.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BuildingRepositoryimpl implements BuildingReponsitory {
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/learn-java";
    static final String DB_USER = "estate-basic-java-sql";
    static final String DB_PASSWORD = "123456";
    @Override
    public List<BuildingEntity> fileAll(String name, Long districtId) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building b WHERE 1=1 ");
        if(name != null && !name.isEmpty()){
            sql.append("and b.name like '%"+name+"%' ");
        }
        if(districtId != null){
            sql.append("and b.districtid="+districtId+ " ");
        }
        List<BuildingEntity> result = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());){
            while(rs.next()){
                BuildingEntity building = new BuildingEntity();
                building.setName(rs.getString("name"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setNumberOfBasement(rs.getString("numberOfBasement"));
                result.add(building);
            }
            System.out.println("Connected to the database successfully");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to connect to the database successfully");
        }
        return result;
    }


    public List<BuildingEntity> fileAll(Building building) {
        boolean floorareaLT=false,floorareaGT=false,rentpriceLT=false,rentpriceGT=false;

        StringBuilder sql = new StringBuilder("SELECT * FROM building b ");
//        sql.append("INNER JOIN building_district d ");
        if(building.getDistrictId()!=null){
            sql.append("INNER JOIN district d ON b.buildingid=d.id ");
        }
        if(building.getStaffId()!=null){
            sql.append("INNER JOIN assignmentBuilding asmb ON b.staffid=asmb.id ");
        }
        sql.append("WHERE 1=1 ");
        if(building.getName() != null && !building.getName().isEmpty()){
            sql.append("and b.name like '%"+building.getName()+"%' ");
        }
        if(building.getNumberOfBasment() != null){
            sql.append("and b.districtid="+building.getDistrictId()+ " ");
        }
        if(building.getDirection() != null && !building.getDirection().isEmpty()){
            sql.append("and b.direction="+building.getDirection()+ " ");
        }
        if(building.getLevel()!=null){
            sql.append("and b.level="+building.getLevel()+ " ");
        }
        if(building.getFloorAreaLT()!=null && building.getFloorAreaLT()>0
                && building.getFloorAreaLT().isNaN()){
            sql.append("and b.floorarea>="+building.getFloorAreaLT()+ " ");
            floorareaLT=true;
        }
        if(building.getFloorAreaGT()!=null && building.getFloorAreaLT()< building.getFloorAreaGT()
            && building.getFloorAreaGT().isNaN()){
            sql.append("and b.floorarea<="+building.getFloorAreaLT()+ " ");
            floorareaGT=true;
        }
        if(building.getRentPriceLT()!=null && building.getRentPriceLT()>0 && building.getRentPriceLT().isNaN()){
            sql.append("and b.rentprice>="+building.getRentPriceLT()+ " ");
            rentpriceLT=true;
        }
        if(building.getRentPriceGT()!=null && building.getRentPriceLT()< building.getRentPriceGT()
                && building.getRentPriceGT().isNaN()){
            sql.append("and b.rentprice<="+building.getRentPriceLT()+ " ");
            rentpriceGT=true;
        }
        if(building.getManegerName()!=null && building.getManegerName().isEmpty()){
            sql.append("and b.manegername="+building.getManegerName()+ " ");
        }
        if(building.getManegerrPhoneNumber()!=null && building.getManegerrPhoneNumber().isEmpty()){
            sql.append("and b.manegerrphone="+building.getManegerrPhoneNumber()+ " ");
        }

        List<BuildingEntity> result = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql.toString());){
            while(rs.next()){
                BuildingEntity buildingEntity = new BuildingEntity();

                if(floorareaLT && floorareaGT && rentpriceLT && rentpriceGT &&
                        rs.getFloat("floorarea")>building.getFloorAreaLT()
                        && rs.getFloat("floorarea")<building.getFloorAreaGT()
                        &&rs.getFloat("rentprice")>building.getRentPriceLT()
                        && rs.getFloat("rentprice")<building.getRentPriceGT()){
                    buildingEntity.setName(rs.getString("name"));
                    buildingEntity.setStreet(rs.getString("street"));
                    buildingEntity.setWard(rs.getString("ward"));
                    buildingEntity.setDistrict(rs.getString("district"));
                    buildingEntity.setNumberOfBasement(rs.getString("numberofbasement"));
                    buildingEntity.setManagerName(rs.getString("managername"));
                    buildingEntity.setManagerPhoneNumber(rs.getString("managerphonenumber"));
                    buildingEntity.setFloorArea(rs.getFloat("floorarea"));
                    buildingEntity.setRentPrice(rs.getFloat("rentprice"));
                    buildingEntity.setBrokerAgeFee(rs.getFloat("brokeragefee"));
                } else if (floorareaLT && floorareaGT && rentpriceLT &&
                        rs.getFloat("floorarea")>building.getFloorAreaLT()
                        && rs.getFloat("floorarea")<building.getFloorAreaGT()
                        &&rs.getFloat("rentprice")>building.getRentPriceLT() ){
                    buildingEntity.setName(rs.getString("name"));
                    buildingEntity.setStreet(rs.getString("street"));
                    buildingEntity.setWard(rs.getString("ward"));
                    buildingEntity.setDistrict(rs.getString("district"));
                    buildingEntity.setNumberOfBasement(rs.getString("numberofbasement"));
                    buildingEntity.setManagerName(rs.getString("managername"));
                    buildingEntity.setManagerPhoneNumber(rs.getString("managerphonenumber"));
                    buildingEntity.setFloorArea(rs.getFloat("floorarea"));
                    buildingEntity.setRentPrice(rs.getFloat("rentprice"));
                    buildingEntity.setBrokerAgeFee(rs.getFloat("brokeragefee"));
                }else if(floorareaLT && floorareaGT && rs.getFloat("floorarea")>building.getFloorAreaLT()
                        && rs.getFloat("floorarea")<building.getFloorAreaGT()){
                    buildingEntity.setName(rs.getString("name"));
                    buildingEntity.setStreet(rs.getString("street"));
                    buildingEntity.setWard(rs.getString("ward"));
                    buildingEntity.setDistrict(rs.getString("district"));
                    buildingEntity.setNumberOfBasement(rs.getString("numberofbasement"));
                    buildingEntity.setManagerName(rs.getString("managername"));
                    buildingEntity.setManagerPhoneNumber(rs.getString("managerphonenumber"));
                    buildingEntity.setFloorArea(rs.getFloat("floorarea"));
                    buildingEntity.setRentPrice(rs.getFloat("rentprice"));
                    buildingEntity.setBrokerAgeFee(rs.getFloat("brokeragefee"));
                }else if(floorareaLT && rs.getFloat("floorarea")>building.getFloorAreaLT() ){
                    buildingEntity.setName(rs.getString("name"));
                    buildingEntity.setStreet(rs.getString("street"));
                    buildingEntity.setWard(rs.getString("ward"));
                    buildingEntity.setDistrict(rs.getString("district"));
                    buildingEntity.setNumberOfBasement(rs.getString("numberofbasement"));
                    buildingEntity.setManagerName(rs.getString("managername"));
                    buildingEntity.setManagerPhoneNumber(rs.getString("managerphonenumber"));
                    buildingEntity.setFloorArea(rs.getFloat("floorarea"));
                    buildingEntity.setRentPrice(rs.getFloat("rentprice"));
                    buildingEntity.setBrokerAgeFee(rs.getFloat("brokeragefee"));
                }
                result.add(buildingEntity);
            }
            System.out.println("Connected to the database successfully");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to connect to the database successfully");
        }
        return result;
    }
}
