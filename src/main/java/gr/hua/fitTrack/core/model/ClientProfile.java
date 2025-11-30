package gr.hua.fitTrack.core.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name ="client_profile")
public class ClientProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "person_id", nullable = false,unique = true)
    private Person person;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "height", nullable = false)
    private int height;

    @OneToOne(mappedBy = "client",cascade = CascadeType.ALL, orphanRemoval = true)
    private Goals goals ;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progress> progress ;

    public ClientProfile() {
    }
    public ClientProfile(Long id, Person person, int weight, int height, Goals goals, List<Progress> progress) {
        this.id = id;
        this.person = person;
        this.weight = weight;
        this.height = height;
        this.goals = goals;
        this.progress = progress;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Goals getGoals() {
        return goals;
    }

    public void setGoals(Goals goals) {
        this.goals = goals;
    }

    public List<Progress> getProgress() {
        return progress;
    }

    public void setProgress(List<Progress> progress) {
        this.progress = progress;
    }
}
