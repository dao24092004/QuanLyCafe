package com.cafe.api;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class Homepage {
	@RequestMapping(value = {"","/"})
	public String index() {
		return"index";
	}
	
}
