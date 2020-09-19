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
import com.ex.file.entity.FileType;
import org.apache.log4j.Logger;

@RestController 
@RequestMapping(value="/login")
public class LoginController {
	
	public final static Logger logger= Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/deskLogin/{departmentId}/{deskId}/{password}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> deskLogin(@PathVariable("departmentId") Integer departmentId, @PathVariable("deskId") Integer deskId , @PathVariable("password") String password){
		ResultModel resultModel = new ResultModel();
		logger.info("Authenticating...........");
		try{
			Desk response=loginService.deskLogin(departmentId, deskId, password);
			if(response!=null) {
				resultModel.setData(response);
				resultModel.setMessage("Success");
				logger.info("Authenticate Successfully.......");
			}else {
				resultModel.setMessage("Failed");
				logger.info("Authenticate Failed.......");
			}		
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Error Occure"+e);
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveDesk", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveDesk(@RequestBody Desk desk){
		ResultModel resultModel = new ResultModel();
		logger.info("Saving Desk Data......!");
		try{
			Desk response=loginService.saveDesk(desk);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Save Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Data Saving Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/updateDesk", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> updateDesk(@RequestBody Desk desk){
		ResultModel resultModel = new ResultModel();
		logger.info("Updating Desk Data......!");
		try{
			Desk response=loginService.updateDesk(desk);
			if(response!=null) {
				resultModel.setData(response);
				resultModel.setMessage("Success");
				logger.info("Update Desk Data Successfully.....!");
			}else {
				resultModel.setMessage("Please Login your Account.....!");
				logger.info("Please Login your Account.....!");
			}
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Desk Data Updating Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getDeskByDepartment/{departmentId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getDeskByDepartment(@PathVariable("departmentId") Integer departmentId){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting Desk Data By DepartmentId......!");
		try{
			List<Desk> response=loginService.getDeskByDepartment(departmentId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting Desk Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting Desk Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllDepartment", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getAllDepartment(){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting Department Data......!");
		try{
			List<Department> response=loginService.getAllDepartment();
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting Department Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting Department Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDepartmentByDepartmentId/{departmentId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getDepartmentByDepartmentId(@PathVariable("departmentId") Integer departmentId){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting Department Data By DepartmentId......!");
		try{
			Department response=loginService.getDepartmentByDepartmentId(departmentId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting Department Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting Department Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUpdateDepartment", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveUpdateDepartment(@RequestBody Department department){
		ResultModel resultModel = new ResultModel();
		logger.info("Saving-Updating Department Data......!");
		try{
			Department response=loginService.saveUpdateDepartment(department);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Save-Update Department Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Department Data Saving-Updating Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getDeskByDeskId/{deskId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getDeskByDeskId(@PathVariable("deskId") Integer deskId){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting Desk Data By DeskId......!");
		try{
			Desk response=loginService.getDeskByDeskId(deskId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting Desk Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting Desk Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllFileType", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getAllFileType(){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting FileType Data......!");
		try{
			List<FileType> response=loginService.getAllFileType();
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting FileType Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting FileType Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getFileTypeByFileTypeId/{fileTypeId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getFileTypeByFileTypeId(@PathVariable("fileTypeId") Integer fileTypeId){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting FileType Data By FileTypeId......!");
		try{
			FileType response=loginService.getFileTypeByFileTypeId(fileTypeId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting FileType Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting FileType Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUpdateFileType", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveUpdateFileType(@RequestBody FileType fileType){
		ResultModel resultModel = new ResultModel();
		logger.info("Saving-Updating FileType Data......!");
		try{
			FileType response=loginService.saveUpdateFileType(fileType);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Save-Update FileType Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("FileType Data Saving-Updating Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
}
