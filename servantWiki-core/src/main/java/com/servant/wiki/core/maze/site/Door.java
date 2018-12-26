package com.servant.wiki.core.maze.site;

public class Door implements MapSite{

	private Room r1;
	
	private Room r2;
	
	private boolean isOpen;
	
	public Door(Room r1, Room r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	public Room otherSideFrom(Room room){
		return null;
	}

	public Room getR1() {
		return r1;
	}

	public void setR1(Room r1) {
		this.r1 = r1;
	}

	public Room getR2() {
		return r2;
	}

	public void setR2(Room r2) {
		this.r2 = r2;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}
	
}
