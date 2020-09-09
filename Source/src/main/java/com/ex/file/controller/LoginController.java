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

import com.ex.file.service.LoginService;
import com.ex.file.dto.ResultModel;
import com.ex.file.entity.Desk;

@RestController 
@RequestMapping(value="/deskLogin")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login/{departmentName}/{deskName}/{password}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel>  login(@PathVariable("departmentName") String departmentName, @PathVariable("deskName") String deskName , @PathVariable("password") String password){
		ResultModel resultModel = new ResultModel();
		try{
			Desk response=loginService.login(departmentName, deskName, password);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveDesk", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel>  donerRegistration(@RequestBody Desk desk){
		ResultModel resultModel = new ResultModel();
		try{
			Desk response=loginService.saveDesk(desk);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
}
