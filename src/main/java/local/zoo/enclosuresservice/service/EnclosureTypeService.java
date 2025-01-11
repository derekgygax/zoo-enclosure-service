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
