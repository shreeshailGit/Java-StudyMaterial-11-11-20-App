package com.nt.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service("loaleService")
public class LocaleInfoServiceImpl implements ILocaleInfoService {

	@Override
	public Set<String> getAllCountries() {
		 Locale[] locales = null;
		 Set<String>  countriesList=null;
		 //get All Locales
		 locales = Locale.getAvailableLocales();
		 countriesList = new TreeSet();
		 
		 for(Locale l : locales) {
			 countriesList.add(l.getDisplayCountry());
		 }
		return countriesList;
	}

	@Override
	public Set<String> getAllLanguages() {
		Locale[] locales = null;
		Set<String> languageList = null;
		//get All Locales
		locales = Locale.getAvailableLocales();
		
		languageList = new TreeSet();
		
		for(Locale lg : locales) {
			languageList.add(lg.getDisplayLanguage());
		}
		return languageList;
	}
	
	

}//class
