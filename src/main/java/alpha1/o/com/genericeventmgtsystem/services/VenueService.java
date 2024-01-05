package alpha1.o.com.genericeventmgtsystem.services;

import alpha1.o.com.genericeventmgtsystem.dto.VenueDto;
import alpha1.o.com.genericeventmgtsystem.models.Venue;

public interface VenueService {
    VenueDto createVenue(VenueDto venueDto, Long userId, Long addressId);
}
