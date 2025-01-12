package local.zoo.enclosuresservice.repository;

import java.util.List;
import java.util.UUID;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.enclosuresservice.dto.enclosure.EnclosureBase;
import local.zoo.enclosuresservice.dto.enclosure.EnclosureIdentifier;
// models
import local.zoo.enclosuresservice.model.Enclosure;

@ApplicationScoped
public class EnclosureRepository implements PanacheRepositoryBase<Enclosure, UUID> {

    public List<EnclosureIdentifier> findAllIdentifiers() {
        return this.getEntityManager()
                .createQuery("SELECT e.id, e.name from Enclosure e", EnclosureIdentifier.class)
                .getResultList();
    }

    public EnclosureBase findEnclosureBaseById(UUID id) {
        return this.getEntityManager()
                .createQuery(
                        "SELECT new local.zoo.enclosuresservice.dto.enclosure.EnclosureBase(" +
                                "e.name, e.enclosureType.id, e.capacity, e.status) " +
                                "FROM Enclosure e WHERE e.id = :id",
                        EnclosureBase.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
