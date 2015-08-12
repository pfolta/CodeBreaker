/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				Main.java
 * Created:				2015/8/6
 * Last modified:		2015/8/12
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

package net.peterfolta.codebreaker.main;

import net.peterfolta.codebreaker.controllers.gui.GUIController;
import net.peterfolta.codebreaker.controllers.main.LanguageController;
import net.peterfolta.codebreaker.enums.ExitCode;
import net.peterfolta.codebreaker.model.Language;

public class Main {
	
	private static LanguageController languageController;
	private static GUIController guiController;
	
	public static void main(String[] args) {
		printStartUpNotice();
		
		languageController = new LanguageController();
		
		guiController = new GUIController();
		guiController.showMainWindow();
	}
	
	private static void printStartUpNotice() {
		System.out.println(
			Data.APP_NAME + " - " + Data.APP_DESCRIPTION + "\n" +
			"Version " + Data.APP_VERSION + "\n" +
			"Copyright (C) " + Data.APP_COPYRIGHT_YEAR + " " + Data.APP_COPYRIGHT_HOLDER + ". All rights reserved.\n" +
			"\n" +
			"This program is free software: you can redistribute it and/or modify\n" +
			"it under the terms of the GNU General Public License as published by\n" +
			"the Free Software Foundation, either version 3 of the License, or\n" +
			"(at your option) any later version.\n" +
			"\n" +
			"This program is distributed in the hope that it will be useful,\n" +
			"but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
			"MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
			"GNU General Public License for more details.\n" +
			"\n" +
			"You should have received a copy of the GNU General Public License\n" +
			"along with this program.  If not, see <http://www.gnu.org/licenses/>."
		);
	}
	
	public static Language getLanguage() {
		return languageController.getLanguage();
	}
	
	public static void exit(ExitCode exitCode) {
		guiController.dispose();
		
		System.exit(exitCode.getExitCode());
	}
	
}