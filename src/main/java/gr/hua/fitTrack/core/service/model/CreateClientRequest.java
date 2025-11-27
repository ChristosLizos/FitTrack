package gr.hua.fitTrack.core.service.model;

import gr.hua.fitTrack.core.model.Goals;


public record CreateClientRequest(
        Long personId,
        int weight,
        int height,
        Integer targetWeight,
        Integer targetBodyFat,
        Integer runningTimeGoal
) {
}
