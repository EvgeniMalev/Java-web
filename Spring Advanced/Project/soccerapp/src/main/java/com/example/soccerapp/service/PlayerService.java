import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
