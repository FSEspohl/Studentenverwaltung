package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DatabaseAccessStudentsJPA implements DatabaseAccessStudents {

    private StudentJPARepo studentJPARepo;

    public DatabaseAccessStudentsJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student insertStudent(Student student) {
        return this.studentJPARepo.save(student);
    }

    @Override
    public List<Student> allStudents() {
        return this.studentJPARepo.findAll();
    }

    @Override
    public List<Student> allStudentsWithPlz(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }

    @Override
    public Student studentWithId(Long id) throws StudentNotFound {
        Optional<Student> optStudent = this.studentJPARepo.findById(id);
        if(optStudent.isPresent()){
            return optStudent.get();
        } else {
            throw new StudentNotFound("Student mit der ID " + id + " nicht gefunden!");
        }
    }

    @Override
    public Student deleteStudent(Long id) throws StudentNotFound {
        Student studentFromDatabase = this.studentWithId(id);
        this.studentJPARepo.deleteById(studentFromDatabase.getId());
        return studentFromDatabase;
    }
}