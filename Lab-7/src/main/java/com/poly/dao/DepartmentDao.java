package com.poly.dao;

import java.util.List;

import com.poly.entity.Department;

public interface DepartmentDao {
	List<Department> findAll();

	Department findById(String id);

	void create(Department item);

	void update(Department item);

	void deleteById(String id);
}
