package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.FourUpBean;
import com.nextel.dashboard.dao.Admin4UPDAO;


@Service
@Transactional(readOnly=true)
public class Admin4UPServiceImpl implements Admin4UPService {

	@Autowired
	private Admin4UPDAO admin4UPDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<FourUpBean> listType = null;
	private List<FourUpBean> list4UpData = null;
		
	
	/*
	 * 
	 * */
	public int getLastId4up(){
		int lastId4up = 0;
		
		lastId4up = admin4UPDAO.getLastId4up();
				
		return lastId4up;
	}
	
	
	/*
	 * 
	 * */
	public boolean create4up(FourUpBean pmb){
		boolean created = false;
		
		created = admin4UPDAO.create4up(pmb);
				
		return created;
	}
	
	
	/*
	 * 
	 * */
	public List<FourUpBean> getListTypes(){
		listType = admin4UPDAO.getListTypes();
				
		return listType;
	}


	/*
	 * 
	 * */
	public boolean update4up(FourUpBean pmb){
		boolean pmUpdated = admin4UPDAO.update4up(pmb);
		
		return pmUpdated;
	}
	
	
	/*
	 * 
	 * */
	public boolean delete4up(String id4ups){
		boolean pmDeleted = admin4UPDAO.delete4up(id4ups);
		
		return pmDeleted;
	}
	
	
	/*
	 * 
	 * */
	public List<FourUpBean> getListDescriptions(String idAuth){
		list4UpData = admin4UPDAO.getListDescriptions(idAuth);
		
		return list4UpData;
	}
	
	
	/*
	 * 
	 * */
	public List<FourUpBean> get4upsByDesc(FourUpBean fub){
		list4UpData = admin4UPDAO.get4upsByDesc(fub);
		
		return list4UpData;
	}
	
}
