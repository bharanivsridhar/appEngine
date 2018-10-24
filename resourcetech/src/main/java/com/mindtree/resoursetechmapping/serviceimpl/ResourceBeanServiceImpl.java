package com.mindtree.resoursetechmapping.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.resoursetechmapping.bean.ResourceBean;
import com.mindtree.resoursetechmapping.dao.ResourceBeanDao;
import com.mindtree.resoursetechmapping.service.ResourceBeanService;

@Service
public class ResourceBeanServiceImpl implements ResourceBeanService {
	private final Logger logger = Logger.getLogger(ResourceBeanServiceImpl.class);
	@Autowired
	private ResourceBeanDao resourceDao;

	public boolean addResourece(ResourceBean resource) {
		boolean result = false;
		logger.info("Service layer -:addResourece method called");
		result = resourceDao.addResourece(resource);
		logger.info("Service layer -:addResourece method completed");
		return result;

	}

	public ResourceBean getResource(int id) {
		logger.info("Service layer -:getResource method called");
		ResourceBean resourceBean = resourceDao.getResource(id);
		logger.info("Service layer -:getResource method completed");
		return resourceBean;
	}

	
}