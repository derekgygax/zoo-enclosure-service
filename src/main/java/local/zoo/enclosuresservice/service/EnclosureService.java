package local.zoo.enclosuresservice.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import local.zoo.enclosuresservice.dto.EnclosureBase;
import local.zoo.enclosuresservice.model.Enclosure;
import local.zoo.enclosuresservice.model.EnclosureType;
import local.zoo.enclosuresservice.repository.EnclosureRepository;
import local.zoo.enclosuresservice.repository.EnclosureTypeRepository;

@ApplicationScoped
public class EnclosureService {

    @Inject
    EnclosureRepository enclosureRepository;
    @Inject
    EnclosureTypeRepository enclosureTypeRepository;

    /**
     * Retrieve all Enclosure objects.
     *
     * @return List of Enclosure
     */
    public List<Enclosure> getAllEnclosures() {
        return this.enclosureRepository.listAll();
    }

    /**
     * Add a new Enclosure objects.
     *
     * @return void
     */
    @Transactional
    public void addEnclosure(EnclosureBase enclosureBase) {

        // first ensure the enclosure type passed back was real
        // if that type isn't found then return an error
        EnclosureType enclosureType = this.enclosureTypeRepository.findByType(enclosureBase.enclosureType());
        if (enclosureType == null) {
            throw new IllegalArgumentException(
                    "Enclosure type '" + enclosureBase.enclosureType() + "' does not exist.");
        }

        Enclosure enclosure = new Enclosure(
                enclosureType,
                enclosureBase.name(),
                enclosureBase.capacity(),
                enclosureBase.status());

        this.enclosureRepository.persist(enclosure);
    }
}
