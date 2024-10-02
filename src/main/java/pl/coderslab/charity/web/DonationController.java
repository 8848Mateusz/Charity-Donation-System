package pl.coderslab.charity.web;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DonationController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    InstitutionRepository institutionRepository;

    @Autowired
    DonationService donationService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private InstitutionService institutionService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.getAllInstitutions();
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.getAllCategoryName();
    }

    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @GetMapping("formConfirmation")
    public String formConfirmation() {
        return "formConfirmation";
    }

    @PostMapping("form")
    public String saveForm(@Valid @ModelAttribute("donation") Donation donation,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }


//        List<Category> categories = new ArrayList<>();
//        String[] selectedCategories = request.getParameterValues("categories");
//        if (selectedCategories != null) {
//            for (String categoryName : selectedCategories) {
//                Long categoryId = Long.valueOf(categoryName);
//                Category category = categoryRepository.findById(categoryId)
//                        .orElseThrow(() -> new EntityNotFoundException("Nie znaleziono kategorii o ID:" + categoryId));
//                categories.add(category);
//            }
//        }
//        donation.setCategories(categories);


        donationService.save(donation);
        return "formConfirmation";
    }

}
