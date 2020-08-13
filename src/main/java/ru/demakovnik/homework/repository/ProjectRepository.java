package ru.demakovnik.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demakovnik.homework.domain.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

    Project findByTitle(String title);
}
