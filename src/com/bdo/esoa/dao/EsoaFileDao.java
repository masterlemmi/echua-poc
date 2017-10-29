package com.bdo.esoa.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdo.esoa.model.EsoaFile;

@Repository("esoaFileDao")
public class EsoaFileDao extends AbstractDao<Integer, EsoaFile>  {
	
	
	public EsoaFile findById(int id) {
		return getByKey(id);
	}
	
	public EsoaFile findByName(String name) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("name", name));
		return (EsoaFile) criteria.uniqueResult();
	}

	public void saveEsoaFile(EsoaFile esoaFile) {
		persist(esoaFile);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateEsoaFile(EsoaFile esoaFile) {
		
	}

	public void deleteEsoaFile(EsoaFile esoaFile) {
		delete(esoaFile);
	}

}
