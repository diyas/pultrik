package com.test.pultrik.repository;


import com.test.pultrik.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

}
