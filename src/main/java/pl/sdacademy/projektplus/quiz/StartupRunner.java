package pl.sdacademy.projektplus.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.sdacademy.projektplus.quiz.player.PlayerEntity;
import pl.sdacademy.projektplus.quiz.player.PlayerRepository;
import java.util.List;

@Component
@Log
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String...args) throws Exception {
        log.info("Executing startup actions...");
        playerRepository.save(new PlayerEntity("John"));
        playerRepository.save(new PlayerEntity("Harry"));
        playerRepository.save(new PlayerEntity("George"));

        log.info("List of players from database:");
        List<PlayerEntity> playersFromDatabase = playerRepository.findAll();
        for (PlayerEntity player : playersFromDatabase) {
            log.info("Retrieved player: " + player);
        }
    }
}
