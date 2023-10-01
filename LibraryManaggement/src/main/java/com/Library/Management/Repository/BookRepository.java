package com.Library.Management.Repository;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.Library.Management.Entities.Books;

@Configuration
@EnableWebMvc
public interface BookRepository extends JpaRepository<Books, Integer> {
	
	List<Books> findByPublication(String publicationName);

}