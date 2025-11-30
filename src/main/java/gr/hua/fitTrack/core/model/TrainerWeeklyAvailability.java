package gr.hua.fitTrack.core.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name ="trainer_weekly_availability")
public class TrainerWeeklyAvailability {

    //The trainers weekly schedule availability. Can change with @{link} TrainerOverrideAvailability

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainer_profile_id", nullable = false)
    private TrainerProfile trainerProfile;

    @Column(name = "weekday")
    @Enumerated(EnumType.STRING)
    private Weekday weekday;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    public TrainerWeeklyAvailability() {}

    public TrainerWeeklyAvailability(Long id, TrainerProfile trainerProfile, Weekday weekday, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.trainerProfile = trainerProfile;
        this.weekday = weekday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public TrainerProfile getTrainerProfile() {
        return trainerProfile;
    }

    public Weekday getWeekday() {
        return weekday;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTrainerProfile(TrainerProfile trainerProfile) {
        this.trainerProfile = trainerProfile;
    }

    public void setWeekday(Weekday weekday) {
        this.weekday = weekday;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}

