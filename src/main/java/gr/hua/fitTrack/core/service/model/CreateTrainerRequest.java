package gr.hua.fitTrack.core.service.model;

import gr.hua.fitTrack.core.model.Person;
import gr.hua.fitTrack.core.model.TrainerOverrideAvailability;
import gr.hua.fitTrack.core.model.TrainerWeeklyAvailability;

import java.util.List;

public record CreateTrainerRequest(
        Long personId,
        String location,
        String specialization,
        String Client_Notes,
        List<TrainerWeeklyAvailability> trainerWeeklyAvailability,
        List<TrainerOverrideAvailability> trainerOverrideAvailability)
 {
}
