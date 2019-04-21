package lab5.service;

import lab5.entity.Faculty;

public interface FacultyService extends Service<Faculty> {

	Faculty readByName(String name);

	Faculty readByphone(String name);

}
