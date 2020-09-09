package com.ex.file.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.file.dao.DeskRepository;
import com.ex.file.entity.Desk;

@Service
@Transactional
public class LoginService {

	@Autowired
	private DeskRepository deskRepository;
	
	public Desk deskLogin(String departmentName, String deskName, String password) {
		return deskRepository.findByDepartmentNameAndDeskNameAndPassword(departmentName, deskName, password);
	}
	
	public Desk saveUpdateDesk(Desk desk) {
		return deskRepository.save(desk);
	}
	
}
