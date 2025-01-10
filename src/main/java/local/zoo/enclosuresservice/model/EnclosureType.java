package local.zoo.enclosuresservice.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "enclosure_type")
// use PanacheEntityBase because you are NOT generating an ID
// use PanacheEntity is you ARE generating an ID
// You need this PanacheEntityBase PanacheEntity shit
public class EnclosureType extends PanacheEntityBase {

    @Id
    @Column(length = 100, nullable = false, unique = true)
    @Schema(required = true, title = "Enclosure Type", description = "The type of the enclosure", maxLength = 100)
    private String type;

    @Column(length = 500, nullable = false)
    // TODO
    // YOU CAN PUT FORMAT IN HERE!! This is how you do what you did in python!!
    @Schema(required = true, title = "Enclosure Type Description", description = "Description of the type", maxLength = 500)
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant updatedAt;


    @PrePersist
    @PreUpdate
    // ensure the type is ALWAYS lowercase
    protected void ensureLowercaseType() {
        this.type = this.type.toLowerCase();
    }

    public EnclosureType() {
        // Default constructor
    }

    public EnclosureType(String type, String description) {
        // Ensure name is stored in lowercase
        this.type = type.toLowerCase();
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        // Ensure name is stored in lowercase
        this.type = type.toLowerCase();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "EnclosureType{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
