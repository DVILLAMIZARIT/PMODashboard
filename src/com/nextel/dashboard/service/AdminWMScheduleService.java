package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.WMScheduleBean;

public interface AdminWMScheduleService {
	
	public int getLastIdWM();
	
	public boolean createWMSchedule(WMScheduleBean fub);
	
	public boolean updateWMSchedule(WMScheduleBean fub);
	
	public boolean deleteWMSchedule(String idWMSchedule);
	
	public List<WMScheduleBean> getListDescriptions(String idAuth);
	
	public List<WMScheduleBean> getWMScheduleByDesc(WMScheduleBean fub);
	
}
