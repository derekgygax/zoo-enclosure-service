package local.zoo.enclosuresservice.dto.enclosure;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import local.zoo.enclosuresservice.enums.EnclosureStatus;

public record EnclosureBase(

        @Schema(required = true, title = "Name", description = "Name of the enclosure", maxLength = 100) String name,

        @Schema(required = true, format = "selector", title = "Enclosure Type", maxLength = 100, description = "The type of the enclosure, such as 'jungle', 'desert', or 'aquarium'") String enclosureTypeId,

        @Schema(required = true, minimum = "0", title = "Capacity", description = "The maximum number of animals the enclosure can hold") int capacity,

        @Schema(required = true, title = "Status", description = "The current status of the enclosure") EnclosureStatus status

) {
}
