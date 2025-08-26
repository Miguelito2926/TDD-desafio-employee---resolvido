package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e ORDER BY e.name ASC")
    Page<Employee> findAllOrderByName(Pageable pageable);
}
