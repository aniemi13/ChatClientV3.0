package com.niemiec.battleship.view;

import com.niemiec.battleship.controllers.MainScreenController;
import com.niemiec.chat.objects.Client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BattleshipView {
	private String nick;
	private String opponentNick;
	private Client client;
	private MainScreenController mainScreenController;
	private FXMLLoader loader;
	private VBox vBox;
	
	public BattleshipView(String nick, String opponentNick, Client client) {
		this.nick = nick;
		this.opponentNick = opponentNick;
		this.client = client;
		loadFXMLLoaderAndController();
	}
	

	private void loadFXMLLoaderAndController() {
		loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
		vBox = null;
		try {
			vBox = loader.load();
		} catch (Exception e) {
		}
		mainScreenController = loader.getController();
		mainScreenController.setClient(this.client);
	}


	public void showBattleshipBoards() {
		Stage stage = new Stage();
		Scene scene = new Scene(vBox);
		stage.setTitle("Battleship: " + nick + " vs " + opponentNick);
		stage.setScene(scene);
		
		stage.show();
	}
	
	public MainScreenController getMainScreenController() {
		return mainScreenController;
	}
}
