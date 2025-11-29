package gr.hua.fitTrack.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "trainer_profile")
public class TrainerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false,unique = true)
    private Person person;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    //TODO CHANGE FROM STRING
    @Column(name="client_notes")
    private String clientNotes;

    @JsonIgnore
    @OneToMany(mappedBy = "trainerProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainerWeeklyAvailability> weeklyAvailability;

    @JsonIgnore
    @OneToMany(mappedBy = "trainerProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainerOverrideAvailability> overrideAvailability;

    public TrainerProfile() {}

    public TrainerProfile(Long id,
                          Person person,
                          String location,
                          String specialization,
                          String clientNotes,
                          List<TrainerWeeklyAvailability> weeklyAvailability,
                          List<TrainerOverrideAvailability> overrideAvailability
    ) {
        this.id = id;
        this.person = person;
        this.location = location;
        this.specialization = specialization;
        this.clientNotes = clientNotes;
        this.weeklyAvailability = weeklyAvailability;
        this.overrideAvailability = overrideAvailability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getClientNotes() {
        return clientNotes;
    }

    public void setClientNotes(String client_Notes) {
        this.clientNotes = client_Notes;
    }

    public List<TrainerWeeklyAvailability> getWeeklyAvailability() {
        return weeklyAvailability;
    }

    public void setWeeklyAvailability(List<TrainerWeeklyAvailability> trainerWeeklyAvailability) {
        this.weeklyAvailability = trainerWeeklyAvailability;
    }

    public List<TrainerOverrideAvailability> getOverrideAvailability() {
        return overrideAvailability;
    }

    public void setOverrideAvailability(List<TrainerOverrideAvailability> trainerOverrideAvailability) {
        this.overrideAvailability = trainerOverrideAvailability;
    }
}
