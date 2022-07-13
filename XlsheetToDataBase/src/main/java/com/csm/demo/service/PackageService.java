package com.csm.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csm.demo.Entity.PackageEntity;
import com.csm.demo.Helper.HelperClass;
import com.csm.demo.Repository.PackageRepo;

@Service
public class PackageService {
	
	@Autowired
	private PackageRepo packageRepo;
	
	public void save(MultipartFile file) {
		try {
			List<PackageEntity> products= HelperClass.convertToList(file.getInputStream());
			packageRepo.saveAll(products);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
