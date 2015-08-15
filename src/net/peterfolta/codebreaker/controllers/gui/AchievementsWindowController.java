/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				AchievementsWindowController.java
 * Created:				2015/8/15
 * Last modified:		2015/8/15
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

package net.peterfolta.codebreaker.controllers.gui;

import net.peterfolta.codebreaker.gui.achievementswindow.AchievementsWindow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class AchievementsWindowController {
	
	private Display display;
	
	private AchievementsWindow achievementsWindow;
	
	public AchievementsWindowController(Display display, Shell mainShell) {
		this.display = display;
		
		achievementsWindow = new AchievementsWindow(this.display, this, mainShell);
	}
	
	public void showAchievementsWindow() {
		achievementsWindow.show();
	}
	
	public Shell getAchievementsWindow() {
		return achievementsWindow.getAchievementsWindow();
	}
	
}