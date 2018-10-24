package com.mindtree.resoursetechmapping.dao;

import com.mindtree.resoursetechmapping.bean.ResourceBean;

public interface ResourceBeanDao {
	
	public boolean addResourece(ResourceBean resource);
	public ResourceBean getResource(int id);
}
