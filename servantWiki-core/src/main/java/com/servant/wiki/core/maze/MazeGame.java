package com.servant.wiki.core.maze;

import com.servant.wiki.core.maze.site.Direction;
import com.servant.wiki.core.maze.site.Door;
import com.servant.wiki.core.maze.site.Room;
import com.servant.wiki.core.maze.site.Wall;

public class MazeGame extends Maze{

	@Override
	public void addRoom(Room room) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Room roomNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	public Maze createMaze(){
		Maze maze = new MazeGame();
		Room r1 = new Room(1);
		Room r2 = new Room(2);
		Door door = new Door(r1, r2);
		maze.addRoom(r1);
		maze.addRoom(r2);
		r1.setSide(Direction.North.getCode(), new Wall());
		r1.setSide(Direction.East.getCode(), door);
		r1.setSide(Direction.South.getCode(), new Wall());
		r1.setSide(Direction.West.getCode(), new Wall());
		
		r2.setSide(Direction.North.getCode(), new Wall());
		r2.setSide(Direction.West.getCode(), door);
		r2.setSide(Direction.South.getCode(), new Wall());
		r2.setSide(Direction.East.getCode(), new Wall());
		
		return maze;
	}
}
