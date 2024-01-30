package at.itkollegimst.studentenverwaltung.services;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNotFound;

import java.util.List;

public interface StudentsService {
    List<Student> allStudents();
    Student insertStudent(Student student);
    Student updateStudent(Student student) throws StudentNotFound;
    Student studentWithId(Long id) throws StudentNotFound;
    List<Student> studentsWithPlz(String plz);
    Student deleteStudent(Long id) throws StudentNotFound;
}