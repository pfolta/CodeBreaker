/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				PegColor.java
 * Created:				2015/8/7
 * Last modified:		2015/8/7
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

package net.peterfolta.codebreaker.enums;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public enum PegColor {
	
	BLACK(0, 0, 0),
	BLUE(22, 149, 230),
	GRAY(179, 179, 179),
	GREEN(42, 194, 23),
	ORANGE(223, 143, 20),
	PURPLE(209, 5, 227),
	RED(246, 1, 0),
	YELLOW(248, 199, 0);
	
	private Color color;
	
	PegColor(int red, int green, int blue) {
		this.color = new Color(Display.getDefault(), red, green, blue);
	}
	
	public Color getColor() {
		return color;
	}
	
}