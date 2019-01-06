package com.niemiec.battleship.game.objects;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PlayerImpl implements Player, Serializable {
	private String nick;
	public String getNick() {
		return nick;
	}

	private int typeOfPlayer;
	private Board board;
	private Board opponentBoard;
	private int sunkenShips;
	private CollectionShips collectionShips;
	private boolean onHit;
	private Coordinates coordinatesOnHit;
	private int directionOnHit;

	public PlayerImpl(int typeOfPlayer, String nick) {
		this.board = new Board();
		this.opponentBoard = new Board();
		this.collectionShips = new CollectionShips();
		this.typeOfPlayer = typeOfPlayer;
		this.nick = nick;
		this.sunkenShips = 0;
		resetHitData();

	}

	public void resetHitData() {
		onHit = false;
		coordinatesOnHit = new Coordinates();
		directionOnHit = Ship.SHIP_DIRECTION_NO_SPACE; 
	}

	public Board getBoard() {
		return board;
	}

	@Override
	public Board getOpponentBoard() {
		return opponentBoard;
	}

	@Override
	public int getSunkenShips() {
		return sunkenShips;
	}

	@Override
	public void increaseSunkenShips() {
		sunkenShips++;
	}

	@Override
	public CollectionShips getCollectionShips() {
		return collectionShips;
	}

	@Override
	public boolean isVirtualPlayer() {
		return (typeOfPlayer == Player.VIRTUAL_PLAYER) ? true : false;
	}

	@Override
	public boolean getInformationInThePlayerIsVirtual() {
		if (typeOfPlayer == Player.VIRTUAL_PLAYER)
			return true;
		return false;
	}

	public void setHitData(Coordinates coordinates) {
		onHit = true;
		coordinatesOnHit = new Coordinates(coordinates);
	}
	
	public boolean isOnHit() {
		return onHit;
	}

	public int getDirectionOnHit() {
		return directionOnHit;
	}

	public void setDirectionOnHit(int directionOnHit) {
		this.directionOnHit = directionOnHit;
	}
	
	public Coordinates getCoordinatesOnHit() {
		return this.coordinatesOnHit;
	}

}
