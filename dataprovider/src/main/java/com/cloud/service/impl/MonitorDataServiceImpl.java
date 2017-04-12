package com.cloud.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.model.MonitorData;
import com.cloud.repositories.MonitorDataRepository;
import com.cloud.service.MonitorDataService;


@Service
public class MonitorDataServiceImpl implements MonitorDataService{

	@Resource 
	private MonitorDataRepository monitorDataRepository;
	
	public List<MonitorData> getData(String instance_id) {
		if ("".equals(instance_id)){
			return (List<MonitorData>) monitorDataRepository.findAll();
		}else{
			return (List<MonitorData>) monitorDataRepository.findAllByMonitorObjId(instance_id);
		}
		
		
	}

	@Override
	public List<MonitorData> insertData(int count) {
		
		final String[][] type = {{"cpu_util","%"},{"memory.usage","%"},{"disk.usage","%"},
				{"outer.network.incoming.bytes","MB"},{"inner.network.outgoing.bytes","MB"}};
		
		List list = new ArrayList<>();
		MonitorData data;
		
		for(int i = 0; i < count; i++){
			java.util.Random random=new java.util.Random();
			int randomInt = random.nextInt(type.length);
			data = new MonitorData();
			data.setDataType(type[randomInt][0]);
			data.setDataUnit(type[randomInt][1]);
			data.setDataValue(random.nextInt(100));
			data.setCreatedAt(new Date());
			data.setDataTime(System.currentTimeMillis());
			data.setMonitorObjId(""+random.nextInt(10));
			list.add(data);
			monitorDataRepository.save(data);
			
		}
		return list;
	}

	@Override
	public String deleteData() {
		// TODO Auto-generated method stub
		monitorDataRepository.deleteAll();
		return "{}";
	}
	
	

}
