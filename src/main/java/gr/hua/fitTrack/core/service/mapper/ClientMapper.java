package gr.hua.fitTrack.core.service.mapper;

import gr.hua.fitTrack.core.model.ClientProfile;
import gr.hua.fitTrack.core.service.model.ClientView;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientView converClientToClientView(ClientProfile clientProfile){
        if(clientProfile == null){
            return null;
        }
        final ClientView clientView = new ClientView(
                clientProfile.getId(),
                clientProfile.getPerson().getFirstName(),
                clientProfile.getPerson().getLastName(),
                clientProfile.getWeight(),
                clientProfile.getHeight(),
                clientProfile.getGoals(),
                clientProfile.getProgress()
        );
        return clientView;
    }
}
