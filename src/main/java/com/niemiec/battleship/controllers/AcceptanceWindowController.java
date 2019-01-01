package com.niemiec.battleship.controllers;

import com.niemiec.battleship.logic.BattleshipManagement;
import com.niemiec.chat.objects.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AcceptanceWindowController {
	@FXML
	private Label label;

	@FXML
	private Button okButton;

	@FXML
	private Button rejectionButton;

	private BattleshipManagement battleshipManagement;
	private String opponentPlayerNick;
	private Client client;

	@FXML
	void accept(ActionEvent event) {
		client.acceptTheBattleshipGame(true, opponentPlayerNick);
	}

	@FXML
	void rejectionGameProposal(ActionEvent event) {
		client.acceptTheBattleshipGame(false, opponentPlayerNick);
	}

	public void setTextLabel(String text) {
		label.setText(text);
	}

	public void setOpponentPlayerNick(String opponentPlayerNick) {
		this.opponentPlayerNick = opponentPlayerNick;
	}

	@FXML
	void initialize() {
	}

	public void setBattleshipManagement(BattleshipManagement battleshipManagement) {
		this.battleshipManagement = battleshipManagement;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}