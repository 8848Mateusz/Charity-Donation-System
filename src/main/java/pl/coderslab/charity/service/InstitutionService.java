package pl.coderslab.charity.service;

import pl.coderslab.charity.domain.Institution;
import java.util.List;

public interface InstitutionService {

    List<Institution> getAllInstitutions();

    List<Institution> getInstitutionsPageable(int size);



}
