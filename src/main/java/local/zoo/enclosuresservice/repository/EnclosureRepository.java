package local.zoo.enclosuresservice.repository;

import java.util.UUID;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

// models
import local.zoo.enclosuresservice.model.Enclosure;

@ApplicationScoped
public class EnclosureRepository implements PanacheRepositoryBase<Enclosure, UUID> {

}
