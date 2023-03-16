package com.java.food.ajax;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

public interface ajax11 {
	int login(HttpServletResponse rp, @RequestParam Map map) throws IOException;
}
