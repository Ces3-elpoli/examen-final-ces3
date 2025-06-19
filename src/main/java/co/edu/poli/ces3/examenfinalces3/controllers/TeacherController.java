package co.edu.poli.ces3.examenfinalces3.controllers;
import co.edu.poli.ces3.examenfinalces3.entities.Teacher;
import co.edu.poli.ces3.examenfinalces3.repositories.TeacherRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    private final Gson gson = new Gson();

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



    @GetMapping("/salarios-anuales")
    public ResponseEntity<String> obtenerSalarioAnual() {
        List<Teacher> teachers = teacherRepository.findAll();
        List<JsonObject> salarios = new ArrayList<>();

        for (Teacher teacher : teachers) {
            JsonObject json = new JsonObject();
            json.addProperty("Nombre Completo", teacher.getName() + " " + teacher.getLastName());
            json.addProperty("salarioAnual", teacher.calcularSalarioAnual());
            salarios.add(json);
        }

        return ResponseEntity.ok(gson.toJson(salarios));
    }


    @GetMapping("/{id}/salario-anual")
    public ResponseEntity<String> obtenerSalarioAnualPorId(@PathVariable Long id) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            JsonObject json = new JsonObject();
            json.addProperty("Nombre Completo", teacher.getName() + " " + teacher.getLastName());
            json.addProperty("salarioAnual", teacher.calcularSalarioAnual());

            return ResponseEntity.ok(gson.toJson(json));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}