package com.gamboa.api_restaurant.mapper;

import com.gamboa.api_restaurant.domain.entity.Restaurant;
import com.gamboa.api_restaurant.dto.response.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantMapper {
    private final ModelMapper modelMapper;

    public RestaurantMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RestaurantResponseDTO toResponseDto(Restaurant restaurant){
        return modelMapper.map(restaurant, RestaurantResponseDTO.class);
    }
    public List<RestaurantResponseDTO> toResponseDtoList(List<Restaurant> restaurants){
        return restaurants.stream()
        .map(this::toResponseDto)
        .toList();
    }
}
