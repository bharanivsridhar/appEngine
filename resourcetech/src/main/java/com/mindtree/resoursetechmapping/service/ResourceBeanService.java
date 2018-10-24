package com.mindtree.resoursetechmapping.service;

import com.mindtree.resoursetechmapping.bean.ResourceBean;

public interface ResourceBeanService {
	
	public boolean addResourece(ResourceBean resource);
	public ResourceBean getResource(int id);
}
