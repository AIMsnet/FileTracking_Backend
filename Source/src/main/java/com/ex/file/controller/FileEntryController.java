package com.ex.file.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.file.dto.ResultModel;
import com.ex.file.entity.FileEntry;
import com.ex.file.service.FileEntryService;

@RestController 
@RequestMapping(value="/fileEntry")
public class FileEntryController {
	
	@Autowired
	private FileEntryService fileEntryService;
	
	@RequestMapping(value="/getFileEntryByDeskId/{deskId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getFileEntryByDeskId(@PathVariable("deskId") Integer deskId){
		ResultModel resultModel = new ResultModel();
		try{
			List<FileEntry> response=fileEntryService.getFileEntryByDeskId(deskId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUpdateFileEntry", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveUpdateFileEntry(@RequestBody FileEntry fileEntry){
		ResultModel resultModel = new ResultModel();
		try{
			FileEntry response=fileEntryService.saveUpdateFileEntry(fileEntry);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	

}
