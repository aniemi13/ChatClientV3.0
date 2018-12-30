package com.niemiec.battleship.manager;

public class BattleshipGame {
	public final int GAME_PROPOSAL = 10;
	public final int REJECTION_GAME_PROPOSAL = 11;
	public final int ACCEPTING_THE_GAME = 12;
	public final int SHIPS_ADDED = 13;
	public final int START_THE_GAME = 14;
	
	private final int INVITING_PLAYER = 0;
	private final int OPPONENT_PLAYER = 1;
	
	private String[] players;
	
	private int gameStatus;
	
	public BattleshipGame(String invitingPlayer, String opponentPlayer) {
		players = new String[] {invitingPlayer, opponentPlayer};
		gameStatus = GAME_PROPOSAL;
	}

	public String getOpponentPlayerNick() {
		return players[OPPONENT_PLAYER];
	}
	
	public String getInvitingPlayerNick() {
		return players[INVITING_PLAYER];
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
}
