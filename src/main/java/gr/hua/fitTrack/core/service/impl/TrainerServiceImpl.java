package gr.hua.fitTrack.core.service.impl;

import gr.hua.fitTrack.core.model.Person;
import gr.hua.fitTrack.core.model.TrainerOverrideAvailability;
import gr.hua.fitTrack.core.model.TrainerProfile;
import gr.hua.fitTrack.core.model.TrainerWeeklyAvailability;
import gr.hua.fitTrack.core.repository.PersonRepository;
import gr.hua.fitTrack.core.repository.TrainerProfileRepository;
import gr.hua.fitTrack.core.service.TrainerService;
import gr.hua.fitTrack.core.service.mapper.TrainerMapper;
import gr.hua.fitTrack.core.service.model.CreateTrainerRequest;
import gr.hua.fitTrack.core.service.model.CreateTrainerResult;
import gr.hua.fitTrack.core.service.model.TrainerView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    public final TrainerProfileRepository trainerProfileRepository;
    private final PersonRepository personRepository;
    private final TrainerMapper trainerMapper;

    public  TrainerServiceImpl(TrainerProfileRepository trainerProfileRepository,
                               PersonRepository personRepository,
                               TrainerMapper trainerMapper) {
        if(trainerProfileRepository == null) throw new NullPointerException("trainerProfileRepository cannot be null");
        if(personRepository == null) throw new NullPointerException("personRepository cannot be null");
        if(trainerMapper == null)  throw new NullPointerException("trainerMapper cannot be null");
        this.trainerProfileRepository = trainerProfileRepository;
        this.personRepository = personRepository;
        this.trainerMapper = trainerMapper;

    }

    @Override
    public CreateTrainerResult createTrainerProfile(final CreateTrainerRequest createTrainerRequest, final boolean notify){
        if (createTrainerRequest == null) throw new NullPointerException("createTrainerRequest cannot be null");

        final Person person = personRepository.getReferenceById(createTrainerRequest.personId());
        final String location = createTrainerRequest.location();
        final String specialization  = createTrainerRequest.specialization();
        final String clientNotes = createTrainerRequest.Client_Notes();
        final List<TrainerWeeklyAvailability> trainerWeeklyAvailability = createTrainerRequest.trainerWeeklyAvailability();
        final List<TrainerOverrideAvailability> trainerOverrideAvailability = createTrainerRequest.trainerOverrideAvailability();

        TrainerProfile trainerProfile = new TrainerProfile();
        trainerProfile.setId(null); //auto-generated
        trainerProfile.setPerson(person);
        trainerProfile.setLocation(location);
        trainerProfile.setSpecialization(specialization);
        trainerProfile.setClientNotes(clientNotes);
        trainerProfile.setWeeklyAvailability(trainerWeeklyAvailability);
        trainerProfile.setOverrideAvailability(trainerOverrideAvailability);

        trainerProfile = this.trainerProfileRepository.save(trainerProfile);

        if(notify){
            final String content =String.format("You have succesfully registered for the Fit Track Application as a trainer. "
                    );
            }
        final TrainerView trainerView = this.trainerMapper.convertTrainerToTrainerView(trainerProfile);

        return CreateTrainerResult.success(trainerView);
        }


    //TODO IMPLEMENT
    @Override
    public TrainerProfile updateTrainerProfile(int trainerProfileId, String specialization, String bio, String location) {
        return null;
    }
    //TODO IMPLEMENT
    @Override
    public TrainerProfile getTrainerProfile(int trainerProfileId) {
        return null;
    }

    //TODO IMPLEMENT
    @Override
    public boolean existsByTrainerProfileId(int trainerProfileId) {
        return false;
    }

    //TODO IMPLEMENT
    @Override
    public List<TrainerWeeklyAvailability> getWeeklyAvailability(int trainerProfileId) {
        return List.of();
    }

    //TODO IMPLEMENT

    @Override
    public void saveWeeklyAvailability(int trainerProfileId, List<TrainerWeeklyAvailability> weeklyAvailability) {

    }

    //TODO IMPLEMENT
    @Override
    public void deleteWeeklyAvailability(int trainerProfileId, List<TrainerWeeklyAvailability> weeklyAvailability) {

    }
}



