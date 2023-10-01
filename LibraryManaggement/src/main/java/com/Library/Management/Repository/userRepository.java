package com.Library.Management.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.Library.Management.Entities.Member;


@Configuration
@EnableWebMvc
public interface userRepository extends JpaRepository<Member, Integer>{

}
