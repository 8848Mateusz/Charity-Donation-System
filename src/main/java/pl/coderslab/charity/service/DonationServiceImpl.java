package pl.coderslab.charity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationServiceImpl implements DonationService {


    private  final DonationRepository donationRepository;

    @Autowired
    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }


    @Override
    public Long getTotalQuantity() {
        return donationRepository.sumQuantity().orElse(0L);
    }

    @Override
    public Long getAllDonationsCount() {
        return donationRepository.count();
    }

    @Override
    public Donation save(Donation donation) {
        donation.setPickUpDate(donation.getPickUpDate());
        donation.setPickUpTime(donation.getPickUpTime());
        donation.setQuantity(donation.getQuantity());
        donation.setCategories(donation.getCategories());
        donation.setInstitution(donation.getInstitution());
        donation.setCity(donation.getCity());
        donation.setPickUpComment(donation.getPickUpComment());
        donation.setStreet(donation.getStreet());
        donation.setZipCode(donation.getZipCode());
        donation.setPhoneNumber(donation.getPhoneNumber());
        donationRepository.save(donation);
        return donation;
    }


}
