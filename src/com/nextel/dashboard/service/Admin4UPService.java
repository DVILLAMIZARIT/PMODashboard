package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.FourUpBean;

public interface Admin4UPService {
	
	public int getLastId4up();
	
	public boolean create4up(FourUpBean fub);
	
	public List<FourUpBean> getListTypes();
	
	public boolean update4up(FourUpBean fub);
	
	public boolean delete4up(String id4ups);
	
	public List<FourUpBean> getListDescriptions(String idAuth);
	
	public List<FourUpBean> get4upsByDesc(FourUpBean fub);
	
}