package com.gamboa.api_restaurant.mapper;

import com.gamboa.api_restaurant.domain.entity.District;
import com.gamboa.api_restaurant.dto.response.DistrictResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DistrictMapper {

    private final ModelMapper modelMapper;

    public DistrictMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DistrictResponseDTO toResponseDto(District district){
        return modelMapper.map(district,DistrictResponseDTO.class);
    }
    public List<DistrictResponseDTO> ToResponseDtoList(List<District> districts){
        return districts.stream()
                .map(this::toResponseDto)
                .toList();
    }
}
