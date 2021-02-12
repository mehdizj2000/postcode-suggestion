package au.com.jaycar.postcode.data.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import au.com.jaycar.postcode.data.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

    @Query("from Address u where u.postcode like ?1% or u.locality like ?1% ")
    Page<Address> findByPostcodeOrLocality(String search, Pageable pageable);

}
