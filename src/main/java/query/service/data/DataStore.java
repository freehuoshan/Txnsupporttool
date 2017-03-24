package query.service.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataStore {
	
	public static Logger log = LoggerFactory.getLogger(DataStore.class);
	
	public static Map<String, DataModel> dataMap = new HashMap<>();
	public static List<String> dataList = new ArrayList<>();
	static{
		
		dataList.add("aj05s3uw24804210|	Visa	|Auth		|5000	|2013-01-02 00:00:00	|Auth		|0	|Null					|Yes	|1	|ML201	|Null	|1	|0	|1	|0	|1	|0	|1	|0");
		dataList.add("aj05s3uw24804211|	AMEX	|Sale		|13000	|2013-02-05 00:00:00    |Auth		|0	|Null					|No		|0	|ML108	|Null	|0	|1	|0	|1	|0	|0	|1	|1");
		dataList.add("aj05s3uw24804212|	Check	|Capture	|17000	|2014-02-06 00:00:00	|Variable	|1	|2014-02-07 00:00:00	|Yes	|1	|ML108	|Null	|1	|0	|1	|0	|1	|1	|0	|1");
		dataList.add("aj05s3uw24804213|	Visa	|Auth		|23000	|2013-11-24 00:00:00	|Auth		|1	|2013-11-27 00:00:00	|No		|0	|ML304	|Null	|0	|1	|0	|1	|0	|1	|0	|0");
		dataList.add("aj05s3uw24804214|	Visa	|Capture	|4000	|2012-08-13 00:00:00	|Variable	|0	|Null					|No		|1	|ML201	|Null	|1	|0	|1	|0	|1	|0	|1	|1");
		dataList.add("aj05s3uw24804215|	AMEX	|Auth		|7000	|2013-01-02 00:00:00	|Auth		|0	|Null					|Yes	|1	|ML108	|Null	|1	|1	|0	|1	|0	|0	|1	|0");
		dataList.add("aj05s3uw24804216|	AMEX	|Auth		|3000	|2013-10-07 00:00:00	|Variable	|1	|2013-10-10 00:00:00	|Yes	|0	|ML304	|Null	|0	|1	|1	|0	|1	|1	|0	|1");
		dataList.add("aj05s3uw24804217|	Check	|Sale		|5000	|2013-08-19 00:00:00	|Auth		|1	|2013-08-24 00:00:00	|No		|1	|ML304	|Null	|1	|1	|1	|1	|0	|0	|1	|0");
		dataList.add("aj05s3uw24804218|	AMEX	|Sale		|3000	|2013-02-06 00:00:00	|Variable	|0	|Null					|No		|0	|ML201	|Null	|1	|0	|0	|0	|1	|1	|1	|1");
		dataList.add("aj05s3uw24804219|	Visa	|Capture	|15000	|2013-01-02 00:00:00	|Auth		|1	|2013-01-05 00:00:00	|Yes	|1	|ML304	|Null	|0	|1	|1	|1	|1	|0	|0	|0");
	}

	public static Map<String, DataModel> getDataMap() throws NumberFormatException, ParseException{
		for (String string : dataList) {
			String[] strSpliArr = string.split("[|]");
			log.info("strArr:---->"+strSpliArr);
			//convert string to date
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String transaction_Received_Date = strSpliArr[4].trim();
			Date batch_Close_Date = new Date();
			if("Null".equals(strSpliArr[7].trim())){
				batch_Close_Date = null;
			}
			else{
				batch_Close_Date = dateFormat.parse(strSpliArr[7].trim());
			}
			
			DataModel dataModel = new DataModel(strSpliArr[0].trim(), strSpliArr[1].trim(),
							strSpliArr[2].trim(), Double.parseDouble(strSpliArr[3].trim()),
							dateFormat.parse(transaction_Received_Date), strSpliArr[5].trim(),
							getBooleanByStr(strSpliArr[6].trim()),batch_Close_Date, 
							strSpliArr[8].trim(),getBooleanByStr(strSpliArr[9].trim()), 
							strSpliArr[10].trim(), null, getBooleanByStr(strSpliArr[12].trim()), getBooleanByStr(strSpliArr[13].trim()),
							getBooleanByStr(strSpliArr[14].trim()), getBooleanByStr(strSpliArr[15].trim()),getBooleanByStr( strSpliArr[16].trim()),
							getBooleanByStr(strSpliArr[17].trim()),getBooleanByStr( strSpliArr[18].trim()),getBooleanByStr( strSpliArr[19].trim()));
			dataMap.put(dataModel.getinvoiceId(), dataModel);
		}
		
		return dataMap;
	}
	
	//convert string to boolean
	public static boolean getBooleanByStr(String booStr){
		return "0".equals(booStr) ? false : true;
	}
	
}
