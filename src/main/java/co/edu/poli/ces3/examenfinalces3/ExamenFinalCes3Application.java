package co.edu.poli.ces3.examenfinalces3;

import co.edu.poli.ces3.examenfinalces3.entities.Teacher;
import co.edu.poli.ces3.examenfinalces3.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenFinalCes3Application {

    public static void main(String[] args) {

        SpringApplication.run(ExamenFinalCes3Application.class, args);
    }

    @Bean
    CommandLineRunner init(TeacherRepository teacherRepository) {
        return args -> {
            Teacher t1 = new Teacher("Oscar", "Mesa", "Ces3", 3500.0, "OscarMesa@elpoli.edu.com");
            Teacher t2 = new Teacher("Luis", "zapata", "DPAS1", 4500.300, "LuisZ@elpoli.edu.co");
            Teacher t3 = new Teacher("Fernando", "Recaman", "CES1", 4000.0, "FR@elpoli.edu.co");

            teacherRepository.save(t1);
            teacherRepository.save(t2);
            teacherRepository.save(t3);

            for (Teacher t : teacherRepository.findAll()) {
                System.out.println(t);
                System.out.println("Salario anual: " + t.calcularSalarioAnual());
            }
        };
    }

}
