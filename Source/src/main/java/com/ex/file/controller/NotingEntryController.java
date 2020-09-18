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
import com.ex.file.entity.NotingEntry;
import com.ex.file.dto.NotingEntryDto;
import com.ex.file.dto.ResultModel;
import com.ex.file.entity.NotingEntryForwarded;
import com.ex.file.service.NotingEntryService;

@RestController 
@RequestMapping(value="/notingEntry")
public class NotingEntryController {
	
	public final static Logger logger= Logger.getLogger(NotingEntryController.class);

	@Autowired
	private NotingEntryService notingEntryService;
	
	@RequestMapping(value="/getNotingEntryByDeskId/{deskId}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getNotingEntryByDeskId(@PathVariable("deskId") Integer deskId){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting NotingEntry Data By DeskId......!");
		try{
			List<NotingEntryForwarded> response=notingEntryService.getNotingEntryByDeskId(deskId);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting NotingEntry Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting NotingEntry Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value="/saveNotingEntry", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveNotingEntry(@RequestBody NotingEntryDto notingEntryDto){
		ResultModel resultModel = new ResultModel();
		logger.info("Saving NotingEntry Data......!");
		try{
			NotingEntryForwarded response=notingEntryService.saveNotingEntry(notingEntryDto);
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
	
	@RequestMapping(value="/forwardedNotingEntry", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> forwardedNotingEntry(@RequestBody NotingEntryDto notingEntryDto){
		ResultModel resultModel = new ResultModel();
		logger.info("Forwarding NotingEntry Data......!");
		try{
			NotingEntry response=notingEntryService.forwardedNotingEntry(notingEntryDto);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Forward Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Data Forwarding Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
	
	@RequestMapping(value="/getNotingEntryByTipniStatus/{tipniStatus}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getNotingEntryByTipniStatus(@PathVariable("tipniStatus") String tipniStatus){
		ResultModel resultModel = new ResultModel();
		logger.info("Getting NotingEntry Data By TipaniStatus......!");
		try{
			List<NotingEntryForwarded> response=notingEntryService.getNotingEntryByTipniStatus(tipniStatus);
			resultModel.setData(response);
			resultModel.setMessage("Success");
			logger.info("Getting NotingEntry Data Successfully.....!");
		}catch(Exception e){
			resultModel.setMessage("Error");
			logger.info("Getting NotingEntry Data Failed......!");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
	return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
}
