package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.PMBean;

public interface AdminPMService {
	
	public List<PMBean> getDataPMByIdPM(String idPM);
	
	public boolean createPM(PMBean pmb);
	
	public List<PMBean> getListPM();
	
	public List<PMBean> getListPMEnabled();
	
	public boolean updatePM(PMBean pmb);
	
	public boolean deletePM(String idPM);
	
}
