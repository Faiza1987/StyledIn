package com.styledin.styledin.services;

import com.styledin.styledin.models.Stylist;
import com.styledin.styledin.repositories.StylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StylistService {
    @Autowired
    private StylistRepository stylistRepository;

    // Create
    public Stylist createStylist(Stylist stylist){
        return stylistRepository.save(stylist);
    }

    // Read all
    public List<Stylist> getAllStylists(){
        return stylistRepository.findAll();
    }

    // Read one
    public Stylist getStylist(UUID id) {
        return stylistRepository.findById(id).orElse(null);
    }

    // update
    public Stylist updateStylist(Stylist updateStylistRequest) {
        Stylist stylistToUpdate = getStylist(updateStylistRequest.getId());
        if(stylistToUpdate != null) {
            stylistToUpdate.setFirstName(updateStylistRequest.getFirstName());
            stylistToUpdate.setLastName(updateStylistRequest.getLastName());
            stylistToUpdate.setPhoneNumber(updateStylistRequest.getPhoneNumber());
            stylistToUpdate.setEmail(updateStylistRequest.getEmail());
            stylistToUpdate.setSpecialties(updateStylistRequest.getSpecialties());
            stylistToUpdate.setJobsAppliedTo(updateStylistRequest.getJobsAppliedTo());
            stylistToUpdate.setYearsOfExperience(updateStylistRequest.getYearsOfExperience());
            stylistToUpdate.setLicense(updateStylistRequest.getLicense());
            stylistToUpdate.setEmploymentHistory(updateStylistRequest.getEmploymentHistory());
        }
        return stylistToUpdate;
    }

    // delete
    public Stylist deleteStylist(UUID id) {
        Stylist stylistToDelete = getStylist(id);
        stylistRepository.deleteById(id);
        return stylistToDelete;
    }
}
