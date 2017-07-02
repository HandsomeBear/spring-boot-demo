package com.example.demo.service;

import javax.annotation.Resource;

import com.example.demo.dao.MyDAO;

public class MyService {

	@Resource(name="myDAO")
	private MyDAO myDAO;
}
