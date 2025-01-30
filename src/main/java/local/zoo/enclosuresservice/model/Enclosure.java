package local.zoo.enclosuresservice.model;

import java.time.Instant;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

// import com.fasterxml.jackson.annotation.JsonBackReference;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.ForeignKey;
import local.zoo.enclosuresservice.dto.ModelIdentifier;
// enums
import local.zoo.enclosuresservice.enums.EnclosureStatus;

@Entity
@Table(name = "enclosure")
public class Enclosure extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true, updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "enclosure_type_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    // so that the endpoint for enclosures-types can get the enclosures
    // usign that type without endless loop.
    // NEEDS: @JsonManagedReference on private List<Enclosure> enclosures;
    // @JsonBackReference
    private EnclosureType enclosureType;

    @Column(name = "capacity", nullable = false)
    @PositiveOrZero
    private int capacity;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnclosureStatus status;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant updatedAt;

    // TODO PUT THIS BACK!!!
    // This is ONLY in the class and will NOT be in the database
    // this will be useful maybe
    // @Formula("(SELECT COUNT(a.id) FROM animal a WHERE a.enclosure_id = id)")
    // private int currentOccupancy;

    public Enclosure() {
    }

    public Enclosure(EnclosureType enclosureType, String name, int capacity, EnclosureStatus status) {
        this.enclosureType = enclosureType;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    public ModelIdentifier getModelIdentifier() {
        return new ModelIdentifier(this.getId().toString(), this.getName());
    }

    public UUID getId() {
        return id;
    }

    public EnclosureType getEnclosureType() {
        return enclosureType;
    }

    public void setEnclosureType(EnclosureType enclosureType) {
        this.enclosureType = enclosureType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public EnclosureStatus getStatus() {
        return status;
    }

    public void setStatus(EnclosureStatus status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    // public int getCurrentOccupancy() {
    // return currentOccupancy;
    // }

    // public void setCurrentOccupancy(int currentOccupancy) {
    // this.currentOccupancy = currentOccupancy;
    // }

    @Override
    public String toString() {
        return "Enclosure [id=" + id + ", enclosureType=" + enclosureType + ", name=" + name + ", capacity=" + capacity
                + ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", currentOccupancy="
                // + currentOccupancy + "]";
                + "]";
    }

}
