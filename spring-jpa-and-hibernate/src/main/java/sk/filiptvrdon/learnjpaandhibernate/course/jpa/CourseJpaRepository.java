package sk.filiptvrdon.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sk.filiptvrdon.learnjpaandhibernate.course.Course;

@Repository
@Transactional
public class CourseJpaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public void insert(Course course) {
	entityManager.merge(course);
    }
    
    public Course findById(long id) {
	return entityManager.find(Course.class, id);
    }
    
    public void deleteById(long id) {
	entityManager.remove(findById(id));
    }

}
