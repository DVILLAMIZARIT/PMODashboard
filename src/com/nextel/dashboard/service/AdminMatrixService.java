package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.MatrixBean;

public interface AdminMatrixService {
	
	public int getIdScalingMatrix();
	
	public boolean createMatrix(MatrixBean mb);
	
	public boolean updateMatrix(MatrixBean mb);
	
	public boolean deleteMatrix(String idScalingMatrix);
	
	public List<MatrixBean> getListNameTeam(String idAuth);
	
	public List<MatrixBean> getMatrixByID(MatrixBean mb);
	
}
