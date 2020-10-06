package com.demo.rest.writer.service;

import java.util.List;

import com.synchrony.dataworks.dto.RecentActivity;
import com.synchrony.dataworks.dto.services.ActivityResponse;

public interface RecentActivityService {
	
	public List<RecentActivity> getRecentActivity();

}
