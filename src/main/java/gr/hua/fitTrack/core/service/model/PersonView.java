package gr.hua.fitTrack.core.service.model;

import gr.hua.fitTrack.core.model.PersonType;

public record PersonView(
        long id,
        String firstName,
        String lastName,
        int age,
        String emailAddress,
        String phoneNumber,
        PersonType type
) {
}
