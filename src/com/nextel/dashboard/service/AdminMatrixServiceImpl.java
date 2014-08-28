package com.nextel.dashboard.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextel.dashboard.bean.MatrixBean;
import com.nextel.dashboard.dao.AdminMatrixDAO;


@Service
@Transactional(readOnly=true)
public class AdminMatrixServiceImpl implements AdminMatrixService {

	@Autowired
	private AdminMatrixDAO adminMatrixDAO;
	
	/**
     * Variable del logger
     */
    private Logger log = Logger.getLogger(this.getClass());
	private List<MatrixBean> listMatrixData = null;
		
	
	/*
	 * 
	 * */
	public int getIdScalingMatrix(){
		int lastIdScalingMatrix = 0;
		
		lastIdScalingMatrix = adminMatrixDAO.getIdScalingMatrix();
				
		return lastIdScalingMatrix;
	}
	
	
	/*
	 * 
	 * */
	public boolean createMatrix(MatrixBean mb){
		boolean created = false;
		
		created = adminMatrixDAO.createMatrix(mb);
				
		return created;
	}


	/*
	 * 
	 * */
	public boolean updateMatrix(MatrixBean mb){
		boolean updated = false;
		
		updated = adminMatrixDAO.updateMatrix(mb);
		
		return updated;
	}
	
	
	/*
	 * 
	 * */
	public boolean deleteMatrix(String idScalingMatrix){
		boolean deleted = false;
		
		deleted = adminMatrixDAO.deleteMatrix(idScalingMatrix);
		
		return deleted;
	}
	
	
	/*
	 * 
	 * */
	public List<MatrixBean> getListNameTeam(String idAuth){
		listMatrixData = adminMatrixDAO.getListNameTeam(idAuth);
		
		return listMatrixData;
	}
	
	
	/*
	 * 
	 * */
	public List<MatrixBean> getMatrixByID(MatrixBean mb){
		listMatrixData = adminMatrixDAO.getMatrixByID(mb);
		
		return listMatrixData;
	}
	
}
