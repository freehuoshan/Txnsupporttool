package query.service.service;

import java.text.ParseException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import query.service.data.DataModel;
import query.service.data.DataStore;


@Service
public class TemplateService {

	private final static Logger log = LoggerFactory.getLogger(TemplateService.class);
	
	
	public DataModel getDataByInvoiceId(String invoiceId) throws NumberFormatException, ParseException{
		
		Map<String, DataModel> dataMap = DataStore.getDataMap();
		
		return dataMap.get(invoiceId);
	}
}