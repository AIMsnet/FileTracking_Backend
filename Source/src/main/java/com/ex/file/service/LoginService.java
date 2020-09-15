package com.ex.file.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.DepartmentRepository;
import com.ex.file.dao.DeskRepository;
import com.ex.file.entity.Department;
import com.ex.file.entity.Desk;

@Service
@Transactional
public class LoginService {

	@Autowired
	private DeskRepository deskRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Desk deskLogin(String departmentName, String deskName, String password) {
		return deskRepository.findByDepartmentNameAndDeskNameAndPassword(departmentName, deskName, password);
	}
	
	public Desk saveUpdateDesk(Desk desk) {
		return deskRepository.save(desk);
	}
	
	public List<Desk> getDeskByDepartment(Integer departmentId){
		return deskRepository.findByDepartmentId(departmentId);
	}
	
	public List<Department> getAllDepartment(){
		return (List<Department>) departmentRepository.findAll();
	}
	
	public Department saveUpdateDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Desk getDeskByDeskId(Integer deskId) {
		return deskRepository.findByDeskId(deskId);
	}
}
