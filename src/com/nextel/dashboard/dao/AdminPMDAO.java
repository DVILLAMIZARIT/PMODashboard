package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.PMBean;

public interface AdminPMDAO {
	
	public List<PMBean> getDataPMByIdPM(String idPM);
	
	public boolean createPM(PMBean pb);
	
	public List<PMBean> getListPM();
	
	public List<PMBean> getListPMEnabled();
	
	public boolean updatePM(PMBean pmb);
	
	public boolean deletePM(String idPM);
}
