package com.unibuc.javaproject.mapper;

import com.unibuc.javaproject.dto.VenueRequest;
import com.unibuc.javaproject.model.Venue;
import org.springframework.stereotype.Component;

@Component
public class VenueMapper {
    public Venue map(VenueRequest venueRequest){
        Venue venue = new Venue();
        venue.setName(venueRequest.getName());
        venue.setAddress(venueRequest.getAddress());
        venue.setCapacity(venueRequest.getCapacity());
        return venue;
    }
}
