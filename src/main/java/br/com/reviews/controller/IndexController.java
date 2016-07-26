package br.com.reviews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.reviews.model.Usuario;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(){
		return "index";
	}

	@RequestMapping("/index1")
	public String index1(){
		return "index1";
	}

	@RequestMapping("/login1")
	public String login(){
		return "login1";
	}

	@RequestMapping("/register")
	public String register(Usuario usuario){
		return "register";
	}
	
}
