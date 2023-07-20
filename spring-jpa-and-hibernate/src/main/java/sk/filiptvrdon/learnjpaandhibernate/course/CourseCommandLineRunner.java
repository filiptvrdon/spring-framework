package sk.filiptvrdon.learnjpaandhibernate.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import sk.filiptvrdon.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
    
    /*
     * @Autowired private CourseJdbcRepository repository;
     */
    
    /*
     * @Autowired private CourseJpaRepository repository;
     */
    
    @Autowired
    private CourseSpringDataJpaRepository repository;
    
    @Override
    public void run(String... args) throws Exception {
	repository.save(new Course(1, "Learn AWS JPA", "in28minutesh"));
	repository.save(new Course(2, "Learn DevOps JPA", "in28minutesh"));
	repository.save(new Course(3, "Learn Azure JPA", "in28minutesh"));
	
	System.out.println("FINDING BY ID");	
	System.out.println(repository.findById(1l));
	System.out.println(repository.findById(2l));
	System.out.println(repository.findById(3l));
	
	System.out.println("FINDING ALL");
	System.out.println(repository.findAll());
	
	System.out.println("FINDING ALL BY AUTHOR");
	System.out.println(repository.findByAuthor("in28minutes"));
	
	System.out.println("FINDING ALL BY NON EXISTENT AUTHOR");
	System.out.println(repository.findByAuthor("in29minutes"));
	
	System.out.println("FINDING BY NAME EQUALS");
	System.out.println(repository.findByName("Learn AWS JPA"));
	
	// System.out.println("FINDING BY NAME LIKE");
	// System.out.println(repository.findByNameLike("Learn AWS")
    }

}
