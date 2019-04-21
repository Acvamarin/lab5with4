package lab5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab5.entity.Student;
import lab5.service.StudentService;

@RestController
@RequestMapping("api/student")
public class StudentController extends AbstractController<Student> {

	@Autowired
	private StudentService service;

	@Override
	public StudentService getService() {
		return service;
	}

	@GetMapping("/group/{id}")
	public ResponseEntity<List<Student>> getStudentsByGroup(@PathVariable long id) {
		List<Student> students = service.readByGroupId(id);
		if (students.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(students, headers, HttpStatus.OK);
	}

	@GetMapping("/surname/{surname}")
	public ResponseEntity<List<Student>> getStudentsBySurname(@PathVariable String surname) {
		List<Student> students = service.readBySurname(surname);
		if (students.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(students, headers, HttpStatus.OK);
	}

}
