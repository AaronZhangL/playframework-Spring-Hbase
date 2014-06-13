package Hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetHbaseData {


	@Autowired
	private HbaseTable hbaseTable;

	public List<String> getHbaseData(){

		List<String> datamap = new ArrayList<String>();

		HTable tbl = null;
		try {

			
			tbl = hbaseTable.getHbaseTable("your Hbase Table Name");
		
			Scan s = new Scan();
			ResultScanner resultScanner;
			s.addFamily(Bytes.toBytes("your Hbase Column Family"));

			resultScanner = tbl.getScanner(s);

			for (Result result : resultScanner) {
				for(KeyValue key : result.raw()){
					datamap.add(Bytes.toString(key.getValue()));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return datamap;

	}
}
