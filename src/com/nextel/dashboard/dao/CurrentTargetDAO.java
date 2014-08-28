package com.nextel.dashboard.dao;

import java.util.List;

import com.nextel.dashboard.bean.CurrentTargetBean;

public interface CurrentTargetDAO {

	public List<CurrentTargetBean> getCurrentTarget();
	
	public List<CurrentTargetBean> getCurrentTargetFilterByProject(String project);
	
}
