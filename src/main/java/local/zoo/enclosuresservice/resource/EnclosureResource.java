package local.zoo.enclosuresservice.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import local.zoo.enclosuresservice.service.EnclosureService;
import local.zoo.enclosuresservice.dto.ModelIdentifier;
import local.zoo.enclosuresservice.dto.enclosure.EnclosureBase;

// models
import local.zoo.enclosuresservice.model.Enclosure;

import java.util.List;
import java.util.UUID;

@Path("/api/v1/enclosures")
public class EnclosureResource {

    @Inject
    EnclosureService enclosureService;

    // GET METHODS
    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enclosure> getEnclosures() {
        return this.enclosureService.getAllEnclosures();
    }

    @GET
    @Path("identifiers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelIdentifier> getEnclosureIdentifiers() {
        return this.enclosureService.getAllEnclosureIdentifiers();
    }

    @GET
    @Path("/{enclosureId}/base")
    @Produces(MediaType.APPLICATION_JSON)
    public EnclosureBase getEnclosureBaseById(@PathParam("enclosureId") UUID enclosureId) {
        return this.enclosureService.getEnclosureBaseById(enclosureId);
    }

    // POST METHODS
    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEnclosure(EnclosureBase enclosureBase) {
        this.enclosureService.addEnclosure(enclosureBase);
    }

    // PUT METHODS
    @PUT
    @Path("/{enclosureId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEnclosure(@PathParam("enclosureId") UUID enclosureId, EnclosureBase updatedEnclosureBase) {
        this.enclosureService.updateEnclosure(enclosureId, updatedEnclosureBase);
    }
}
