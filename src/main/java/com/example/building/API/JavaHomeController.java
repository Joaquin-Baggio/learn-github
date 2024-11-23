package com.example.building.API;

import com.example.building.model.Building;
import com.example.building.model.BuildingDTO;
import com.example.building.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JavaHomeController {
    @Autowired
    private BuildingService buildingServices;
    @GetMapping(value = "/api/building")
    public List<BuildingDTO> getBuildings(@RequestBody Building building) {
        System.out.println("oke");
        List<BuildingDTO>  result = buildingServices.findAll(building);
        return result;
    }
}
