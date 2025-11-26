package gr.hua.fitTrack.core.service.model;

public record CreatePersonResult(
        boolean created,
        String reason,
        PersonView personView
) {

    public  static CreatePersonResult success(PersonView personView) {
        if (personView == null) throw new NullPointerException("personView == null");
        return new CreatePersonResult(true, null, personView);
    }

    public static CreatePersonResult fail(final String reason){
        if (reason == null) throw new NullPointerException("reason == null");
        if (reason.isBlank()) throw new IllegalArgumentException("reason is blank");
        return new CreatePersonResult(false, reason, null);
    }
}
