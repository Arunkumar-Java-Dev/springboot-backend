package com.training.springboot.repository;

import com.training.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.firstName =:firstName")
    List<Employee> findAllByFirstName(String firstName);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);
}
