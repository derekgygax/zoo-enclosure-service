package local.zoo.enclosuresservice.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.enclosuresservice.model.Enclosure;

@ApplicationScoped
public class EnclosureRepository implements PanacheRepository<Enclosure> {

}
