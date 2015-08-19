/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				ProfileWindowController.java
 * Created:				2015/8/15
 * Last modified:		2015/8/17
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

import net.peterfolta.codebreaker.gui.profilewindow.ProfileWindow;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ProfileWindowController {
	
	private Display display;
	
	private ProfileWindow profileWindow;
	
	public ProfileWindowController(Display display, Shell mainShell) {
		this.display = display;
		
		profileWindow = new ProfileWindow(this.display, this, mainShell);
	}
	
	public void showProfileWindow() {
		profileWindow.show();
	}
	
	public Shell getProfileWindow() {
		return profileWindow.getProfileWindow();
	}
	
}