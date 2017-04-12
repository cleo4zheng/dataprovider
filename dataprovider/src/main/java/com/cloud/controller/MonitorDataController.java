package com.cloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.model.MonitorData;
import com.cloud.service.MonitorDataService;


@Controller
@ComponentScan
public class MonitorDataController {
	
	@Resource
	private MonitorDataService monitorDataService;
	
	@ResponseBody
	@RequestMapping(value="/statics",produces="application/json",  method=RequestMethod.GET)
	public List<MonitorData> list(
			@RequestParam(value = "instance_id",defaultValue="") String instance_id){
		return monitorDataService.getData(instance_id);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/statics",produces="application/json",  method=RequestMethod.POST)
	public ResponseEntity generate(@RequestParam(value = "count",defaultValue= "10") String count){
		List list = monitorDataService.insertData(Integer.parseInt(count));
		ResponseEntity<List<MonitorData>> response= new ResponseEntity<>(list, HttpStatus.CREATED);
		return response;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/statics",produces="application/json",  method=RequestMethod.DELETE)
	public ResponseEntity delete(){
		String result = monitorDataService.deleteData();
		ResponseEntity<String> response= new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		return response;
	}

}
