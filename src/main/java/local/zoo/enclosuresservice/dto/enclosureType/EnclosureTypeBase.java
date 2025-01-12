package local.zoo.enclosuresservice.dto.enclosureType;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record EnclosureTypeBase(
        // This stuff is REQUIRED to do so that the openAPI will mark these
        // fields as required, which you need for the zodSchemas
        // that are built from the openAPI
        @Schema(required = true, title = "Enclosure Type", description = "Unique identifier for the enclosure type, such as 'jungle', 'desert', or 'aquarium'", maxLength = 100, examples = "jungle") String id,

        @Schema(required = true, title = "Enclosure Type Description", description = "Description of the type", maxLength = 500) String description) {
}
