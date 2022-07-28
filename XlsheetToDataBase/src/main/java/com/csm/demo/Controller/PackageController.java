package com.csm.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csm.demo.Helper.HelperClass;
import com.csm.demo.service.PackageService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String check() {
		return "Hello";
		
	}
	
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		
		if(HelperClass.checkExcelFormat(file)) {
			packageService.save(file);
			return ResponseEntity.ok(Map.of("Message","File is Uploaded Successfully into Database"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File Only");
		
	}
	

}
