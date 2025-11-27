package gr.hua.fitTrack.core.repository;

import gr.hua.fitTrack.core.model.ClientProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientProfileRepository extends JpaRepository<ClientProfile, Integer> {
}
