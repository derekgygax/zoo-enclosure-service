package local.zoo.enclosuresservice.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import local.zoo.enclosuresservice.dto.EnclosureTypeBase;
import local.zoo.enclosuresservice.model.EnclosureType;
import local.zoo.enclosuresservice.repository.EnclosureTypeRepository;

import java.util.List;

@ApplicationScoped
public class EnclosureTypeService {

    @Inject
    EnclosureTypeRepository enclosureTypeRepository;

    // Get the enclosure type based on the key
    // passed in as a string
    public EnclosureType getEnclosureTypeById(String id) {

        EnclosureType enclosureType = this.enclosureTypeRepository.findById(id);
        if (enclosureType == null) {
            throw new IllegalArgumentException(
                    "Enclosure type '" + id + "' does not exist.");
        }
        return enclosureType;
    }

    public List<EnclosureType> getAllEnclosureTypes() {
        return this.enclosureTypeRepository.listAll();
    }

    public List<String> getAllEnclosureTypeIds() {
        return this.enclosureTypeRepository.findAllIds();
    }

    // You need the Transactional so that something happens in the DB!!!
    @Transactional
    public void addEnclosureType(EnclosureTypeBase enclosureTypeBase) {
        EnclosureType enclosureType = new EnclosureType(
                enclosureTypeBase.id(),
                enclosureTypeBase.description());
        this.enclosureTypeRepository.persist(enclosureType);
    }
}
