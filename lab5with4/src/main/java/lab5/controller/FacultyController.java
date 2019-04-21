package lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab5.entity.Faculty;
import lab5.service.FacultyService;

@RestController
@RequestMapping("api/faculty")
public class FacultyController extends AbstractController<Faculty> {

	@Autowired
	private FacultyService service;

	@Override
	public FacultyService getService() {
		return service;
	}

	@GetMapping("/phone/{phone}")
	public ResponseEntity<Faculty> getFacultyByphone(@PathVariable String phone) {
		Faculty faculty = service.readByphone(phone);
		if (faculty == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(faculty, headers, HttpStatus.OK);
	}

}
