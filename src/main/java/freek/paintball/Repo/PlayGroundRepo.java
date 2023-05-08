package freek.paintball.Repo;

import freek.paintball.Entities.PlayGround;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayGroundRepo extends JpaRepository<PlayGround, Long> {
    PlayGround getPlayGroundByName(String name) ;
    boolean existsByName(String name);
}
