package Gui;

public class Tile {
	
	private int x, y;
	private int width, height;
	private boolean taken = false;

	public Tile(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	
	public boolean contains(int x, int y) {
		return x < this.x + (width / 2) && x > this.x - (width / 2) && y < this.y + (height / 2) && y > this.y - (height / 2);
	}
}
