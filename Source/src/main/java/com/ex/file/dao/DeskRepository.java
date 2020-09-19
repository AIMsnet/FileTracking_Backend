package com.ex.file.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.ex.file.entity.Desk;

@Repository
public interface DeskRepository extends CrudRepository<Desk, Integer>{
	
	//@Query("select m from Desk m where m.department.departmentName=:departmentName and m.deskName=:deskName and m.password=:password")
	//public Desk findByDepartmentNameAndDeskNameAndPassword(String departmentName, String deskName, String password);
	
	@Query("select m from Desk m where m.department.departmentId=:departmentId and m.deskId=:deskId and m.password=:password")
	public Desk findByDepartmentIdAndDeskIdAndPassword(Integer departmentId, Integer deskId, String password);
	
	@Query("select m from Desk m where m.department.departmentId=:departmentId")
	public List<Desk> findByDepartmentId(Integer departmentId);
	
	public Desk findByDeskId(Integer deskId);
}
