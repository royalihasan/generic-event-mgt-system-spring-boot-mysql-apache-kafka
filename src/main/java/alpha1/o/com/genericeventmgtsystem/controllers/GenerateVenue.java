package alpha1.o.com.genericeventmgtsystem.controllers;

import alpha1.o.com.genericeventmgtsystem.common.Routes;
import alpha1.o.com.genericeventmgtsystem.dto.VenueDto;
import alpha1.o.com.genericeventmgtsystem.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Routes.V1_BASE_PATH)
public class GenerateVenue {
    @Autowired
    private VenueService venueService;

    @PostMapping("/user/{userId}/address/{addressId}/venue")
    public ResponseEntity<VenueDto> createVenue(@Validated @RequestBody VenueDto venueDto,
                                                @PathVariable Long userId,
                                                @PathVariable Long addressId
    ) {
        VenueDto createVenueDto = this.venueService.createVenue(venueDto, userId, addressId);
        return (new ResponseEntity<VenueDto>(createVenueDto, HttpStatus.CREATED));
    }
}
