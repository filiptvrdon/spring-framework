package sk.filiptvrdon.learnspringframework;

import sk.filiptvrdon.learnspringframework.game.GameRunner;
import sk.filiptvrdon.learnspringframework.game.PacmanGame;

public class App01GamingBasicJava {
	public static void main(String[] args) {

		// var game = new SuperContraGame();
		// var game = new MarioGame();
		var game = new PacmanGame();

		var gameRunner = new GameRunner(game);
		

		gameRunner.run();

	}

}
