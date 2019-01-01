package com.niemiec.battleship.manager;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BattleshipGame implements Serializable {
	public static final int GAME_PROPOSAL = 10;
	public static final int REJECTION_GAME_PROPOSAL = 11;
	public static final int ACCEPTING_THE_GAME = 12;
	public static final int SHIPS_ADDED = 13; //tej informacji będzie potrzebował tylko serwer
	public static final int START_THE_GAME = 14;
	public static final int UPDATE_BATTLESHIPGAME = 15;
	
	private String invitingPlayerNick;
	private String opponentPlayerNick;
	
	private int gameStatus;
	private int index; // numer Battleship w serwerze
	
	public BattleshipGame(String invitingPlayerNick, String opponentPlayerNick) {
		this.invitingPlayerNick = invitingPlayerNick;
		this.opponentPlayerNick = opponentPlayerNick;
		gameStatus = GAME_PROPOSAL;
	}

	public String getOpponentPlayerNick() {
		return opponentPlayerNick;
	}
	
	public String getInvitingPlayerNick() {
		return invitingPlayerNick;
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public int getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(int gameStatus) {
		this.gameStatus = gameStatus;
	}
	
	public void setGameIndex(int index) {
		this.index = index;
	}
	
	public int getGameIndex() {
		return index;
	}

	public void createBattleshipGameForOpponent() {
		String a = new String(invitingPlayerNick);
		invitingPlayerNick =  new String(opponentPlayerNick);
		opponentPlayerNick = a;
	}
}
