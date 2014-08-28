package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.MatrixBean;

public interface AdminMatrixDAO {
	
	public int getIdScalingMatrix();
	
	public boolean createMatrix(MatrixBean mb);
	
	public boolean updateMatrix(MatrixBean mb);
	
	public boolean deleteMatrix(String idMatrix);
	
	public List<MatrixBean> getListNameTeam(String idAuth);
	
	public List<MatrixBean> getMatrixByID(MatrixBean mb);
	
}
