package local.zoo.enclosuresservice.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import local.zoo.enclosuresservice.service.EnclosureService;
import local.zoo.enclosuresservice.dto.EnclosureBase;
// models
import local.zoo.enclosuresservice.model.Enclosure;

import java.util.List;

@Path("/api/v1/enclosures")
public class EnclosureResource {

    @Inject
    EnclosureService enclosureService;

    // GET METHODS
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enclosure> getEnclosures() {
        return this.enclosureService.getAllEnclosures();
    }

    // POST METHODS
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEnclosure(EnclosureBase enclosureBase) {
        this.enclosureService.addEnclosure(enclosureBase);
    }
}
