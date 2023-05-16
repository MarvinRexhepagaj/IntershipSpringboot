package com.internship.service.impl;

import com.internship.mapper.FlightMapper;
import com.internship.model.dto.FlightDTO;
import com.internship.model.entity.Flight;
import com.internship.repository.FlightRepository;
import com.internship.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FlightsServiceImpl implements FlightService {


    private FlightRepository flightRepository;

    public FlightsServiceImpl(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public List<FlightDTO> loadAll() {
        List<Flight> flights = flightRepository.findAll();
        return FlightMapper.mapToFlightDTOList(flights);
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);

        return FlightMapper.mapToFlightDTO(flightOptional.get());
    }



}
