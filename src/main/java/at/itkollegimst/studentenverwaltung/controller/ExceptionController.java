package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.exceptions.ExceptionDTO;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNotFound;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidationFailed;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ExceptionDTO> studentNotFound(StudentNotFound studentNotFound) {
        return new ResponseEntity<>(new ExceptionDTO("1000", studentNotFound.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentValidationFailed.class)
    public ResponseEntity<ExceptionDTO> studentValidationFailed(StudentValidationFailed studentValidationFailed) {
        return new ResponseEntity<>(new ExceptionDTO("9000", studentValidationFailed.getMessage()), HttpStatus.BAD_REQUEST);
    }
}