package local.zoo.enclosuresservice.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import local.zoo.enclosuresservice.dto.ModelIdentifier;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "enclosure_type")
// use PanacheEntityBase because you are NOT generating an ID
// use PanacheEntity is you ARE generating an ID
// You need this PanacheEntityBase PanacheEntity shit
public class EnclosureType extends PanacheEntityBase {

    @Id
    @Column(length = 100, nullable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant updatedAt;

    @OnDelete(action = OnDeleteAction.RESTRICT)
    @OneToMany(mappedBy = "enclosureType", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REFRESH }, orphanRemoval = true)
    // This is so that the endpoint for enclosures-types can get the enclosures
    // usign that type without endless loop.
    // NEEDS: @JsonBackReference on private EnclosureType enclosureType;
    // @JsonManagedReference
    // This makes sure you don't do an endless loop of retrieval
    @JsonIgnore
    private List<Enclosure> enclosures;

    @PrePersist
    @PreUpdate
    // ensure the id for the type is ALWAYS lowercase
    protected void ensureLowercaseType() {
        this.id = this.id.toLowerCase();
    }

    public EnclosureType() {
        // Default constructor
    }

    public EnclosureType(String id, String description) {
        // Ensure the id for the type is stored in lowercase
        this.id = id.toLowerCase();
        this.description = description;
    }

    public ModelIdentifier getModelIdentifier() {
        return new ModelIdentifier(this.getId().toString(), this.getId().toString());
    }

    public String getId() {
        return id;
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

    public List<Enclosure> getEnclosures() {
        return enclosures;
    }

    @Override
    public String toString() {
        return "EnclosureType{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    // TODO how to do indexing
    // @Table(name = "enclosure_type", indexes = {
    // @Index(name = "idx_enclosure_type_id", columnList = "id")
    // });

}
