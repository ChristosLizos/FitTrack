package gr.hua.fitTrack.core.service.impl;

import gr.hua.fitTrack.core.model.ClientProfile;
import gr.hua.fitTrack.core.model.Goals;
import gr.hua.fitTrack.core.model.Person;
import gr.hua.fitTrack.core.repository.ClientProfileRepository;
import gr.hua.fitTrack.core.repository.PersonRepository;
import gr.hua.fitTrack.core.service.ClientService;
import gr.hua.fitTrack.core.service.mapper.ClientMapper;
import gr.hua.fitTrack.core.service.model.ClientView;
import gr.hua.fitTrack.core.service.model.CreateClientRequest;
import gr.hua.fitTrack.core.service.model.CreateClientResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    public final ClientProfileRepository clientProfileRepository;
    public final PersonRepository personRepository;
    public final ClientMapper clientMapper;

    public ClientServiceImpl(ClientProfileRepository clientProfileRepository,
                             PersonRepository personRepository, ClientMapper clientMapper) {
        if(clientProfileRepository ==null) throw new NullPointerException("clientProfileRepository is null");
        if(personRepository ==null) throw new NullPointerException("personRepository is null");
        if(clientMapper ==null) throw new NullPointerException("clientMapper is null");
        this.clientProfileRepository = clientProfileRepository;
        this.personRepository = personRepository;
        this.clientMapper = new ClientMapper();

    }
    @Override
    @Transactional
    public CreateClientResult createClientProfile(final CreateClientRequest createClientRequest, final boolean notify){
        if (createClientRequest == null) throw new  NullPointerException("createClientRequest is null");

        final Person person = personRepository.getReferenceById(createClientRequest.personId());
        final int weight =  createClientRequest.weight();
        final int height =  createClientRequest.height();
        final Integer runningTimeGoal = createClientRequest.runningTimeGoal();
        final Integer weightGoal = createClientRequest.targetWeight();
        final Integer bodyPercentageGoal = createClientRequest.targetBodyFat();


        ClientProfile clientProfile = new ClientProfile();

        clientProfile.setPerson(person);
        clientProfile.setWeight(weight);
        clientProfile.setHeight(height);
        Goals goals = new Goals();

        //Create Goal
        goals.setBodyFatPercentageGoal(bodyPercentageGoal);
        goals.setWeightGoal(weightGoal);
        goals.setRunningTimeGoal(runningTimeGoal);
        goals.setClient(clientProfile);

        clientProfile.setGoals(goals);
        clientProfile.setProgress(null);

        clientProfile = clientProfileRepository.save(clientProfile);

        if(notify){
            final String content = String.format("Client profile created with id: %s", clientProfile.getId());
        }
        final ClientView clientView = this.clientMapper.converClientToClientView(clientProfile);

        return CreateClientResult.success(clientView);

    }

}
