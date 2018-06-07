package com.demo.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.JsonFileReaderService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping(value = "/api/read")
public class JsonFileReaderController {

	@Autowired
	private JsonFileReaderService fileReaderService;

	@GetMapping("/datalist")
	public ModelAndView readData() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {
		Map<?, ?> dataMap = fileReaderService.readInfoWithObjectMapper();
		ModelAndView view = new ModelAndView();
		view.addObject("dataList", dataMap);
		view.setViewName("viewinfo");

		return view;
	}
}
