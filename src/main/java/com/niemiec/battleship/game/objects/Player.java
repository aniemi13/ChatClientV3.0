package com.niemiec.battleship.game.objects;

public interface Player {
	public final static int VIRTUAL_PLAYER = 0;
	public final static int REAL_PLAYER = 1;
	
	public Board getBoard();
	public Board getOpponentBoard();
	
	public int getSunkenShips();
	public void increaseSunkenShips();
	
	public CollectionShips getCollectionShips();
	
	public boolean getInformationInThePlayerIsVirtual();
	public boolean isVirtualPlayer();
}
