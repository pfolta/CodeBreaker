/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				Language.java
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

package net.peterfolta.codebreaker.model;

import java.io.File;

import net.peterfolta.codebreaker.tools.ResourceLoader;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class Language {
	
	private String languageKey;
	private String languageFile;
	
	private Document languageDocument;
	private Element rootElement;
	private Element informationElement;
	private Element translationsElement;
	
	public Language(String languageKey) {
		this.languageKey = languageKey;
		this.languageFile = ResourceLoader.getLanguageDirectory() + File.separator + this.languageKey + ".xml";
		
		try {
			languageDocument = new SAXBuilder().build(languageFile);
			rootElement = languageDocument.getRootElement();
			informationElement = rootElement.getChild("Information");
			translationsElement = rootElement.getChild("Translations");
		} catch (Exception exception) {
			exception.printStackTrace();
        }
	}
	
	public String getMeta(String key) {
		String result = null;
		
		try {
			result = informationElement.getChild(key).getText();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return result;
	}
	
	public String getContent(String key) {
		String result = null;
		
		try {
			result = translationsElement.getChild(key).getText();
		} catch (Exception exception) {
			exception.printStackTrace();
        }
		
		return result;
	}
	
	public String getLanguageKey() {
		return languageKey;
	}
	
}