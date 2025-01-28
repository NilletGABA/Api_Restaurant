package com.gamboa.api_restaurant.service;

import com.gamboa.api_restaurant.domain.entity.Restaurant;
import com.gamboa.api_restaurant.dto.response.RestaurantResponseDTO;
import com.gamboa.api_restaurant.exception.ResourceNotFoundException;
import com.gamboa.api_restaurant.mapper.RestaurantMapper;
import com.gamboa.api_restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;


    public RestaurantService(RestaurantRepository restaurantRepository, RestaurantMapper restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantMapper = restaurantMapper;
    }

    @Transactional(readOnly = true)
    public Page<RestaurantResponseDTO> getAllRestaurants(Pageable pageable){
        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);
        return restaurants.map(restaurantMapper::toResponseDto);
    }
    @Transactional(readOnly = true)
    public Page<RestaurantResponseDTO> getRestaurantByDistrictName(String districtName, Pageable pageable){
        Page<Restaurant> restaurants =restaurantRepository.findByDistrictName(districtName, pageable);
        return restaurants.map(restaurantMapper::toResponseDto);
    }
    public RestaurantResponseDTO getRestaurantById(Long id){
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Restaurant not found with id: "+id));
        return restaurantMapper.toResponseDto(restaurant);
    }
}
