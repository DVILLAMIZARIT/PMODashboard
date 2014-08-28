package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.WMScheduleBean;

public interface AdminWMScheduleDAO {
	
	public int getLastIdWM();
	
	public boolean createWMSchedule(WMScheduleBean orb);
	
	public boolean updateWMSchedule(WMScheduleBean orb);
	
	public boolean deleteWMSchedule(String idWM);
	
	public List<WMScheduleBean> getListDescriptions(String idAuth);
	
	public List<WMScheduleBean> getWMScheduleByDesc(WMScheduleBean orb);
	
}
