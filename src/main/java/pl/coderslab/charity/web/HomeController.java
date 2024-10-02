package pl.coderslab.charity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private DonationService donationService;


    @GetMapping ("/")
    public String homeAction(Model model){

        int size = 7; // <----- liczba elementów, które będa wyświetlane na stronie
        List<Institution> institutions = institutionService.getInstitutionsPageable(size);
        model.addAttribute("institutions", institutions);

        Long donationsQuantityValue = donationService.getTotalQuantity();
        model.addAttribute("donationsQuantityValue", donationsQuantityValue);


        Long sumAllDotations = donationService.getAllDonationsCount();
        model.addAttribute("sumAllDotations", sumAllDotations);

        return "index";
    }
}
