package com.johndang.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.johndang.languages.models.Language;
import com.johndang.languages.repositories.LanguageRepository;


@Service
public class LanguageService {
	//adding teh language repository as a dependency
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	//returns all teh languages
	public List<Language> allLanguages() {
		return (List<Language>) languageRepository.findAll();
	}
	//creates a language
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	//get a language by id
	public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	//update a language
    public Language updateLanguage(Long id, Language language) {
//    	System.out.println(Book.setTitle("test"));
    	return this.languageRepository.save(language);
	}
    //delete a language
    public void deleteLanguage(Long id) {
    	this.languageRepository.deleteById(id);
    	
    }
//    
//    public void deleteLanguage(Language language) {
//    	languageRepository.delete(language);
//    }


}
