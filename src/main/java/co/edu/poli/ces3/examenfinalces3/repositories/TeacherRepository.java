package co.edu.poli.ces3.examenfinalces3.repositories;

import co.edu.poli.ces3.examenfinalces3.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}