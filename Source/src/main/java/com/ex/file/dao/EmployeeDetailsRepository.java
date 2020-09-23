package com.ex.file.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ex.file.entity.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends CrudRepository<EmployeeDetails, Integer>{
	
	@Query("select m from EmployeeDetails m where m.desk.deskId=:deskId")
	public EmployeeDetails findByDeskId(Integer deskId);
	
	@Query("select m from EmployeeDetails m where m.department.departmentId=:departmentId")
	public List<EmployeeDetails> findByDepartmentId(Integer departmentId);
}
