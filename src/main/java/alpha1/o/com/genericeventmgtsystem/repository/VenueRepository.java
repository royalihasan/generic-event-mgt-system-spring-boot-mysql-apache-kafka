package alpha1.o.com.genericeventmgtsystem.repository;

import alpha1.o.com.genericeventmgtsystem.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {


}