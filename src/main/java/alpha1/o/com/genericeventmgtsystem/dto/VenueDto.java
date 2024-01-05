package alpha1.o.com.genericeventmgtsystem.dto;

import lombok.Data;

@Data
public class VenueDto {
    private Long venueId;
    private String venueName;
    private Long venueCapacity;
    private UserDto user;
    private AddressDto address;
}
