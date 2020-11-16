package com.project;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlShortenerController {
	ModelAndView mv = new ModelAndView();
	String shorted;
	UrlShortenerService uss = new UrlShortenerService();

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getParameter("url");
		String id = request.getParameter("shorten");


		shorted = uss.shorten(url, id);

		mv.setViewName("display.jsp");
		mv.addObject("result", shorted);
		return mv;

	}
	
	@RequestMapping("/get")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
		String button = request.getParameter("show");
		if(button != null) {
			String url= uss.getUrl(shorted);
			mv.setViewName("show.jsp");
			mv.addObject("resultUrl", url);
		}
		return mv;
	}
}
