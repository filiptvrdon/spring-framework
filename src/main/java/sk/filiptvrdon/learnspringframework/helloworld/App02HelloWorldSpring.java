package sk.filiptvrdon.learnspringframework.helloworld;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {

		/*
		 * GOALS 1. Launch A Spring Context 2. Configure Spring
		 */

		try (var context = new AnnotationConfigApplicationContext(HelloWorldSpringConfig.class)) {
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("address2"));
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Paramters"));

			System.out.println("--------------------------------");
			System.out.println(context.getBean(Address.class));
			System.out.println(context.getBean("person4Qualifier"));
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// SPRING CONTINER == SPRING CONTEXT == IOC CONTAINER
		// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

	}

}
