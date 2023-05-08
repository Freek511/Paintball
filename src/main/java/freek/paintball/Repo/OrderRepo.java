package freek.paintball.Repo;

import freek.paintball.Entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository <Order, Long> {
    Order findAllByOrderDateAndPlayTime(String date, int playTime);
}
