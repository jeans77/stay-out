package com.libertymutual.goforcode.stayout.controllers;

import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

	@GetMapping("loginalot")
	public String login() {
		return "loginalot";

	}
	
	
	
	
	@GetMapping("admin")
	public String admin(Model model, ServletRequest request) {
		model.addAttribute("message", "Hello You");
		return "admin";

	}
	
	@GetMapping("")
	public String unsecured() {
		return "unsecured";

	}

	@GetMapping("secured")
	public String secured() {
		return "secured";

	}
	


}
