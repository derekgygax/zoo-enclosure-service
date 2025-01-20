package local.zoo.enclosuresservice.dto.enclosure;

import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record EnclosureIdentifier(
        @Schema(required = true, title = "ID", description = "Unique identifier of the Enclosure") UUID id,
        @Schema(required = true, title = "Name", description = "Name of the enclosure") String name) {
}
