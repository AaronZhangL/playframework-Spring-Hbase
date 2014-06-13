package Hbase;

import java.io.IOException;
import java.util.HashMap;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;





@Component
public class HbaseTable {
	
	public static final String TABLE_NAME = "your Hbase Table Name";

	
	private HashMap<String, HTable> tblMap = null;
	
	
	@Autowired
	private Configuration hbaseConfiguration;

	
	public HTable getHbaseTable(String inputTableName) {
		
		
		try {
		
			if (tblMap == null) {
				tblMap = new HashMap<String, HTable>();
			}
			if (!tblMap.containsKey(inputTableName)) {
				//logger.debug(tableName);
				HTable tbl = new HTable(hbaseConfiguration, inputTableName);
				tblMap.put(inputTableName, tbl);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		
		} 
		return tblMap.get(inputTableName);
		
		
		
	}
}
