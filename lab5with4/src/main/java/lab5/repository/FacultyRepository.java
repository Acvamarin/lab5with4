package lab5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lab5.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

	Faculty findByphone(String name);

	Faculty findByName(String name);

}
