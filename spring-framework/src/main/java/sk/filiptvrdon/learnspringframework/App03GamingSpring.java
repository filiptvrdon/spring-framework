package sk.filiptvrdon.learnspringframework;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sk.filiptvrdon.learnspringframework.game.GameRunner;

public class App03GamingSpring {
	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingSpringConfig.class)) {
			var gameRunner = context.getBean(GameRunner.class);
			gameRunner.run();

		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

}
