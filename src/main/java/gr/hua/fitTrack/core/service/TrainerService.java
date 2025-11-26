package gr.hua.fitTrack.core.service;

import gr.hua.fitTrack.core.model.TrainerOverrideAvailability;
import gr.hua.fitTrack.core.model.TrainerProfile;
import gr.hua.fitTrack.core.model.TrainerWeeklyAvailability;
import gr.hua.fitTrack.core.service.model.CreateTrainerRequest;
import gr.hua.fitTrack.core.service.model.CreateTrainerResult;

import java.util.List;

public interface TrainerService {

    CreateTrainerResult createTrainerProfile(final CreateTrainerRequest createTrainerRequest, final boolean notify);

    TrainerProfile updateTrainerProfile(int trainerProfileId, String specialization, String bio, String location);

    TrainerProfile getTrainerProfile(int trainerProfileId);

    boolean existsByTrainerProfileId(int trainerProfileId);

    List<TrainerWeeklyAvailability> getWeeklyAvailability(int trainerProfileId);

    void saveWeeklyAvailability(int trainerProfileId, List<TrainerWeeklyAvailability> weeklyAvailability);

    void deleteWeeklyAvailability(int trainerProfileId, List<TrainerWeeklyAvailability> weeklyAvailability);

}
