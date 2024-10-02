package pl.coderslab.charity.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    
    @Autowired
    private InstitutionRepository institutionRepository;


    @Override
    public List<Institution> getAllInstitutions() {
        return institutionRepository.findAll();
    }

    @Override
    public List<Institution> getInstitutionsPageable(int size) {
        return institutionRepository.findAll(PageRequest.of(0, size)).getContent();
    }


}
