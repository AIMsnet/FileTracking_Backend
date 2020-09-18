package com.ex.file.controller;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	public final static Logger logger= Logger.getLogger(FileEntryController.class);
	
	@Autowired
	private FileEntryService fileEntryService;
	
	@RequestMapping(value="/getFileEntryByDeskId", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getFileEntryByDeskId(){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting FileEntry Data By DeskId......!");
		try{
			List<FileEntry> response=fileEntryService.getFileEntryByDeskId();
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting FileEntry Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting FileEntry Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveUpdateFileEntry", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveUpdateFileEntry(@RequestBody FileEntry fileEntry){
		ResultModel resultModel = new ResultModel();
		logger.info("Saving-Updating FileEntry Data......!");
		try{
			FileEntry response=fileEntryService.saveUpdateFileEntry(fileEntry);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Save-Update FileEntry Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("FileEntry Data Saving-Updating Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	

	@RequestMapping(value="/getFileEntryByFileStringId/{fileStringId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getFileEntryByFileStringId(@PathVariable("fileStringId") String fileStringId){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting FileEntry Data By FileStringId......!");
		try{
			FileEntry response=fileEntryService.getFileEntryByFilestringId(fileStringId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting FileEntry Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting FileEntry Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
}
