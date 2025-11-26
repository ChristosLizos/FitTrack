package gr.hua.fitTrack.core.service.model;

public record CreateTrainerResult(
        boolean created,
        String reason,
        TrainerView trainerView
) {
    public static CreateTrainerResult success(TrainerView trainerView){
        if (trainerView == null) throw new NullPointerException("trainerView == null");
        return new CreateTrainerResult(true, null, trainerView);
    }

    public static CreateTrainerResult fail(String reason){
        if (reason == null) throw new NullPointerException("reason == null");
        if (reason.isBlank()) throw new IllegalArgumentException("reason is blank");
        return new CreateTrainerResult(false, reason, null);
    }
}
