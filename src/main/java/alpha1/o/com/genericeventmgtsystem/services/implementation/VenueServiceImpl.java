package alpha1.o.com.genericeventmgtsystem.services.implementation;

import alpha1.o.com.genericeventmgtsystem.dto.VenueDto;
import alpha1.o.com.genericeventmgtsystem.models.Venue;
import alpha1.o.com.genericeventmgtsystem.repository.AddressRepo;
import alpha1.o.com.genericeventmgtsystem.repository.UserRepository;
import alpha1.o.com.genericeventmgtsystem.repository.VenueRepository;
import alpha1.o.com.genericeventmgtsystem.services.VenueService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VenueRepository venueRepository;

    @Override
    public VenueDto createVenue(VenueDto venueDto, Long userId, Long addressId) {
//        Venue venue = this.modelMapper.map(venueDto, Venue.class);
//        User user = userRepository.findById(userId).orElseThrow(() -> new ApiRequestException("User Not found"));
//        Address address = addressRepo.findById(addressId).orElseThrow(() -> new ApiRequestException("Address Not found"));
//        venue.setAddress(address);
//        venue.setUser(user);
//        Venue newVenue = this.venueRepository.save(venue);
//        return this.modelMapper.map(newVenue, VenueDto.class);
        return null;
    }

    private Venue dtoToVenue(VenueDto venueDto) {
        Venue venue = this.modelMapper.map(venueDto, Venue.class);
        return venue;
    }

    public VenueDto venueToDto(Venue venue) {
        VenueDto venueDto = this.modelMapper.map(venue, VenueDto.class);
        return venueDto;
    }
}
