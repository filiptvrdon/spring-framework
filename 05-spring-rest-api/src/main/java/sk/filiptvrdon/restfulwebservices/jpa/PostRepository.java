package sk.filiptvrdon.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.filiptvrdon.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
