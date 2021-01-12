package com.johndang.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.johndang.languages.models.Language;
import com.johndang.languages.services.LanguageService;





@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	//show all languages
	@GetMapping("/languages")
	public String index(@ModelAttribute ("language") Language language, Model model) {

		model.addAttribute("allLanguages", languageService.allLanguages());
		return "index.jsp";
	}
	//show one language
	@GetMapping("/languages/{id}")
	public String showLanguage(Model model, @PathVariable("id") Long id) {
		Language language= languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	//edit languages
	 @GetMapping("/languages/{id}/edit")
	 //store as long if passing id
	    public String edit(@Valid @PathVariable("id") Long id, Model model) {
	        Language language = languageService.findLanguage(id);
	        model.addAttribute("language", language);
	        return "edit.jsp";
	    }
	 

//this is to create
	@PostMapping("/process")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("We had an error");
			return "index.jsp";
		} else {
		languageService.createLanguage(language);
		return "redirect:/languages";
		}
	}
	

//this is for update
	 @PostMapping(value="/languages/{id}")
	    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/languages/{id}/edit.jsp";
	        } else {
	            languageService.createLanguage(language);
	            return "redirect:/languages";
	        }
	    }
//	
//		   
	
//    @DeleteMapping(value="/languages/{id}")
//    public String destroy(@PathVariable("id") Long id) {
//        languageService.deleteLanguage(id);
//        return "redirect:/";
//    }


//	 @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	 @GetMapping("/languages/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        languageService.deleteLanguage(id);
	        return "redirect:/languages";
	    }
//	 public void destroy(@PathVariable("id") Long id) {
//	    	Language language = languageService.findLanguage(id);
//	        languageService.deleteLanguage(language);
//	    }



}