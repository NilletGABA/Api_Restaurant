package com.gamboa.api_restaurant.service;

import com.gamboa.api_restaurant.domain.entity.District;
import com.gamboa.api_restaurant.dto.response.DistrictResponseDTO;
import com.gamboa.api_restaurant.mapper.DistrictMapper;
import com.gamboa.api_restaurant.repository.DistrictRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    public DistrictService(DistrictRepository districtRepository, DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    //Metodos para listar todos los servicios
    @Transactional(readOnly = true)
    public List<DistrictResponseDTO> getAllDistricts(){
        List<District> districts = districtRepository.findAll();
        return districtMapper.ToResponseDtoList(districts);
    }
}
