package com.capgemini.omts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.omts.entity.ScreenBean;
import com.capgemini.omts.service.ScreenServiceImpl;

@RestController
@RequestMapping("/screen")
public class ScreenRestController {
	@Autowired
	ScreenServiceImpl screenService;
	
	@PostMapping("/add")
	
		
		public  ResponseEntity<Boolean> addScreen(@Valid @RequestBody ScreenBean bean) {
			ScreenBean screenbean = screenService.addScreen(bean);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			System.out.println("response entity=" + responseEntity);
			return responseEntity;
		
	         }
	@DeleteMapping("/delete/{screenId}")
	public ResponseEntity<String>  deleteScreenById(@PathVariable int screenId) {
		try {
			screenService.deleteScreen(screenId);
		ResponseEntity<String> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
		}
		catch(Exception e) {
			
			System.err.println("Invalid ScreenId");
			return new ResponseEntity("Invalid Screen Id",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getall")
	public  ResponseEntity<List<ScreenBean>> getallScreens() {

		List<ScreenBean> bean = screenService.getAllScreens();
		return new ResponseEntity<List<ScreenBean>>(bean,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{screenId}")
	public ResponseEntity<ScreenBean> getScreen(@PathVariable int screenId) {

		
		  try {
			  ScreenBean bean= screenService.getScreenById(screenId);
		   ResponseEntity<ScreenBean> responseEntity = new ResponseEntity(bean,HttpStatus.OK); 
		   System.out.println("response entity=" + responseEntity);
		    return responseEntity; 
		  } 
		  catch(Exception e) 
		  {
		  
		  System.err.println("Invalid ScreenId"); 
		  return new ResponseEntity("Invalid Screen Id",HttpStatus.BAD_REQUEST);
	
	

}
	}
}
