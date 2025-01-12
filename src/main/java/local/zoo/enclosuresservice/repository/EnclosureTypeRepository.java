package local.zoo.enclosuresservice.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.enclosuresservice.model.EnclosureType;

import java.util.List;

@ApplicationScoped
public class EnclosureTypeRepository implements PanacheRepositoryBase<EnclosureType, String> {

    public List<String> findAllIds() {
        return this.getEntityManager()
                .createQuery("SELECT et.id FROM EnclosureType et", String.class)
                .getResultList();
    }

}