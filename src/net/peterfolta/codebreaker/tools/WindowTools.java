/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				WindowTools.java
 * Created:				2015/8/8
 * Last modified:		2015/8/8
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

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class WindowTools {
	
	public static void centerShellOnPrimaryMonitor(Display display, Shell shell) {
		int monitorWidth	= display.getPrimaryMonitor().getBounds().width;
		int monitorHeight	= display.getPrimaryMonitor().getBounds().height;
		
		int shellWidth		= shell.getSize().x;
		int shellHeight		= shell.getSize().y;
		
		int shellXPos		= (monitorWidth - shellWidth) / 2;
		int shellYPos		= (monitorHeight - shellHeight) / 2;
		
		shell.setLocation(shellXPos, shellYPos);
	}
	
	public static void centerShellOnParent(Shell shell, Shell parent) {
		int parentXPos		= parent.getBounds().x;
		int parentYPos		= parent.getBounds().y;
		int parentWidth		= parent.getSize().x;
		int parentHeight	= parent.getSize().y;
		
		int shellWidth		= shell.getSize().x;
		int shellHeight		= shell.getSize().y;
		
		int shellXPos		= parentXPos + (parentWidth - shellWidth) / 2;
		int shellYPos		= parentYPos + (parentHeight - shellHeight) / 2;
		
		shell.setLocation(shellXPos, shellYPos);
	}
	
}