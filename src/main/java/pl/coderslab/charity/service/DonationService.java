package pl.coderslab.charity.service;


import pl.coderslab.charity.domain.Donation;

public interface DonationService {

    Long getTotalQuantity();

    Long getAllDonationsCount();

    Donation save(Donation donation);
}
