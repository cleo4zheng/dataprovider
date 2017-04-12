package com.cloud.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cloud.model.MonitorData;

public interface MonitorDataRepository extends CrudRepository<MonitorData, Long> {
	
	public List findAllByMonitorObjId(String instance_id);

}
