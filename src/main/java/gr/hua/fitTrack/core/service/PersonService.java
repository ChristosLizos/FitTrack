package gr.hua.fitTrack.core.service;

import gr.hua.fitTrack.core.service.model.CreatePersonRequest;
import gr.hua.fitTrack.core.service.model.CreatePersonResult;

public interface PersonService {

    CreatePersonResult createPerson(final CreatePersonRequest createPersonRequest, final boolean notify);

    default CreatePersonResult createPerson(final CreatePersonRequest createPersonRequest) {
        return this.createPerson(createPersonRequest, true);
    }

}
