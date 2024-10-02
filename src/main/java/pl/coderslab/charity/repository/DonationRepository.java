package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.domain.Donation;

import java.util.Optional;
import java.util.OptionalLong;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT SUM (p.quantity) FROM Donation p")
    Optional <Long> sumQuantity();


}
