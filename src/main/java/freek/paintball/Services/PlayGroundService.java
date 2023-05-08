package freek.paintball.Services;

import freek.paintball.Entities.PlayGround;

import java.util.List;

public interface PlayGroundService {
    List<PlayGround> findAll();
    boolean addPlayGround(PlayGround pg);
    void deletePlayGroundById(Long pgID);

    List<PlayGround> sortByName();
    List<PlayGround> sortByPrice();
    List<PlayGround> sortByArea();
    List<PlayGround> sortByMaxPeople();

}
