package gr.hua.fitTrack.core.service.model;

import gr.hua.fitTrack.core.model.TrainerOverrideAvailability;
import gr.hua.fitTrack.core.model.TrainerWeeklyAvailability;

import java.util.List;

public record TrainerView(
        Long id,
        String firstName,
        String lastName,
        String location,
        String specialization,
        List<TrainerWeeklyAvailability> trainerWeeklyAvailability
       ) {
}
