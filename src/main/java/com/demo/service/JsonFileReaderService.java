package com.demo.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonFileReaderService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Map<?, ?> readInfoWithObjectMapper()
			throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<?, ?> userMap = mapper.readValue(new FileInputStream("C:/Users/nkumari/Desktop/sourceNameNumberMapping.json"), Map.class);
		for (Map.Entry<?, ?> entry : userMap.entrySet()) {
			logger.info("\n----------------------------\n" + entry.getKey() + "=" + entry.getValue() + "\n");
		}
		
		return userMap;
	}

}
