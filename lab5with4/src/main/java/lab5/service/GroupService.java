package lab5.service;

import lab5.entity.Group;

public interface GroupService extends Service<Group> {

	Group readByName(String name);

}
