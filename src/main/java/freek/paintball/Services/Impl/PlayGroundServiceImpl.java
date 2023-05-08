package freek.paintball.Services.Impl;

import freek.paintball.Entities.PlayGround;
import freek.paintball.Exceptions.PlayGroundNotFoundException;
import freek.paintball.Repo.PlayGroundRepo;
import freek.paintball.Services.PlayGroundService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class PlayGroundServiceImpl implements PlayGroundService {

    private final PlayGroundRepo _playGroundRepo;


    @Override
    public List<PlayGround> findAll() {
        return _playGroundRepo.findAll();
    }

    @Override
    @Transactional
    public boolean addPlayGround(PlayGround pg) {
        if(_playGroundRepo.existsByName(pg.getName())){
            return false;
        }
        _playGroundRepo.save(pg);
        return true;
    }

    @Override
    @Transactional
    public void deletePlayGroundById(Long pgID) {
       if(_playGroundRepo.findById(pgID).isEmpty()) throw new PlayGroundNotFoundException("No playgrounds " +
               " with id = " + pgID);
       else {
           _playGroundRepo.deleteById(pgID);
       }
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayGround> sortByName() {
        return _playGroundRepo.findAll().stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayGround> sortByPrice() {
        return _playGroundRepo.findAll().stream()
                .sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice())).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayGround> sortByArea() {
        return _playGroundRepo.findAll().stream()
                .sorted((p1, p2) -> p1.getArea().compareTo(p2.getArea())).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlayGround> sortByMaxPeople() {
        return _playGroundRepo.findAll().stream()
                .sorted((p1, p2) -> p1.getMaxPeople().compareTo(p2.getMaxPeople())).toList();
    }


}
