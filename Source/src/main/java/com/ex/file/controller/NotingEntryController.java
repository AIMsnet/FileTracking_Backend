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
import com.ex.file.entity.NotingEntry;
import com.ex.file.dto.NotingEntryDto;
import com.ex.file.dto.ResultModel;
import com.ex.file.entity.NotingEntryForwarded;
import com.ex.file.service.NotingEntryService;

@RestController 
@RequestMapping(value="/notingEntry")
public class NotingEntryController {

	@Autowired
	private NotingEntryService notingEntryService;
	
	@RequestMapping(value="/getNotingEntryByDeskId/{deskId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getNotingEntryByDeskId(@PathVariable("deskId") Integer deskId){
		ResultModel resultModel = new ResultModel();
		try{
			List<NotingEntryForwarded> response=notingEntryService.getNotingEntryByDeskId(deskId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveNotingEntry", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveNotingEntry(@RequestBody NotingEntryDto notingEntryDto){
		ResultModel resultModel = new ResultModel();
		try{
			NotingEntryForwarded response=notingEntryService.saveNotingEntry(notingEntryDto);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/forwardedNotingEntry", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> forwardedNotingEntry(@RequestBody NotingEntryDto notingEntryDto){
		ResultModel resultModel = new ResultModel();
		try{
			NotingEntry response=notingEntryService.forwardedNotingEntry(notingEntryDto);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		}catch(Exception e){
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
}
