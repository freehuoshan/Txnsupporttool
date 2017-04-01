package query.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import query.service.entity.IhubAuth;
import query.service.entity.Qbms;
import query.service.service.Service;

@RestController
public class Controller {
	
	private static final Logger log = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private Service service;
	
	
	/**
	 * input in browser with invoiceid value
	 * http://localhost:8080/detail?invoiceid=aie84g4u
	 * @param tablename
	 * @param fieldname
	 * @param queryvalue
	 * @return
	 */
	@RequestMapping("/tables")
	public String getData(String tablename, String fieldname , String queryvalue){
		
		if(StringUtils.isEmpty(tablename) || StringUtils.isEmpty(fieldname) 
				|| StringUtils.isEmpty(queryvalue)){
			
			return " tablename, fieldname and/or queryvalue missing ";
		}
		log.info("query table by fieldname");
		List<Map<String, Object>> result = service.queryDataBy(tablename, fieldname, queryvalue);
		
		
		return result.toString();
	}
	
	@RequestMapping("/detail")
	public ResponseEntity<Object> isExistId(String invoiceid){
		
		if("".equals(invoiceid) || invoiceid == null){
			 return ResponseEntity.badRequest().body("{ \"message\": \"Missing invoiceid value\"}"); 
		}
		Map<String, Boolean> exisMap = service.isExistId(invoiceid);
		List<IhubAuth> dataMap =service.getDatasById(invoiceid);
		List<Qbms> qbmsData = service.getQbmsData(invoiceid);
		Map<String, Boolean> existMap = service.getExistMap(invoiceid);
		List<Map<String, Object>> qbmsByClientMap = service.getQbmsByClientId(invoiceid);
		List<Object> resList = new ArrayList<Object>();
		resList.add(exisMap);
		resList.add(dataMap);
		resList.add(qbmsData);
		resList.add(existMap);
		resList.add(qbmsByClientMap);
		log.info("query result :------>" + resList);
		return ResponseEntity.ok(resList);
	}
	
}
