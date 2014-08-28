package com.nextel.dashboard.service;

import java.util.List;

import com.nextel.dashboard.bean.CurrentTargetBean;

public interface CurrentTargetService {
	public List<CurrentTargetBean> getCurrentTarget();
	
	public List<CurrentTargetBean> getCurrentTargetFilterByProject(String project);
	
}
