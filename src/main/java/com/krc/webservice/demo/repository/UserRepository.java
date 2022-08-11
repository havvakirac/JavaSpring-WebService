package com.krc.webservice.demo.repository;


import com.krc.webservice.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
public boolean existsByeMail(String eMail);
public List<User> findByeMail(String eMail);

@Query("select max(u.id) from User u")
public Integer findMaxId();

}
