package sk.filiptvrdon.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sk.filiptvrdon.learnspringframework.game.GameRunner;
import sk.filiptvrdon.learnspringframework.game.GamingConsole;
import sk.filiptvrdon.learnspringframework.game.PacmanGame;

@Configuration
public class GamingSpringConfig {

	@Bean
	public GamingConsole game() {
		return new PacmanGame();
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}

}
