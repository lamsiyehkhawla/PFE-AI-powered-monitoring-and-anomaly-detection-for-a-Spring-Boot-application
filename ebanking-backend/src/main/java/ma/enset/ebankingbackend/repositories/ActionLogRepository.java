package ma.enset.ebankingbackend.repositories;

import ma.enset.ebankingbackend.entities.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionLogRepository extends JpaRepository<ActionLog, Long> {

    List<ActionLog> findByPerformedBy_Username(String username);

    List<ActionLog> findByAction(String action);

    List<ActionLog> findByPerformedBy_UsernameAndAction(String username, String action);

    List<ActionLog> findByPerformedBy_IdAndActionOrderByTimestampDesc(Long userId, String action);

    List<ActionLog> findByPerformedBy_IdOrderByTimestampDesc(Long userId);

    List<ActionLog> findByActionOrderByTimestampDesc(String action);

    List<ActionLog> findAllByOrderByTimestampDesc();
}