package com.ex.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.ex.file.service.LoginService;
import com.ex.file.dto.ResultModel;
import com.ex.file.entity.Department;
import com.ex.file.entity.Desk;

@RestController 
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/deskLogin/{departmentName}/{deskName}/{password}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> deskLogin(@PathVariable("departmentName") String departmentName, @PathVariable("deskName") String deskName , @PathVariable("password") String password){
		ResultModel resultModel = new ResultModel();
		try{
			Desk response=loginService.deskLogin(departmentName, deskName, password);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUpdateDesk", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveUpdateDesk(@RequestBody Desk desk){
		ResultModel resultModel = new ResultModel();
		try{
			Desk response=loginService.saveUpdateDesk(desk);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getDeskByDepartment/{departmentId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getDeskByDepartment(@PathVariable("departmentId") Integer departmentId){
		ResultModel resultModel = new ResultModel();
		try{
			List<Desk> response=loginService.getDeskByDepartment(departmentId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllDepartment", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getAllDepartment(){
		ResultModel resultModel = new ResultModel();
		try{
			List<Department> response=loginService.getAllDepartment();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUpdateDepartment", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveUpdateDepartment(@RequestBody Department department){
		ResultModel resultModel = new ResultModel();
		try{
			Department response=loginService.saveUpdateDepartment(department);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}		
}
