package org.springframework.samples.petclinic.owner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.db.OwnerRepository;
import org.springframework.samples.petclinic.owner.db.PetRepository;
import org.springframework.samples.petclinic.owner.db.RevenueRepository;
import org.springframework.samples.petclinic.vet.db.VetRepository;
import org.springframework.samples.petclinic.owner.db.VisitRepository;
import org.springframework.samples.petclinic.owner.model.Owner;
import org.springframework.samples.petclinic.owner.model.Pet;
import org.springframework.samples.petclinic.owner.model.PetType;
import org.springframework.samples.petclinic.vet.model.Vet;
import org.springframework.samples.petclinic.owner.model.Visit;
import org.springframework.samples.petclinic.owner.model.YearlyRevenue;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ClinicService {

    private final OwnerRepository owners;
    private final PetRepository pets;
    private final VisitRepository visits;
    private final RevenueRepository revenueRepository;

    @Autowired
    public ClinicService(
        OwnerRepository owners,
        PetRepository pets,
        VisitRepository visits,
        RevenueRepository revenueRepository
    ) {
        this.owners = owners;
        this.pets = pets;
        this.visits = visits;
        this.revenueRepository = revenueRepository;
    }


    public Collection<Owner> ownerByLastName(String lastName) {
        return owners.findByLastName(lastName);
    }

    public Owner ownerById(int i) {
        return owners.findById(i);
    }

    public Pet petById(int id) {
        return pets.findById(id);
    }

    public List<PetType> petTypes() {
        return pets.findPetTypes();
    }

    public List<Visit> visitsByPetId(int petId) {
        return visits.findByPetId(petId);
    }


    public void save(Owner owner) {
        owners.save(owner);
    }

    public void save(Pet pet) {
        pets.save(pet);
    }

    public void save(Visit visit) {
        visits.save(visit);
    }

    public List<YearlyRevenue> listYearlyRevenue() {
        return revenueRepository.listYearlyRevenue();
    }
}
