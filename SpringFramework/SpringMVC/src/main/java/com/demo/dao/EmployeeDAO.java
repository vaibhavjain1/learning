package com.demo.dao;

import java.util.List;

import com.demo.model.EmployeeVO;

public interface EmployeeDAO 
{
	public List<EmployeeVO> getAllEmployees();
}