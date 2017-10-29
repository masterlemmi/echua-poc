package com.bdo.esoa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bdo.esoa.model.EsoaFile;
import com.bdo.esoa.service.EsoaFileService;



@RestController
public class EsoaFileController {
	
	@Autowired 
	EsoaFileService esoaFileService;
	
	

	@RequestMapping(value = "/api/saveFile", method = RequestMethod.GET)
	public ResponseEntity<String> saveFileToDb() {
		File file = new File("/home/lemzki/Downloads/apple.jpg");
        byte[] bFile = new byte[(int) file.length()];
        
        try {
	        FileInputStream fileInputStream = new FileInputStream(file);
	        //convert file into array of bytes
	        fileInputStream.read(bFile);
	        fileInputStream.close();
        } catch (Exception e) {
	        e.printStackTrace();
        }
        
        EsoaFile esoaFile = new EsoaFile();
        esoaFile.setName("APPLE");
        esoaFile.setFile(bFile);
        
        esoaFileService.saveEsoaFile(esoaFile);
        
		
		return new ResponseEntity<String>("DONE save", HttpStatus.OK);
	}

	
	@RequestMapping(value = "/api/getFile", method = RequestMethod.GET)
	public ResponseEntity<String> getFileFromDb() {
		
		EsoaFile  esoaFile = esoaFileService.findByName("APPLE");
		
        byte[] esoaByte = esoaFile.getFile();
        
        try{
        	FileOutputStream fos = new FileOutputStream("/home/lemzki/Downloads/applefROMdb.jpg"); 
            fos.write(esoaByte);
            fos.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
		
		return new ResponseEntity<String>("DONE", HttpStatus.OK);
	}
	
}
