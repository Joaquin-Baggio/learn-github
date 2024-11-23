package com.example.building.service.impl;

import com.example.building.model.Building;
import com.example.building.model.BuildingDTO;
import com.example.building.repository.BuildingReponsitory;
import com.example.building.repository.entity.BuildingEntity;
import com.example.building.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingServiceimpl implements BuildingService {
    @Autowired
    private BuildingReponsitory buildingReponsitory;
    @Override
    public List<BuildingDTO> findAll(String name, Long districtId) {
        List<BuildingEntity> buildingEntities = buildingReponsitory.fileAll(name,districtId);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO building = new BuildingDTO();
            building.setName(item.getName());
            building.setAddress(item.getStreet()+","+item.getWard());
            building.setNumberOfBasement(item.getNumberOfBasement());
            result.add(building);
        }
        return result;
    }

    @Override
    public List<BuildingDTO> findAll(Building building) {
        List<BuildingEntity> buildingEntities = buildingReponsitory.fileAll(building);
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEntities) {
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setName(item.getName());
            buildingDTO.setAddress(item.getStreet()+","+item.getWard()+","+item.getDistrict());
            buildingDTO.setNumberOfBasement(item.getNumberOfBasement());
            buildingDTO.setFloorArea(item.getFloorArea());
            buildingDTO.setManagerName(item.getManagerName());
            buildingDTO.setManagerPhoneNumber(item.getManagerPhoneNumber());
            buildingDTO.setRentPrice(item.getRentPrice());
            buildingDTO.setFloorArea(item.getFloorArea());
            buildingDTO.setBrokerAgeFee(item.getBrokerAgeFee());
            result.add(buildingDTO);
        }
        return result;
    }
}
