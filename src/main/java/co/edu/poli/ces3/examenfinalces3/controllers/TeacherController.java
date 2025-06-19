package co.edu.poli.ces3.examenfinalces3.controllers;
import co.edu.poli.ces3.examenfinalces3.entities.Teacher;
import co.edu.poli.ces3.examenfinalces3.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public ResponseEntity<Teacher> crearProfesor(@RequestBody Teacher teacher) {
        try {
            Teacher guardado = teacherRepository.save(teacher);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Teacher> obtenerTodos() {
        return teacherRepository.findAll();
    }

}