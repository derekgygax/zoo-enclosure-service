package local.zoo.enclosuresservice.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.enclosuresservice.model.EnclosureType;

import java.util.List;

@ApplicationScoped
public class EnclosureTypeRepository implements PanacheRepository<EnclosureType> {


    public List<String> findAllTypes() {
        return this.getEntityManager()
                .createQuery("SELECT e.type FROM EnclosureType e", String.class)
                .getResultList();
    }

}