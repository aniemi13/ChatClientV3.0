package com.niemiec.battleship.logic;

import com.niemiec.battleship.game.logic.BorderManagement;
import com.niemiec.battleship.game.objects.Player;
import com.niemiec.battleship.manager.BattleshipGame;
import com.niemiec.battleship.manager.BattleshipGamesManager;
import com.niemiec.battleship.view.BattleshipView;
import com.niemiec.chat.objects.Client;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class BattleshipManagement {
	private Client client;
	private String nick;
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
		case BattleshipGame.ADD_SHIPS:
			receiveAddShips(battleshipGame);
			break;
		case BattleshipGame.START_THE_GAME:
			receiveStartTheGame(battleshipGame);
			break;
//		case BattleshipGame.UPDATE_BATTLESHIPGAME:
//			receiveUpdateBattleshipGame(battleshipGame);
//			break;
		}
	}

	private void receiveGameProposal(BattleshipGame battleshipGame) {
		String nick = battleshipGame.getInvitingPlayerNick();
		String opponentPlayerNick = battleshipGame.getOpponentPlayerNick();
		BattleshipView battleshipView = new BattleshipView(nick, opponentPlayerNick, client, this);
		battleshipGamesManager.addBattleshipGame(battleshipGame, battleshipView);
		battleshipView.showAcceptanceWindow();
	}

	private void receiveRejectionGameProposal(BattleshipGame battleshipGame) {
		String opponentPlayerNick = battleshipGame.getOpponentPlayerNick();
		BattleshipView battleshipView = battleshipGamesManager.getBattleshipView(opponentPlayerNick);
		battleshipView.closeWaitingWindow();
		battleshipView.showInformationAndAcceptanceWindow("Użytkownik " + opponentPlayerNick + " nie zaakceptował gry");
	}

	private void receiveAddShips(BattleshipGame battleshipGame) {
		String opponentPlayerNick = battleshipGame.getOpponentPlayerNick();
		BattleshipView battleshipView = battleshipGamesManager.getBattleshipView(opponentPlayerNick);
		battleshipGamesManager.updateBattleshipGame(battleshipGame);
		if (battleshipGamesManager.getBattleshipView(opponentPlayerNick).getWaitingWindowController() != null)
			battleshipView.closeWaitingWindow();
		battleshipView.showBattleshipWindow();
		Platform.runLater(() -> {
			BorderManagement.startNewGameWithVirtualPlayer();
		});
	}

	private void receiveStartTheGame(BattleshipGame battleshipGame) {
		updateBorder(battleshipGame);
		if (battleshipGame.getNickWhoseTourn().equals(nick)) {
			BorderManagement.setBordersToStartShot();
		}
	}

	private void updateBorder(BattleshipGame battleshipGame) {
		BorderManagement.drawBoardInMyBorder(battleshipGame.getPlayer());
		BorderManagement.drawOpponentBoardInOpponentBorder(battleshipGame.getPlayer());
	}

	public Object playBattleship(String nick, String opponentPlayerNick) {
		BattleshipGame battleshipGame = new BattleshipGame(nick, opponentPlayerNick);
		BattleshipView battleshipView = new BattleshipView(nick, opponentPlayerNick, client, this);
		battleshipGamesManager.addBattleshipGame(battleshipGame, battleshipView);
		battleshipView.showWaitingWindow("Oczekiwanie na akcpetację użytkownika " + opponentPlayerNick);
		return battleshipGame;
	}

	public Object sendBattleshipGame(String opponentPlayerNick, ActionEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object sendAcceptTheBattleshipGame(boolean isAccept, String opponentPlayerNick) {
		BattleshipGame battleshipGame = battleshipGamesManager.getBattleshipGame(opponentPlayerNick);
		if (isAccept) {
			battleshipGame.setGameStatus(BattleshipGame.ACCEPTING_THE_GAME);
		} else {
			battleshipGame.setGameStatus(BattleshipGame.REJECTION_GAME_PROPOSAL);
		}
		battleshipGamesManager.getBattleshipView(opponentPlayerNick).closeAcceptanceWindow();
		return battleshipGame;
	}

	public boolean whetherTheBattleshipGameExists(String opponentPlayerNick) {
		return battleshipGamesManager.getBattleshipGame(opponentPlayerNick) != null;
	}

	public void acceptRejectionGameProspalInformation(String opponentPlayerNick) {
		BattleshipView battleshipView = battleshipGamesManager.getBattleshipView(opponentPlayerNick);
		battleshipView.closeInformationAndAcceptanceWindow();
		battleshipGamesManager.deleteBattleshipGame(opponentPlayerNick);
	}

	public Object sendShipsAdded(String opponentPlayerNick, Player player) {
		BattleshipGame battleshipGame = battleshipGamesManager.getBattleshipGame(opponentPlayerNick);
		battleshipGame.setGameStatus(BattleshipGame.SHIPS_ADDED);
		battleshipGame.setInvitingPlayer(player);

		return battleshipGame;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
}
