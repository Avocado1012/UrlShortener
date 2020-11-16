package com.project;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlShortenerController {

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		String url = request.getParameter("url");
		String id = request.getParameter("shorten");

		UrlShortenerService uss = new UrlShortenerService();

		String shorted = uss.shorten(url, id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result", shorted);
		return mv;

	}
}
