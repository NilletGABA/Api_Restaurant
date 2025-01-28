package com.gamboa.api_restaurant.controller;


import com.gamboa.api_restaurant.dto.response.DistrictResponseDTO;
import com.gamboa.api_restaurant.service.DistrictService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    private final DistrictService districtService;


    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    public ResponseEntity<List<DistrictResponseDTO>> getAllDistricts(){
        List<DistrictResponseDTO> districts= districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }


}
