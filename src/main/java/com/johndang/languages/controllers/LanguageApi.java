package com.johndang.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.johndang.languages.models.Language;
import com.johndang.languages.services.LanguageService;





@RestController
public class LanguageApi {
    private final LanguageService languageService;
    public LanguageApi(LanguageService languageService){
        this.languageService = languageService;
    }
    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @RequestMapping(value="/api/languages", method=RequestMethod.POST)
    public Language create(
    		@RequestParam(value="name") String name, 
    		@RequestParam(value="creator") String creator, 
    		@RequestParam(value="version") Float version) {
        Language language = new Language(name, creator,version);
        return languageService.createLanguage(language);
    }
    
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.POST)
    public Language update(@PathVariable("id") Long id, Language lang) {
        Language language = languageService.updateLanguage(id, lang);
        return language;
    }
    
//  @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//  public Book update(@PathVariable("id") Long id, 
//		  @RequestParam(value="title") String title, 
//		  @RequestParam(value="description") String desc, 
//		  @RequestParam(value="language") String lang, 
//		  @RequestParam(value="pages") Integer numOfPages) {
//      Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
//      return book;
//  }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
//    public void destroy(@PathVariable("id") Long id) {
//    	Language language = languageService.findLanguage(id);
//        languageService.deleteLanguage(language);
//    }
}