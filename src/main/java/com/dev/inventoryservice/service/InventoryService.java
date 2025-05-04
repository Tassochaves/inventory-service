package com.dev.inventoryservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.dev.inventoryservice.entity.Event;
import com.dev.inventoryservice.entity.Venue;
import com.dev.inventoryservice.repository.EventRepository;
import com.dev.inventoryservice.repository.VenueRepository;
import com.dev.inventoryservice.response.EventInventoryResponse;
import com.dev.inventoryservice.response.VenueInventoryResponse;

@Service
public class InventoryService {

    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;

    public InventoryService(final EventRepository eventRepository, final VenueRepository venueRepository){
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }
    
    public List<EventInventoryResponse> getAllEvents() {
        final List<Event> events = eventRepository.findAll();

        return events.stream().map(event -> EventInventoryResponse.builder()
            .event(event.getName())
            .capacity(event.getLeftCapacity())
            .venue(event.getVenue())
            .build()).collect(Collectors.toList());
    }

    public VenueInventoryResponse  getVenueInformation(Long venueId) {
        final Venue venue = venueRepository.findById(venueId).orElse(null);

        return VenueInventoryResponse.builder()
            .venueId(venue.getId())
            .venueName(venue.getName())
            .totalCapcity(venue.getTotalCapacity())
            .build();
    }

}
