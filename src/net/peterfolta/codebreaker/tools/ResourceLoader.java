/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				ResourceLoader.java
 * Created:				2015/8/9
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

package net.peterfolta.codebreaker.tools;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ResourceLoader {
	
	public static Image loadImage(Display display, String fileName) {
		Image image = null;
		
		try {
			image = new Image(display, "res/img/" + fileName);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return image;
	}
	
	public static String getLanguageDirectory() {
		return System.getProperty("user.dir") + "/res/lng";
	}
	
	public static String getHelp(String language) {
		return "file:///" + System.getProperty("user.dir") + "/res/hlp/" + language + "/index.html";
	}
	
}