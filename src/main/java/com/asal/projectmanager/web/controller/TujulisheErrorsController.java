package com.asal.projectmanager.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.asal.projectmanager.web.TujulisheException;

public class TujulisheErrorsController {
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 
		throw new TujulisheException("Oppss...this is embarassing, Tujulishe staff know about it and they are in the process of fixing, you can mail them using support@tujulishe.com just to remind them , thank you!");
 
	}

}
