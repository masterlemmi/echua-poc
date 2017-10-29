package com.bdo.esoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bdo.esoa.dao.EsoaFileDao;
import com.bdo.esoa.model.EsoaFile;


@Service("esoaService")
@Transactional
public class EsoaFileService {
	
	@Autowired
	EsoaFileDao esoaFileDao;
	
	public EsoaFile findById(int id) {
		return esoaFileDao.findById(id);
	}
	
	public EsoaFile findByName(String name) {
		return esoaFileDao.findByName(name);
	}

	public void saveEsoaFile(EsoaFile esoaFile) {
		esoaFileDao.saveEsoaFile(esoaFile);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateEsoaFile(EsoaFile esoaFile) {
		EsoaFile entity = esoaFileDao.findById(esoaFile.getId());
		if(entity!=null){
			entity.setName(esoaFile.getName());
			entity.setFile(esoaFile.getFile());
		}
	}

	public void deleteEsoaFile(EsoaFile esoaFile) {
		esoaFileDao.deleteEsoaFile(esoaFile);
	}
	

}
