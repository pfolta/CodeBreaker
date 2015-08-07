/*
 * CodeBreaker - A java implementation of the popular board game known as Mastermind.
 * Copyright (C) 2015 Peter Folta. All rights reserved.
 *
 * Project:				CodeBreaker
 * Version:				0.0.1
 * Website:				http://www.peterfolta.net/software/codebreaker
 * 
 * File:				GameController.java
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

package net.peterfolta.codebreaker.controllers.game;

import net.peterfolta.codebreaker.common.Controller;
import net.peterfolta.codebreaker.model.Code;
import net.peterfolta.codebreaker.model.Feedback;
import net.peterfolta.codebreaker.model.Game;

public class GameController extends Controller {
	
	private Game game;
	
	public GameController() {
	}
	
	@Override
	public void init() {
		game = new Game();
	}
	
	public Feedback computeFeedback(Code guess) {
		Code secret = game.getSecret();
		
		int blackPegs = 0;
		int whitePegs = 0;
		
		boolean[] rewardedPegs = new boolean[guess.getLength()];
		
		// Compute black pegs (i.e. correct color and position)
		for (int i = 0; i < guess.getLength(); i++) {
			if (guess.getPeg(i).equals(secret.getPeg(i))) {
				blackPegs++;
				rewardedPegs[i] = true;
			}
		}
		
		// Compute white pegs (i.e. correct color but incorrect position)
		for (int i = 0; i < guess.getLength(); i++) {
			for (int j = 0; j < secret.getLength(); j++) {
				if (!rewardedPegs[j] && i != j) {
					if (guess.getPeg(i).equals(secret.getPeg(j))) {
						whitePegs++;
						rewardedPegs[j] = true;
					}
				}
			}
		}
		
		return new Feedback(blackPegs, whitePegs);
	}

}