package gr.hua.fitTrack.core.service.model;

import gr.hua.fitTrack.core.model.Person;
import gr.hua.fitTrack.core.model.TrainerOverrideAvailability;
import gr.hua.fitTrack.core.model.TrainerWeeklyAvailability;
import gr.hua.fitTrack.core.model.Weekday;

import java.util.List;
import java.util.Map;

public record CreateTrainerRequest(
        Long personId,
        String location,
        String specialization,
        String Client_Notes,
        Map<Weekday, String> startTimes,
        Map<Weekday, String> endTimes)
 {
}
