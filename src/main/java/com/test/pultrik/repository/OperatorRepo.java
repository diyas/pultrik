package com.test.pultrik.repository;


import com.test.pultrik.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepo extends JpaRepository<Operator, Long> {
    
}
