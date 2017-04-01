package query.service.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import query.service.entity.IhubAuth;
import query.service.entity.Qbms;

@Component
public class Dao {

	private final static Logger log = LoggerFactory.getLogger(Dao.class);
	
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findData(String tableName , String queryField , Object queryValue) {
       String sql = "select * from " + tableName + " where "+ queryField +"= ?";
       log.info("sql: "+ sql);
       return jdbcTemplate.queryForList(sql, new Object[]{queryValue});
    }

    /**
     * query isexist from tableName by fieldName
     * @param tableName
     * @param fieldName
     * @param fieldValue
     * @return
     */
	public Boolean isExistByFieldName(String tableName ,String fieldName , String fieldValue) {
		String sql = "select * from " + tableName + " where " + fieldName + " = ?" ;
		log.info("sql: ----->" + sql);
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql, new Object[]{fieldValue});
		return queryResult.size() > 0 ? true : false;
	}

	public List<IhubAuth> getDatasById(String tableName , String fieldName , String fieldValue) {
		String sql = "select TXN_TYPE , AMOUNT , TXN_DATE , BATCH_CLOSE_DATE , CARD_TYPE ,"
				+ "MT_MERCHANT_BATCH_ID,TXN_STATUS_ID,MT_RESULT_CODE"
				+ " from " + tableName + " where " + fieldName + " = ?";
		log.info("sql:------>" + sql);
		
		return jdbcTemplate.query(sql, new Object[]{fieldValue}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet res, int index) throws SQLException {
				
				Double batchType =  res.getDouble("MT_MERCHANT_BATCH_ID");
				Double resultCode = res.getDouble("MT_RESULT_CODE");
				Date batchCloseDate = res.getDate("BATCH_CLOSE_DATE");
				
				IhubAuth auth = new IhubAuth(res.getString("TXN_TYPE"), res.getDouble("AMOUNT"),
						res.getDate("TXN_DATE"), batchCloseDate, 
						res.getString("CARD_TYPE"), batchType == null  ? "Auto-Batch" : "Variable-Batch", 
						res.getDouble("TXN_STATUS_ID"), resultCode == null  ? false : true ,
						batchCloseDate != null ? true : false);
				
				return auth;
			}
			
		});
		
		
	}
	
	public List<Qbms> getQbmsData(String fieldName , String fieldValue) {
//		ihub_import_archive.qbms_mas_txn_ar table
		String sql = "select VENDOR_RESULT_CODE,CLIENT_TXN_ID"
				+ " from ihub_import_archive.qbms_mas_txn_ar where " + fieldName + " = ?";
		
		return jdbcTemplate.query(sql, new Object[]{fieldValue}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet res, int index) throws SQLException {
				
				String archiveTable = res.getString("CLIENT_TXN_ID");
				Date mLinkReceivedDate = res.getDate("GATEWAY_REQUEST_DATE");
				Timestamp nrtConformedDate = res.getTimestamp("IHUB_INSERT_DTTM"); 
				
				Qbms qbms = new Qbms(archiveTable == null ? false : true, res.getString("VENDOR_RESULT_CODE"),
						mLinkReceivedDate,nrtConformedDate);
				return qbms;
			}
		});
		
	}
	
	public Boolean isExistClearFile(String invoiceId){
		 String sql = "SELECT * FROM ihub_import_archive.PTS_CLR_DTL_AR clr WHERE clr.merchant_order_nbr"
		 		+ " = ?";
	       log.info("sql: "+ sql);
	       List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, new Object[]{invoiceId});
	       return queryForList.size() > 0 ? true : false;
	}
	
	public Boolean isExistACT10(String invoiceId){
		String sql = "SELECT * FROM ihub_import_archive.pts_act0010_ar act10 WHERE act10.merchant_order_nbr = ?";
		log.info("sql:" + sql);
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, new Object[]{invoiceId});
		return queryForList.size() > 0 ? true : false;
	}

	public Boolean isExistAct2(String invoiceId){
		String sql = "SELECT * FROM ihub_import_archive.pts_act0002_ar act2 WHERE act2.merchant_order_nbr = ?";
		log.info("sql:" + sql);
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, new Object[]{invoiceId});
		return queryForList.size() > 0 ? true : false;
	}
	
	public Boolean isExistPriced(String invoiceId){
		String sql = "SELECT * FROM ihub_owner.ihub_txn_price tp,ihub_owner.ihub_txn it WHERE tp.txn_id"
				+ " = it.id AND (it.invoice_number = ? OR it.auth_invoice_number = ?)";
		log.info("sql:" + sql);
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, new Object[]{invoiceId,invoiceId});
		return queryForList.size() > 0 ? true : false;
	}
	
	public Boolean isExistTilr(String invoiceId){
		String sql = "SELECT * FROM IHUB_IMPORT_ARCHIVE.amex_tilr_roc_detail_ar tilr WHERE tilr.client_txn_id = ?";
		log.info("sql:" + sql);
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, new Object[]{invoiceId});
		return queryForList.size() > 0 ? true : false;
	}
	
	public Boolean isExistCapConf(String invoiceId){
		String sql = "SELECT * FROM IHUB_IMPORT_ARCHIVE.amex_capnconf_rej_ar rej where client_txn_id = ?";
		log.info("sql:" + sql);
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList(sql, new Object[]{invoiceId});
		return queryForList.size() > 0 ? true : false;
	}
	
	public List<Map<String, Object>> getDataByClientTxnId(String invoiceId){
//		ihub_import_archive.qbms_mas_txn_ar table
		String sql = "select GATEWAY_REQUEST_DATE,IHUB_INSERT_DTTM"
				+ " from ihub_import_archive.qbms_mas_txn_ar where client_txn_id = ?";
		
		return jdbcTemplate.query(sql, new Object[]{invoiceId}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet res, int arg1) throws SQLException {
				
				Timestamp insertDttm = res.getTimestamp("IHUB_INSERT_DTTM");
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS a", new Locale("en", "US"));
				
				Map<String, Object> map = new HashMap<>();
				map.put("mLinkReceivedDate", res.getString("GATEWAY_REQUEST_DATE"));
				map.put("nrtConformedDate", format.format(insertDttm));
				return map;
			}
			
		});
	}
	

}
