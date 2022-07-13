package com.csm.demo.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.csm.demo.Entity.PackageEntity;

public class HelperClass {

	//check file is excel type
	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			//System.out.println("Checked Sucessfully");
			return true;
		}else {
			return false;
		}
	}
	//convert Excel to database
	@SuppressWarnings("resource")
	public static List<PackageEntity> convertToList(InputStream is){
		
		List<PackageEntity> list=new ArrayList<>();
	    try {
	    	XSSFWorkbook workbook= new XSSFWorkbook(is);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int rownum=0;
			long count=1;
			Iterator<Row> iterator=sheet.iterator();
			while(iterator.hasNext()){
				Row row=iterator.next();
				if(rownum==0) {
					rownum++;
					continue;
				}
			Iterator<Cell> cell=row.iterator();
			int cid=0;
			PackageEntity p=new PackageEntity();
			p.setPack_id(count); //Set primary key,if primary key is not set in the xls file
			while(cell.hasNext()) {
				
				Cell next=cell.next();
				
				switch (cid) {
				
				case 0:
					p.setPackages(next.getStringCellValue());
                    break;
				case 1:
					p.setPackageName(next.getStringCellValue());
					break;
				case 2:
					p.setPackageId(next.getStringCellValue());
					break;
				
				default:
					break;
				}
				cid++;
			}

			count++;
			list.add(p);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return list;
	}
}
