package com.niemiec.chat.objects;

import com.niemiec.battleship.logic.BattleshipManagement;
import com.niemiec.chat.connection.Connection;
import com.niemiec.chat.controllers.ChatController;
import com.niemiec.chat.controllers.GetNickController;
import com.niemiec.chat.logic.MessagesManagement;

import javafx.event.ActionEvent;

public class Client {
	private Connection connection;
	private MessagesManagement messagesManagement;

	public Client(String host, int port) {
		messagesManagement = new MessagesManagement(this);
		connection = new Connection(messagesManagement, host, port);
		connection.start();
	}

	public void setUserNickToPrivateMessage(String actualInterlocutor) {
		messagesManagement.setActualInterlocutor(actualInterlocutor);
	}

	public void sendToGeneralChat(String message) {
		connection.sendTheObject(messagesManagement.sendToGeneralChat(message));
	}

	public void sendToPrivateChat(String message) {
		connection.sendTheObject(messagesManagement.sendToPrivateChat(message));
	}

	public void exit() {
		connection.sendTheObject(messagesManagement.exit());
		connection.interrupt();
	}

	public void setNick(String nick) {
		messagesManagement.setNick(nick);
	}

	public void readyToWork() {
		connection.sendTheObject(messagesManagement.sendReadyToWork());
	}

	public void setGetNickController(GetNickController getNickController) {
		messagesManagement.setGetNickController(getNickController);
	}

	public void setChatController(ChatController chatController) {
		messagesManagement.setChatController(chatController);
	}

	public void sendNickToCheck(String nick) {
		connection.sendTheObject(messagesManagement.sendNickToCheck(nick));
	}

	public void playBattleships() {
		connection.sendTheObject(messagesManagement.playBattleship());
	}
	
	public void sendBattleshipGame(ActionEvent event) {
		connection.sendTheObject(messagesManagement.sendBattleshipGame(event));
	}
}
