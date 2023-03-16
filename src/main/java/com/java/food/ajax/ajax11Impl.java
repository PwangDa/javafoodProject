package com.java.food.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.food.controller.JavafoodController;

@Service
public class ajax11Impl implements ajax11 {
	private static final Logger log = LoggerFactory.getLogger(JavafoodController.class);

	@Override
	@RequestMapping("asd")
	public int login(
			HttpServletResponse rp, 
			@RequestParam Map map) throws IOException {
		
		log.info("아자스 실행");
		System.out.println(map.get("id"));
//		map.get("nic");
//		map.get("email");
//		map.get("pn");
//		map.get("phone");
		rp.getWriter().print(1);
		
		return 0;
	}

}
