package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;
import Hbase.GetHbaseData;


@Component
public class JsonService {
	
	@Autowired
	private GetHbaseData gd;
	@Autowired
	private DataActivity da;
	
	
	public ObjectNode generateJson(String val) throws IOException{

		List<String> list  = gd.getHbaseData();

		da.setTitle("hbasetest");
		da.setValue(list.get(0).toString());
		da.setVal(val);
		
		ObjectNode j = Json.newObject();
		j.put("Title", da.getTitle());
		j.put("Value", da.getValue());
		j.put("Val", da.getVal());


		return j;


	}
	public ObjectNode generateJson(int val) throws IOException{

		List<String> list  = gd.getHbaseData();
		
		da.setTitle("hbasetest");
		da.setValue(list.get(0).toString());
		da.setVal2(val);
		
		ObjectNode j = Json.newObject();
		j.put("Title", da.getTitle());
		j.put("Value", da.getValue());
		j.put("Val", da.getVal());

		return j;
	}
}
