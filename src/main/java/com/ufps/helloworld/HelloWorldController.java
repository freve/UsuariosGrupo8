package com.ufps.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200") //Permite que otro servidor pueda acceder al metodo
public class HelloWorldController{
	
	//@RequestMapping(method= RequestMethod.GET , path = "/hello-world") --> Este es una forma de usar
	//pero la siguiente es mas corta: @GetMapping  --  Tambien sirve @PostMapping, @PutMapping ...
	
	@GetMapping(path = "/hello-world")
	public String helloWorld () {
		
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean () {
		
		return new HelloWorldBean ("Hello World");
	}	
	
	@GetMapping(path = "/hello-world-bean-path/{name}")
	public HelloWorldBean helloWorldBeanPath (@PathVariable String name) {
		
		return new HelloWorldBean (String.format("Hello world, %s", name));
	}	
	
}
