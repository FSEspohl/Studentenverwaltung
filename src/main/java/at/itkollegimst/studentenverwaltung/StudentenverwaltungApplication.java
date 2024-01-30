package at.itkollegimst.studentenverwaltung;

import at.itkollegimst.studentenverwaltung.repositories.DatabaseAccessStudents;
import at.itkollegimst.studentenverwaltung.domain.Student;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class StudentenverwaltungApplication implements ApplicationRunner {

	@Autowired
	DatabaseAccessStudents databaseAccessStudents;

	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		this.databaseAccessStudents.insertStudent(new Student("Stefan Pohl","6432"));
		this.databaseAccessStudents.insertStudent(new Student("Gudrun Morgenscheid","6040"));
		this.databaseAccessStudents.insertStudent(new Student("Lukas Zifreind","5120"));
	}
}
