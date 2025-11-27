package gr.hua.fitTrack.core.service.model;

import gr.hua.fitTrack.core.model.ClientProfile;

public record CreateClientResult(
        boolean created,
        String reason,
        ClientView clientView
) {
    public static CreateClientResult success(ClientView clientView) {
        if (clientView == null) throw new NullPointerException("clientView == null");
        return new CreateClientResult(true,null,clientView);
    }

    public static CreateClientResult fail(String reason) {
        if (reason == null) throw new NullPointerException("clientView == null");
        if (reason.isBlank()) throw new IllegalArgumentException("reason cannot be blank");
        return new CreateClientResult(false,reason,null);
    }

}
