package com.gamboa.api_restaurant.controller;

import com.gamboa.api_restaurant.domain.entity.Restaurant;
import com.gamboa.api_restaurant.dto.response.RestaurantResponseDTO;
import com.gamboa.api_restaurant.repository.RestaurantRepository;
import com.gamboa.api_restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {


    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    //Devolvera la pagina de todos los restaurantes
    @GetMapping("/page")
    public ResponseEntity<Page<RestaurantResponseDTO>> getAllRestaurans(
            @PageableDefault(size = 5) Pageable pageable){
        Page<RestaurantResponseDTO> restauranst = restaurantService.getAllRestaurants(pageable);
        return ResponseEntity.ok(restauranst);
    }
    //Retorna los resturante por distrito
    @GetMapping("/page/district")
    public ResponseEntity<Page<RestaurantResponseDTO>> findByDistrictName(
            @RequestParam String districtName,
            @PageableDefault(sort = "name",size = 5)Pageable pageable){
        Page<RestaurantResponseDTO> restaurants = restaurantService.getRestaurantByDistrictName(districtName, pageable);
        return ResponseEntity.ok(restaurants);
    }
    //Retorna la informacion del restaurant por id
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> getRestaurantById(@PathVariable Long id){
        RestaurantResponseDTO restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }
}
