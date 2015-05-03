package com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String getLogin(){
		//ModelAndView modelAndView = new ModelAndView("index");
		//modelAndView.
		return "index";
		
	}

}
