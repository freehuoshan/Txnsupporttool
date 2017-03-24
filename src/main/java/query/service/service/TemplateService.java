package query.service.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import query.service.dao.DiagnosticDAO;
import query.service.data.DataModel;
import query.service.data.DataStore;


@Service
public class TemplateService {

	private final static Logger log = LoggerFactory.getLogger(TemplateService.class);

        private DiagnosticDAO diagnosticDAO;
	
	public DataModel getDataByInvoiceId(String invoiceId) throws NumberFormatException, ParseException, SQLException {
		
                DataModel dataModel = new DataModel();
                boolean authRecordExists = diagnosticDAO.authRecordExists(invoiceId);
                dataModel.setloadIHUBAUTHTable(authRecordExists);

		return dataModel;
	}
}