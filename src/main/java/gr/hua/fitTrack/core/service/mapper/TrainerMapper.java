package gr.hua.fitTrack.core.service.mapper;

import gr.hua.fitTrack.core.model.TrainerProfile;
import gr.hua.fitTrack.core.service.model.TrainerView;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {
    public TrainerView convertTrainerToTrainerView(final TrainerProfile trainer) {
        if (trainer == null) {
            return null;
        }
        final TrainerView trainerView = new TrainerView(
                trainer.getId(),
                trainer.getPerson().getFirstName(),
                trainer.getPerson().getLastName(),
                trainer.getLocation(),
                trainer.getSpecialization(),
                trainer.getWeeklyAvailability()

        );
        return trainerView;
    }
}
