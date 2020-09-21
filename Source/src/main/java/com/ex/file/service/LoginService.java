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
import com.ex.file.dao.LoginSessionRepository;
import com.ex.file.dto.DeskDto;
import com.ex.file.entity.Department;
import com.ex.file.entity.Desk;
import com.ex.file.entity.LoginSession;
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
	
	@Autowired
	private LoginSessionRepository loginSessionRepository; 
	
	public DeskDto deskLogin(Integer departmentId, Integer deskId, String password) {
		DeskDto deskDto=new DeskDto();
		Desk desk = deskRepository.findByDepartmentIdAndDeskIdAndPassword(departmentId, deskId, password);
		HttpSession session;
		HttpServletRequest req= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		if(desk!=null) {
			/*if((session=req.getSession(false))!=null) {
				System.out.println("Logout");
				System.out.println("Logout session id="+session.getId());
				session.invalidate();
			}else {
				System.out.println("Login In");
				session= req.getSession(true);
				session.setAttribute("desk", desk);
				System.out.println("Login In Sesion Id="+session.getId());
				session.setMaxInactiveInterval(7*60);
				deskDto.setSessionId(session.getId());
				deskDto.setDesk(desk);
			}*/
			System.out.println("Login In");
			session= req.getSession(true);
			session.setAttribute("desk", desk);
			System.out.println("Login In Sesion Id="+session.getId());
			session.setMaxInactiveInterval(7*60);
			deskDto.setSessionId(session.getId());
			deskDto.setDesk(desk);
			com.ex.file.entity.LoginSession loginSession = new LoginSession();
			loginSession.setDeskId(desk.getDeskId());
			loginSession.setSessionId(session.getId());
			loginSessionRepository.save(loginSession);
		}else {
			return null;
		}
		return deskDto;
	}
	
	public void deskLogout(String sessionId) {
		HttpSession oldsession;
		HttpServletRequest req= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		oldsession=req.getSession(false);
		LoginSession loginSession = loginSessionRepository.findBySessionId(sessionId);
		if(loginSession!=null){
			System.out.println("Logout");
			System.out.println("Logout session id="+oldsession.getId());
			oldsession.invalidate();
			loginSessionRepository.delete(loginSession);
		}
	}
	
	public static Integer LoginSession(String sessionId) {
		Integer deskId = null;
		HttpSession oldsession;
		HttpServletRequest req= ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		oldsession=req.getSession(false);
		String oldSessionId=oldsession.getId();
		if(oldSessionId.equals(sessionId)){
			deskId=((Desk)oldsession.getAttribute("desk")).getDeskId();
		}
		return deskId;
	}
	
	public Desk saveDesk(Desk desk) {
		return deskRepository.save(desk);	
	}
	
	public Desk updateDesk(Desk desk,String sessionId) {
		System.out.println("Update api Session Id = "+ sessionId);
		//Integer dId=LoginSession(sessionId);
		LoginSession loginSession = loginSessionRepository.findBySessionId(sessionId);
		Integer deskId=loginSession.getDeskId();
		Desk deskObject = deskRepository.findByDeskId(deskId);
		System.out.println("UpdateDesk API DeskId="+deskId);
		if(deskObject!=null) {
			deskObject.setDepartment(deskObject.getDepartment());
			deskObject.setDesignation(desk.getDesignation());
			deskObject.setDeskHolder(desk.getDeskHolder());
			deskObject.setDeskName(desk.getDeskName());
			deskObject.setMobileNumber(desk.getMobileNumber());
			deskObject.setPassword(desk.getPassword());
			deskRepository.save(deskObject);
		}
		return deskObject;
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