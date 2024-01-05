package alpha1.o.com.genericeventmgtsystem.repository;

import alpha1.o.com.genericeventmgtsystem.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
