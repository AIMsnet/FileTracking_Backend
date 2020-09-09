package com.ex.file.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	public List<Department> findAll();

}
