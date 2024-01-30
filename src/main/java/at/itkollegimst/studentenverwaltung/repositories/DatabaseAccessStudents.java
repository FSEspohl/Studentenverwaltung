package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNotFound;

import java.util.List;

public interface DatabaseAccessStudents {
    Student insertStudent(Student student);
    List<Student> allStudents();
    List<Student> allStudentsWithPlz(String plz);
    Student studentWithId(Long id) throws StudentNotFound;
    Student deleteStudent(Long id) throws StudentNotFound;
}