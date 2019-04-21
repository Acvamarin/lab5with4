package lab5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab5.entity.Faculty;
import lab5.repository.FacultyRepository;
import lab5.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository repository;

	@Override
	public Faculty read(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Faculty> read() {
		return repository.findAll();
	}

	@Override
	public void save(Faculty entity) {
		repository.save(entity);

	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public Faculty readByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Faculty readByphone(String phone) {
		return repository.findByphone(phone);
	}

}