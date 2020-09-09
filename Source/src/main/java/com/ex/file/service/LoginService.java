package com.ex.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.DeskRepository;
import com.ex.file.entity.Desk;

@Service
public class LoginService {

	@Autowired
	private DeskRepository deskRepository;
	
	public Desk login(String departmentName, String deskName, String password) {
		return deskRepository.findByDepartmentNameAndDeskNameAndPassword(departmentName, deskName, password);
	}
	
	public Desk saveDesk(Desk desk) {
		return deskRepository.save(desk);
	}
	
}
