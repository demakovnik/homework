package ru.demakovnik.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demakovnik.homework.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
