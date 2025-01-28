package local.zoo.enclosuresservice.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.enclosuresservice.dto.enclosureType.EnclosureTypeBase;
import local.zoo.enclosuresservice.model.EnclosureType;

import java.util.List;

@ApplicationScoped
public class EnclosureTypeRepository implements PanacheRepositoryBase<EnclosureType, String> {

    public List<String> findAllIds() {
        return this.getEntityManager()
                .createQuery("SELECT et.id FROM EnclosureType et", String.class)
                .getResultList();
    }

    public EnclosureTypeBase findEnclosureTypeBaseById(String id) {
        return this.getEntityManager()
                .createQuery(
                        "SELECT new EnclosureTypeBase(" +
                                "et.id, et.description) " +
                                "FROM EnclosureType et WHERE et.id = :id",
                        EnclosureTypeBase.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}