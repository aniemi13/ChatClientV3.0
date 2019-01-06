package com.niemiec.battleship.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WaitingWindowController {
	@FXML
	private Label label;
	private boolean visible;

	@FXML
	void initialize() {
		visible = false;
	}

	public void setTextLabel(String string) {
		label.setText(string);
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
