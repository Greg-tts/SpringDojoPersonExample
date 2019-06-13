package com.tts.springDojo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tts.springDojo.person.Person;
import com.tts.springDojo.person.PersonRepository;

@Controller
public class SpringDojoController {
	@Autowired
	PersonRepository personRepository;
	
	@GetMapping("/")
	public String index(Model model)
	{
		Person jon = new Person("John Snow",25,"Winterfell");
		Person sansa = new Person("Sansa Stark",20,"Winterfell");
		
		personRepository.save(jon);
		personRepository.save(sansa);

		model.addAttribute("sansa", sansa);
		model.addAttribute("jon", jon);
		return "index";
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id, Model model)
	{
		System.out.println("~~~~~~~~~~~~~~~~" + id + "~~~~~~~~~~~~~~~~~~");
	}
	
}
