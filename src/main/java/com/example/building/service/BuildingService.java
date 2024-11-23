package com.example.building.service;

import com.example.building.model.Building;
import com.example.building.model.BuildingDTO;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll(String name, Long districtID);
    List<BuildingDTO> findAll(Building building);
}
