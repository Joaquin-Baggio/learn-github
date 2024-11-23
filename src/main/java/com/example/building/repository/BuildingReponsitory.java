package com.example.building.repository;

import com.example.building.model.Building;
import com.example.building.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingReponsitory {
    List<BuildingEntity> fileAll(String name, Long districtId);

    List<BuildingEntity> fileAll(Building building);
}
