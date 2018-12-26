package com.servant.wiki.core.maze.site;

public class Room implements MapSite {

	private int roomNum;
	
	private MapSite[] sides;
	
	public Room(int roomNum) {
		this.roomNum = roomNum;
		sides = new MapSite[4];
	}
	
	public MapSite getSide(int direct){
		return null;
	}
	
	public void setSide(int direct, MapSite	side){
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}
}
