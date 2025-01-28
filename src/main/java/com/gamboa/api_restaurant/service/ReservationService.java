package com.gamboa.api_restaurant.service;


import com.gamboa.api_restaurant.domain.entity.Reservation;
import com.gamboa.api_restaurant.domain.entity.Restaurant;
import com.gamboa.api_restaurant.domain.entity.User;
import com.gamboa.api_restaurant.domain.enums.ReservationStatus;
import com.gamboa.api_restaurant.dto.request.ReservationRequestDTO;
import com.gamboa.api_restaurant.dto.response.ReservationResponseDTO;
import com.gamboa.api_restaurant.exception.ResourceNotFoundException;
import com.gamboa.api_restaurant.mapper.ReservationMapper;
import com.gamboa.api_restaurant.repository.ReservationRepository;
import com.gamboa.api_restaurant.repository.RestaurantRepository;
import com.gamboa.api_restaurant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

  private final ReservationRepository reservationRepository;
  private final RestaurantRepository restaurantRepository;
  private final UserRepository userRepository;
  private final ReservationMapper reservationMapper;

  @Transactional
  public ReservationResponseDTO createReservation(ReservationRequestDTO reservationRequestDTO) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    User user = userRepository.findOneByEmail(authentication.getName())
        .orElseThrow(ResourceNotFoundException::new);

    Restaurant restaurant = restaurantRepository.findById(reservationRequestDTO.getRestaurantId())
      .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

    Reservation reservation = reservationMapper.toEntity(reservationRequestDTO);
    reservation.setRestaurant(restaurant);
    reservation.setClient(user);
    reservation.setStatus(ReservationStatus.PENDING);
    reservation.calculateTotalAmount();

    reservation = reservationRepository.save(reservation);

    return reservationMapper.toResponseDto(reservation);
  }

  @Transactional(readOnly = true)
  public List<ReservationResponseDTO> getReservationsByClientId() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    User user = userRepository.findOneByEmail(authentication.getName())
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));

    List<Reservation> reservations = reservationRepository.findByClientId(user.getId());
    return reservationMapper.toResponseDtoList(reservations);
  }

  @Transactional(readOnly = true)
  public ReservationResponseDTO getReservationById(Long reservationId) {
    Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new ResourceNotFoundException("Reservation not found"));

    return reservationMapper.toResponseDto(reservation);
  }


  @Transactional
  public Reservation confirmReservationPayment(Long reservationId) {
    Reservation reservation = reservationRepository
            .findById(reservationId)
            .orElseThrow(ResourceNotFoundException::new);

    reservation.setStatus(ReservationStatus.PAID);
    return reservationRepository.save(reservation);
  }



}
