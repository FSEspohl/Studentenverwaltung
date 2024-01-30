package at.itkollegimst.studentenverwaltung.services;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNotFound;
import at.itkollegimst.studentenverwaltung.repositories.DatabaseAccessStudents;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServiceImplementation implements StudentsService {

    private final DatabaseAccessStudents databaseAccessStudents;

    public StudentsServiceImplementation(DatabaseAccessStudents databaseAccessStudents){
        this.databaseAccessStudents = databaseAccessStudents;
    }

    @Override
    public List<Student> allStudents() {
        return databaseAccessStudents.allStudents();
    }

    @Override
    public Student insertStudent(Student student) {
        return databaseAccessStudents.insertStudent(student);
    }

    @Override
    public Student updateStudent(Student student) throws StudentNotFound {
        Student studentAusDb = databaseAccessStudents.studentWithId(student.getId());
        studentAusDb.setName(student.getName());
        studentAusDb.setPlz(student.getPlz());
        return databaseAccessStudents.insertStudent(studentAusDb);
    }

    @Override
    public Student studentWithId(Long id) throws StudentNotFound {
        return databaseAccessStudents.studentWithId(id);
    }

    @Override
    public List<Student> studentsWithPlz(String plz) {
        return databaseAccessStudents.allStudentsWithPlz(plz);
    }

    @Override
    public Student deleteStudent(Long id) throws StudentNotFound {
        return databaseAccessStudents.deleteStudent(id);
    }
}