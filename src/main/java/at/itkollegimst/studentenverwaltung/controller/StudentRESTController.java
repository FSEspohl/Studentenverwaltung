package at.itkollegimst.studentenverwaltung.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNotFound;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidationFailed;
import at.itkollegimst.studentenverwaltung.services.StudentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@AllArgsConstructor
public class StudentRESTController {

    private StudentsService studentsService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(this.studentsService.allStudents());
    }

    @PostMapping
    public ResponseEntity<Student> insertStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidationFailed {

        String errors = "";
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                errors += "\nValidierungsfehler für Objekt" + error.getObjectName() + " im Feld " +
                        ((FieldError)error).getField() + "mit folgendem Problem: " + error.getDefaultMessage();
            }
            throw new StudentValidationFailed(errors);
        } else {
            return ResponseEntity.ok(this.studentsService.insertStudent(student));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) throws StudentNotFound {
        return ResponseEntity.ok(this.studentsService.deleteStudent(id));
    }

    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> allStudentsWithPlz(@PathVariable String plz) {
        return ResponseEntity.ok(this.studentsService.studentsWithPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentWithId(@PathVariable Long id) throws StudentNotFound {
        return ResponseEntity.ok(this.studentsService.studentWithId(id));
    }
}