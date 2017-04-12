package com.cloud.service;

import java.util.List;

import com.cloud.model.MonitorData;

public interface MonitorDataService {
	
	public List<MonitorData> getData(String  instance_id);
	public List<MonitorData> insertData(int count);
	public String deleteData();
	

}
