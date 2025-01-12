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
    public EnclosureType getEnclosureTypeByKey(String type) {

        EnclosureType enclosureType = this.enclosureTypeRepository.findByType(type);
        if (enclosureType == null) {
            throw new IllegalArgumentException(
                    "Enclosure type '" + type + "' does not exist.");
        }
        return enclosureType;
    }

    /**
     * Retrieve all EnclosureType objects.
     *
     * @return List of EnclosureType
     */
    public List<EnclosureType> getAllEnclosureTypes() {
        return this.enclosureTypeRepository.listAll();
    }

    /**
     * Retrieve all enclosure type keys (type column).
     *
     * @return List of Strings representing the type values
     */
    public List<String> getAllEnclosureTypeKeys() {
        return this.enclosureTypeRepository.findAllTypes();
    }

    // You need the Transactional so that something happens in the DB!!!
    @Transactional
    public void addEnclosureType(EnclosureTypeBase enclosureTypeBase) {
        EnclosureType enclosureType = new EnclosureType(
                enclosureTypeBase.type(),
                enclosureTypeBase.description());
        this.enclosureTypeRepository.persist(enclosureType);
    }
}
