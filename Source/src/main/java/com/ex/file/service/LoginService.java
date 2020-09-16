package com.ex.file.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ex.file.dao.DepartmentRepository;
import com.ex.file.dao.DeskRepository;
import com.ex.file.dao.FileTypeRepository;
import com.ex.file.entity.Department;
import com.ex.file.entity.Desk;
import com.ex.file.entity.FileType;

@Service
@Transactional
public class LoginService {

	@Autowired
	private DeskRepository deskRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private FileTypeRepository fileTypeRepository;
	
	public Desk deskLogin(String departmentName, String deskName, String password) {
		Desk desk = deskRepository.findByDepartmentNameAndDeskNameAndPassword(departmentName, deskName, password);
		HttpSession session;
		HttpServletRequest req= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		if((session=req.getSession(false))!=null) {
			session.invalidate();
		}
		session= req.getSession(true);
		session.setAttribute("deskId", desk.getDeskId());
		return desk;
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
	
	public Department getDepartmentByDepartmentId(Integer departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
	public Department saveUpdateDepartment(Department department) {
		return departmentRepository.save(department);
	}
	
	public Desk getDeskByDeskId(Integer deskId) {
		return deskRepository.findByDeskId(deskId);
	}
	
	public List<FileType> getAllFileType(){
		return (List<FileType>) fileTypeRepository.findAll();
	}
	
	public FileType getFileTypeByFileTypeId(Integer fileTypeId) {
		return fileTypeRepository.findByFileTypeId(fileTypeId);
	}
	
	public FileType saveUpdateFileType(FileType fileType) {
		return fileTypeRepository.save(fileType);
	}
}
