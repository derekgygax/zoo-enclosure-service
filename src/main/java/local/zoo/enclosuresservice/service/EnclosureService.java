package local.zoo.enclosuresservice.service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import local.zoo.enclosuresservice.dto.EnclosureBase;
import local.zoo.enclosuresservice.model.Enclosure;
import local.zoo.enclosuresservice.model.EnclosureType;
import local.zoo.enclosuresservice.repository.EnclosureRepository;

@ApplicationScoped
public class EnclosureService {

    @Inject
    EnclosureRepository enclosureRepository;
    @Inject
    EnclosureTypeService enclosureTypeService;

    // Get the Enclosure by ID from the DB
    public Enclosure getEnclosureById(UUID enclosureId) {
        Enclosure enclosure = this.enclosureRepository.findById(enclosureId);
        if (enclosure == null) {
            throw new EntityNotFoundException("Enclosure not found with ID: " + enclosureId);
        }
        return enclosure;
    }

    public List<Enclosure> getAllEnclosures() {
        return this.enclosureRepository.listAll();
    }

    @Transactional
    public void addEnclosure(EnclosureBase enclosureBase) {

        // Get the actual enclosure type based on the enclosureBase type
        // this was a string passed in
        // This function does a check it exists and throws an error
        EnclosureType enclosureType = this.enclosureTypeService
                .getEnclosureTypeById(enclosureBase.enclosureTypeId());

        Enclosure enclosure = new Enclosure(
                enclosureType,
                enclosureBase.name(),
                enclosureBase.capacity(),
                enclosureBase.status());

        this.enclosureRepository.persist(enclosure);
    }

    @Transactional
    public void updateEnclosure(UUID enclosureId, EnclosureBase updatedEnclosureBase) {

        // Get the enclosure type
        // Uses the "key" string in EnclosureBase
        EnclosureType updatedEnclosureType = this.enclosureTypeService
                .getEnclosureTypeById(updatedEnclosureBase.enclosureTypeId());

        // Get the existing Enclosure by id
        Enclosure existingEnclosure = getEnclosureById(enclosureId);

        // Update the fields in the database
        // you can directly use the updatedEnclosureBase
        // for everything but the type
        existingEnclosure.setName(updatedEnclosureBase.name());
        existingEnclosure.setEnclosureType(updatedEnclosureType);
        existingEnclosure.setCapacity(updatedEnclosureBase.capacity());
        existingEnclosure.setStatus(updatedEnclosureBase.status());

        // Save the updated enclosure
        this.enclosureRepository.persist(existingEnclosure);
    }
}
