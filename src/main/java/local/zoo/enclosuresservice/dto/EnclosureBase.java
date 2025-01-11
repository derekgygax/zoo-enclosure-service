package local.zoo.enclosuresservice.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import local.zoo.enclosuresservice.enums.EnclosureStatus;

public record EnclosureBase(

        @Schema(required = true, title = "Name", description = "Name of the enclosure", maxLength = 100) String name,

        @Schema(required = true, format = "selector", title = "Enclosure Type", description = "The type of the enclosure") String enclosureType,

        @Schema(required = true, minimum = "0", title = "Capacity", description = "The maximum number of animals the enclosure can hold") int capacity,

        @Schema(required = true, title = "Status", description = "The current status of the enclosure") EnclosureStatus status

) {
}
