package query.service.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;

import query.service.dao.Dao;
import query.service.entity.IhubAuth;
import query.service.entity.Qbms;

@org.springframework.stereotype.Service
public class Service {

	private final static Logger log = LoggerFactory.getLogger(Service.class);
	
	@Autowired
	private Dao dao;
	
	public List<Map<String, Object>> queryDataBy(String tableName , String fieldName , 
			Object queryValue){
		log.info("begin query");
		List<Map<String, Object>> queryResult = dao.findData(tableName, fieldName, queryValue);
		log.info("query end\n query result-------->:\n\n"+queryResult+"\n\n<--------------------");
		return queryResult;
	}

	public Map<String, Boolean> isExistId(String invoiceid) {
		String tableName = null;
		String fieldName = "INVOICE_NUMBER";
		String fieldValue = invoiceid;
		//check from IHUB_AUTH
		tableName = "IHUB_AUTH";
		Boolean isExistAuth = dao.isExistByFieldName(tableName, fieldName, fieldValue);
		log.info("from IHUB_AUTH result:" + isExistAuth);
		
		//check from IHUB_TXN
		tableName = "IHUB_TXN";
		Boolean isExistTxn = dao.isExistByFieldName(tableName, fieldName, fieldValue);
		log.info("from IHUB_TXN result:"+ isExistTxn);
		Map<String,Boolean> existMap = new HashMap<>();
		existMap.put("loadIhubAuthTable", isExistAuth);
		existMap.put("loadIhubTxnTable", isExistTxn);
		
		return existMap;
	}

	public List<IhubAuth> getDataById(String invoiceid) {
		String tableName = "IHUB_AUTH";
		String fieldName = "INVOICE_NUMBER";
		List<IhubAuth> dataMap = dao.getDataById(tableName, fieldName, invoiceid);
		
		return dataMap;
	}
	
	public List<Map<String, Object>> getQbmsByClientId(String invoiceId){
		return dao.getDataByClientTxnId(invoiceId);
	}
	
	public List<Qbms> getQbmsData(String invoiceId){
		String fieldName = "INVOICE_ID";
		List<Qbms> qbmsData = dao.getQbmsData(fieldName, invoiceId);
		return qbmsData;
	}
	
	public Map<String, Boolean> getExistMap(String invoiceId){
		Map<String, Boolean> existMap = new HashMap<>();
		
		Boolean existClearFile = dao.isExistClearFile(invoiceId);
		Boolean existACT10 = dao.isExistACT10(invoiceId);
		Boolean existAct2 = dao.isExistAct2(invoiceId);
		Boolean existPriced = dao.isExistPriced(invoiceId);
		Boolean existTilr = dao.isExistTilr(invoiceId);
		Boolean existCapConf = dao.isExistCapConf(invoiceId);
		
		existMap.put("inClearingFile", existClearFile);
		existMap.put("act10", existACT10);
		existMap.put("act2", existAct2);
		existMap.put("isPriced", existPriced);
		existMap.put("tilr", existTilr);
		existMap.put("capnConf", existCapConf);
		
		return existMap;
	}

}