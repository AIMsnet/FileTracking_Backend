package com.ex.file.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.Desk;

@Repository
public interface DeskRepository extends CrudRepository<Desk, Integer>{
	
	@Query("select m from Desk where m.department.departmentName=:departmentName and m.deskName=:deskName and m.password=:password")
	public Desk findByDepartmentNameAndDeskNameAndPassword(String departmentName, String deskName, String password);
}
