package pl.coderslab.charity.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Positive *ciekawostka*
    @NotNull
    @Min(value = 1, message = "Liczba worków musi być co najmniej 1.")
    private Integer quantity;   //liczba worków

    @NotNull
    @Pattern(regexp = "\\d{9}", message = "Numer telefonu musi składać się z 9 cyfr.")
    private String phoneNumber;

    @NotEmpty(message = "Musisz wybrać co najmniej jedną kategorię.")
    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @NotNull(message = "Musisz wybrać organizację.")
    @ManyToOne
    private Institution institution;

    @NotBlank(message = "Ulica nie może być pusta.")
    private String street;

    @NotBlank(message = "Miasto nie może być puste.")
    private String city;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Podaj kod pocztowy w formacie 00-000.")
    private  String zipCode;

    @NotNull(message = "Musisz podać datę odbioru.")
    @Future(message = "Data odbioru nie może być z przeszłości.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull(message = "Musisz podać godzinę odbioru.")
    private LocalTime pickUpTime;

    //@Max()
    private String pickUpComment;

    public Donation() {
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
