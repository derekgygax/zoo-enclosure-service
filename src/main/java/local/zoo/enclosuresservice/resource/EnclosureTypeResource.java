package local.zoo.enclosuresservice.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import local.zoo.enclosuresservice.dto.EnclosureTypeBase;
import local.zoo.enclosuresservice.model.EnclosureType;
import local.zoo.enclosuresservice.service.EnclosureTypeService;

import java.util.List;

@Path("/api/v1/enclosure-types")
public class EnclosureTypeResource {

    @Inject
    EnclosureTypeService enclosureTypeService;

    // GET METHODS
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnclosureType> getEnclosureTypes() {
        return this.enclosureTypeService.getAllEnclosureTypes();
    }

    @GET
    @Path("/ids")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getEnclosureTypeIds() {
        return this.enclosureTypeService.getAllEnclosureTypeIds();
    }

    // POST METHODS
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEnclosureType(EnclosureTypeBase enclosureTypeBase) {
        this.enclosureTypeService.addEnclosureType(enclosureTypeBase);
    }

}
