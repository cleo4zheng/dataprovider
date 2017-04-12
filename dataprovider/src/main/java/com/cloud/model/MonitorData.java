package com.cloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class MonitorData  implements Serializable {
	@Id
    @GeneratedValue
    @JsonSerialize
    private Long id;

    @Column(name="monitor_obj_id")
    @JsonSerialize
    private String monitorObjId;

    @Column(name = "data_time")
    @JsonSerialize
    private Long dataTime;
    
    @Column(name = "data_value")
    @JsonSerialize
    private Integer dataValue;
    
    @Column(name = "data_unit")
    @JsonSerialize
    private String dataUnit;
    
    @Column(name = "data_type")
    @JsonSerialize
    private String dataType;
    
    @Column(name = "created_at")
    @JsonSerialize
    private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonitorObjId() {
		return monitorObjId;
	}

	public void setMonitorObjId(String monitorObjId) {
		this.monitorObjId = monitorObjId;
	}

	public Long getDataTime() {
		return dataTime;
	}

	public void setDataTime(Long dataTime) {
		this.dataTime = dataTime;
	}

	

	public Integer getDataValue() {
		return dataValue;
	}

	public void setDataValue(Integer dataValue) {
		this.dataValue = dataValue;
	}

	public String getDataUnit() {
		return dataUnit;
	}

	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

    
    
	

}
