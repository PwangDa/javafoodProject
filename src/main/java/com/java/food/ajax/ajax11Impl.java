package com.java.food.ajax;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.food.controller.JavafoodController;

public class ajax11Impl implements ajax11 {
	private static final Logger log = LoggerFactory.getLogger(JavafoodController.class);

	@Override
	public int login(HttpServletResponse rp, Map map) {
		
		log.info("아자스 실행");
		
		map.get("id");
		map.get("nic");
		map.get("email");
		map.get("pn");
		map.get("phone");
		
		
		return 0;
	}

}
