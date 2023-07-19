package sk.filiptvrdon.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldSpringConfig {

	@Bean
	public String name() {
		return "Filip";
	}

	@Bean
	public int age() {
		return 31;
	}

	@Bean
	public Person person() {
		return new Person("Ravi", 34, new Address("Main", "Utrecht"));
	}

	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}

	@Bean
	public Person person3Paramters(String name, int age, Address address2) {
		return new Person(name, age, address2);
	}

	@Bean
	public Person person4Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {

		return new Person(name, age, address);
	}

	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Baker Street", "London");
	}

	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Bellova Ves 332", "Bellova Ves");
	}

	@Bean(name = "address4")
	public Address address4() {
		return new Address("Bellova Ves 332", "Bellova Ves");
	}

	@Bean(name = "address5")
	public Address address5() {
		return new Address("Bellova Ves 332", "Bellova Ves");
	}

}
