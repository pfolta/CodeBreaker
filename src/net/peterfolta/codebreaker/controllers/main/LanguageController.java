/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				LanguageController.java
 * Created:				2015/8/10
 * Last modified:		2015/8/10
 * Author:				Peter Folta <mail@peterfolta.net>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.peterfolta.codebreaker.controllers.main;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

import net.peterfolta.codebreaker.model.Language;
import net.peterfolta.codebreaker.tools.ResourceLoader;

public class LanguageController {
	
	private Language[] languages;
	
	private int selectedLanguageIndex;
	
	public LanguageController() {
		String[] languageFiles = new File(ResourceLoader.getLanguageDirectory()).list();
		Arrays.sort(languageFiles);
		
		languages = new Language[languageFiles.length];
		selectedLanguageIndex = 0;
		
		for (int i = 0; i < languageFiles.length; i++) {
			String languageKey = languageFiles[i].split(Pattern.quote("."))[0];
			
			if (languageKey.equals("en")) {
				selectedLanguageIndex = i;
			}
			
			languages[i] = new Language(languageKey);
		}
	}
	
	public Language getLanguage() {
		return languages[selectedLanguageIndex];
	}
	
	public void setSelectedLanguage(String languageKey) {
		for (int i = 0; i < languages.length; i++) {
			if (languages[i].getLanguageKey().equals(languageKey)) {
				selectedLanguageIndex = i;
			}
		}
	}
	
}