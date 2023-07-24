package sk.filiptvrdon.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.filiptvrdon.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
