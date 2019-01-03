package com.niemiec.battleship.manager;

import java.util.ArrayList;

import com.niemiec.battleship.controllers.MainScreenController;
import com.niemiec.battleship.view.BattleshipView;

public class BattleshipGamesManager {
	private ArrayList<String> opponentPlayers;
	private ArrayList<BattleshipGame> battleshipGames;
	private ArrayList<BattleshipView> battleshipViews;
	private ArrayList<MainScreenController> mainScreenControllers;
	
	public BattleshipGamesManager() {
		this.opponentPlayers = new ArrayList<>();
		this.battleshipGames = new ArrayList<>();
		this.battleshipViews = new ArrayList<>();
		this.mainScreenControllers = new ArrayList<>();
	}
	

	public void addBattleshipGame(BattleshipGame battleshipGame, BattleshipView battleshipView) {
		opponentPlayers.add(battleshipGame.getOpponentPlayerNick());
		battleshipGames.add(battleshipGame);
		battleshipViews.add(battleshipView);
		mainScreenControllers.add(battleshipView.getMainScreenController());
	}
	
	public BattleshipGame getBattleshipGame(String opponentPlayerNick) {
		for (int i = 0; i < opponentPlayers.size(); i++) {
			if (opponentPlayers.get(i).equals(opponentPlayerNick)) {
				return battleshipGames.get(i);
			}
		}
		return null;
	}

	public BattleshipView getBattleshipView(String opponentPlayerNick) {
		for (int i = 0; i < opponentPlayers.size(); i++) {
			if (opponentPlayers.get(i).equals(opponentPlayerNick)) {
				return battleshipViews.get(i);
			}
		}
		return null;
	}
	
	public MainScreenController getMainScreenController(String opponentPlayerNick) {
		for (int i = 0; i < opponentPlayers.size(); i++) {
			if (opponentPlayers.get(i).equals(opponentPlayerNick)) {
				return mainScreenControllers.get(i);
			}
		}
		return null;
	}
	
	public void deleteBattleshipGame(String opponentPlayerNick) {
		for (int i = 0; i < opponentPlayers.size(); i++) {
			if (opponentPlayers.get(i).equals(opponentPlayerNick)) {
				battleshipGames.get(i).delete();
				battleshipGames.remove(i);
				battleshipViews.remove(i);
				mainScreenControllers.remove(i);
				opponentPlayers.remove(i);
				return;
			}
		}
	}
}
