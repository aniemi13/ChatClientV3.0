package com.niemiec.battleship.manager;

import java.util.ArrayList;

public class BattleshipGamesManager {
	private ArrayList<String> players;
	
	public BattleshipGamesManager() {
		players = new ArrayList<>();
	}
	
	public void updateUsersList(ArrayList<String> users) {
		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; i < users.size(); j++) {
				if (players.get(i).equals(users.get(j))) {
					break;
				}
				
				if (j == (users.size() - 1)) {
					//wyświetl komunikat, że usuwany jest użytkownik
					//zamykane jest okno gry
					players.remove(i);
					return;
				}
			}
		}
	}

}
