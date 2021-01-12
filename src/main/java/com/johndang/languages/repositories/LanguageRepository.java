package com.johndang.languages.repositories;

import org.springframework.stereotype.Repository;

import com.johndang.languages.models.Language;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface LanguageRepository extends CrudRepository <Language, Long>{
//	 // this method retrieves all the languages from the database
//    List<Language> findAll();
//    // this method finds languages with descriptions containing the search string
//    List<Language> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByNameContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByNameStartingWith(String search);
}
