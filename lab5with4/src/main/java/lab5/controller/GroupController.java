package lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab5.entity.Group;
import lab5.service.GroupService;

@RestController
@RequestMapping("api/group")
public class GroupController extends AbstractController<Group> {

	@Autowired
	private GroupService service;

	@Override
	public GroupService getService() {
		return service;
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Group> getStudentsBySurname(@PathVariable String name) {
		Group group = service.readByName(name);
		if (group == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(group, headers, HttpStatus.OK);
	}

}
