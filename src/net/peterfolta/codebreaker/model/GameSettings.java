/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				GameSettings.java
 * Created:				2015/8/6
 * Last modified:		2015/8/6
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

import net.peterfolta.codebreaker.data.DefaultSettings;

public class GameSettings {
	
	private int codeLength;
	private int colorsCount;
	
	private int attemptsCount;
	
	public GameSettings() {
		setCodeLength(DefaultSettings.CODE_LENGTH);
		setColorsCount(DefaultSettings.COLORS_COUNT);
		
		setAttemptsCount(DefaultSettings.ATTEMPTS_COUNT);
	}
	
	public void setCodeLength(int codeLength) {
		this.codeLength = codeLength;
	}
	
	public int getCodeLength() {
		return codeLength;
	}
	
	public void setColorsCount(int colorsCount) {
		this.colorsCount = colorsCount;
	}
	
	public int getColorsCount() {
		return colorsCount;
	}
	
	public void setAttemptsCount(int attemptsCount) {
		this.attemptsCount = attemptsCount;
	}
	
	public int getAttemptsCount() {
		return attemptsCount;
	}
	
}