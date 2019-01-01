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
		switch (battleshipGame.getGameStatus()) {
		case BattleshipGame.GAME_PROPOSAL:
			receiveGameProposal(battleshipGame);
			break;
		case BattleshipGame.REJECTION_GAME_PROPOSAL:
			receiveRejectionGameProposal(battleshipGame);
			break;
		case BattleshipGame.ACCEPTING_THE_GAME:
			receiveAcceptingTheGame(battleshipGame);
			break;
		case BattleshipGame.START_THE_GAME:
			receiveStartTheGame(battleshipGame);
			break;
		case BattleshipGame.UPDATE_BATTLESHIPGAME:
			receiveUpdateBattleshipGame(battleshipGame);
			break;
		}
	}

	private void receiveGameProposal(BattleshipGame battleshipGame) {
		// TODO Auto-generated method stub
		// zmiana okna oczekiwania na okno z planszami
		// zaczęscie dodawania statków
		// po dodaniu zamiana gameStatus na ship_added i wysłanie komunikatu do serwera
		String nick = battleshipGame.getInvitingPlayerNick();
		String opponentPlayerNick = battleshipGame.getOpponentPlayerNick();
		BattleshipView battleshipView = new BattleshipView(nick, opponentPlayerNick, client, this);
		battleshipGamesManager.addBattleshipGame(battleshipGame, battleshipView);
		System.out.println("OpponentPlayerNick: " + opponentPlayerNick);
		battleshipView.showAcceptanceWindow();
		// ZABLOKOWAĆ PRZYCISK GRAJ PRZY DANYM GRACZU
	}

	private void receiveRejectionGameProposal(BattleshipGame battleshipGame) {
		// TODO Auto-generated method stub

	}

	private void receiveAcceptingTheGame(BattleshipGame battleshipGame) {
		// TODO Auto-generated method stub

	}

	private void receiveStartTheGame(BattleshipGame battleshipGame) {
		// TODO Auto-generated method stub

	}

	private void receiveUpdateBattleshipGame(BattleshipGame battleshipGame) {
		// TODO Auto-generated method stub

	}

	public Object playBattleship(String nick, String opponentPlayerNick) {
		BattleshipGame battleshipGame = new BattleshipGame(nick, opponentPlayerNick);
		BattleshipView battleshipView = new BattleshipView(nick, opponentPlayerNick, client, this);
		battleshipGamesManager.addBattleshipGame(battleshipGame, battleshipView);
		battleshipView.showWaitingWindow("Oczekiwanie na akcpetację użytkownika " + opponentPlayerNick);
		// TODO wyświetlić okno oczekiwania na akceptację
		// jeżeli nie zaakceptowane to komunikat, wciskamy OK i dane BattleshipGame i
		// BattleshipView są usuwane
		// jeżeli zaakceptowane wyświetlamy planszę
		return battleshipGame;
		// ZABLOKOWAĆ PRZYCISK GRAJ PRZY DANYM GRACZU
	}

	public Object sendBattleshipGame(String opponentPlayerNick, ActionEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object sendAcceptTheBattleshipGame(boolean isAccept, String opponentPlayerNick) {
		BattleshipGame battleshipGame = battleshipGamesManager.getBattleshipGame(opponentPlayerNick);
		BattleshipView battleshipView = battleshipGamesManager.getBattleshipView(opponentPlayerNick);
		if (isAccept) {
			battleshipGame.setGameStatus(BattleshipGame.ACCEPTING_THE_GAME);
			// TODO Wyświetl pole gry, zamknij okno z pytaniem
			battleshipView.closeAcceptanceWindow();
			battleshipView.showBattleshipWindow();
			
		} else {
			battleshipGame.setGameStatus(BattleshipGame.REJECTION_GAME_PROPOSAL);
		}

		return battleshipGame;
	}

	public boolean whetherTheBattleshipGameExists(String opponentPlayerNick) {
		System.out.println("Jestem w funkcji sprawdzjącej istnieje BattleshipGame: " + opponentPlayerNick);
		return battleshipGamesManager.getBattleshipGame(opponentPlayerNick) != null;
	}
}
