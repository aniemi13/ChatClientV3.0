package com.niemiec.battleship.logic;

import com.niemiec.battleship.manager.BattleshipGame;
import com.niemiec.battleship.manager.BattleshipGamesManager;
import com.niemiec.battleship.view.BattleshipView;
import com.niemiec.chat.objects.Client;

import javafx.event.ActionEvent;

public class BattleshipManagement {
	private Client client;
	private BattleshipGamesManager battleshipGamesManager;
	
	public BattleshipManagement(Client client) {
		this.client = client;
		this.battleshipGamesManager = new BattleshipGamesManager();
	}
	
	public void receiveBattleshipGame(BattleshipGame battleshipGame) {
		// TODO Auto-generated method stub
		
	}

	public Object playBattleships(String nick, String actualInterlocutor) {
		BattleshipGame battleshipGame = new BattleshipGame(nick, actualInterlocutor);
		BattleshipView battleshipView = new BattleshipView(nick, actualInterlocutor, client);
		battleshipGamesManager.addBattleshipGame(battleshipGame, battleshipView);
		battleshipView.showBattleshipBoards();

		return battleshipGame;
	}

	public Object sendBattleshipGame(String nick, String actualInterlocutor, ActionEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

}
