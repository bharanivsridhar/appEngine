package com.mindtree.resoursetechmapping.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.resoursetechmapping.bean.ResourceBean;
import com.mindtree.resoursetechmapping.service.ResourceBeanService;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ResourceBeanController {
	private final Logger logger = Logger.getLogger(ResourceBeanController.class);
	@Autowired
	private ResourceBeanService resourceService;
	
	/**
	 * This method used insert the resource into Database it wont save into database 
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		System.out.println("Hello My method is called");
		return "My hello Method called";
	}
	
	/**
	 * This method used insert the resource into Database
	 */
	
	@RequestMapping(value = "/addResource", method = RequestMethod.POST, produces = { "application/JSON" })
	public String addResource(@RequestBody String resource) {
		logger.info("addResource method reached and resource info :->" + resource);
		try {
			ResourceBean resourceBean = new ObjectMapper().readValue(resource, ResourceBean.class);
		boolean value =	resourceService.addResourece(resourceBean);
		if(value){
			return new ObjectMapper().writeValueAsString("Success");
		}else{
			return new ObjectMapper().writeValueAsString("Failed");
		}
			 

		} catch (JsonParseException e) {
			logger.info("JsonParseException" + e);

		} catch (JsonMappingException e) {
			logger.info("JsonMappingException" + e);
		} catch (IOException e) {
			logger.info("IOException :" + e);
		}
		logger.info("addResource method completed");
		return "";
		 
	}

	/**
	 * This method used insert the resource into Database
	 */

	@RequestMapping(value = "/getResource/{id}", method = RequestMethod.GET)
	public String getResource(@PathVariable("id") int id) {
		logger.info("getResource method requested with id" + id);
		String result = null;
		try {
			result = new ObjectMapper().writeValueAsString(resourceService.getResource(id));
		} catch (JsonGenerationException e) {
			logger.info("JsonParseException" + e);
		} catch (JsonMappingException e) {
			logger.info("JsonMappingException" + e);
		} catch (IOException e) {
			logger.info("IOException :" + e);
		}
		logger.info("Get Resource method completed !!!");
		return result;
	}
	
}
