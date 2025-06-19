package co.edu.poli.ces3.examenfinalces3.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private String subject;

    @NotNull
    @Column(nullable = false)
    private Double salary;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;




    public Teacher() {
    }




    public Teacher(String name, String lastName, String subject, Double salary, String email) {
        this.name = name;
        this.lastName = lastName;
        this.subject = subject;
        this.salary = salary;
        this.email = email;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subject='" + subject + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}