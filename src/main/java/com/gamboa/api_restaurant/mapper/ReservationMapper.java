package com.gamboa.api_restaurant.mapper;


import com.gamboa.api_restaurant.domain.entity.Reservation;
import com.gamboa.api_restaurant.domain.entity.User;
import com.gamboa.api_restaurant.dto.request.ReservationRequestDTO;
import com.gamboa.api_restaurant.dto.request.SignupRequestDTO;
import com.gamboa.api_restaurant.dto.response.AuthResponseDTO;
import com.gamboa.api_restaurant.dto.response.ReservationResponseDTO;
import com.gamboa.api_restaurant.dto.response.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationMapper {

    private final ModelMapper modelMapper;

    public Reservation toEntity(ReservationRequestDTO reservationRequestDTO) {
        return modelMapper.map(reservationRequestDTO, Reservation.class);
    }

    public ReservationResponseDTO toResponseDto(Reservation reservation) {
        return modelMapper.map(reservation, ReservationResponseDTO.class);
    }


    public List<ReservationResponseDTO> toResponseDtoList(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::toResponseDto)
                .toList();
    }
}
