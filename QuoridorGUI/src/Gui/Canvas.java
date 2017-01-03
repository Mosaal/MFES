package Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 3640767985329569838L;

	private Tile[][] pawnGrid;
	private Tile[][] wallsGridVer;
	private Tile[][] wallsGridHor;
	private BufferedImage tileImage;
	private BufferedImage glowTileImage;
	private BufferedImage player1Image;
	private BufferedImage player2Image;
	
	public Canvas() {
		pawnGrid = new Tile[9][9];
		for (int i = 0; i < pawnGrid.length; i++)
			for (int j = 0; j < pawnGrid[i].length; j++)
				pawnGrid[i][j] = new Tile(25 + (50 * j), 25 + (50 * i), 40, 40);
		
		wallsGridVer = new Tile[9][8];
		for (int i = 0; i < wallsGridVer.length; i++)
			for (int j = 0; j < wallsGridVer[i].length; j++)
				wallsGridVer[i][j] = new Tile(50 + (50 * j), 25 + (50 * i), 10, 40);
		
		wallsGridHor = new Tile[8][9];
		for (int i = 0; i < wallsGridHor.length; i++)
			for (int j = 0; j < wallsGridHor[i].length; j++)
				wallsGridHor[i][j] = new Tile(25 + (50 * j), 50 + (50 * i), 40, 10);
		
		try {
			tileImage = ImageIO.read(new File("images/tile.png"));
			glowTileImage = ImageIO.read(new File("images/glowTile.png"));
			player1Image = ImageIO.read(new File("images/greenTile.png"));
			player2Image = ImageIO.read(new File("images/redTile.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < pawnGrid.length; i++) {
					for (int j = 0; j < pawnGrid[i].length; j++) {
						if (pawnGrid[i][j].contains(e.getX(), e.getY()))
							System.out.println("Pawn cell: " + j + ", " + i);
					}
				}
				
				for (int i = 0; i < wallsGridVer.length; i++) {
					for (int j = 0; j < wallsGridVer[i].length; j++) {
						if (wallsGridVer[i][j].contains(e.getX(), e.getY()))
							System.out.println("Ver. wall cell: " + j + ", " + i);
					}
				}
				
				for (int i = 0; i < wallsGridHor.length; i++) {
					for (int j = 0; j < wallsGridHor[i].length; j++) {
						if (wallsGridHor[i][j].contains(e.getX(), e.getY()))
							System.out.println("Hor. wall cell: " + j + ", " + i);
					}
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw grid
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				g.drawImage(tileImage, j * tileImage.getWidth(), i * tileImage.getHeight(), null);
		
		// Draw pawn pieces
		g.drawImage(player1Image, 4 * player1Image.getWidth(), 8 * player1Image.getHeight(), null);
		g.drawImage(player2Image, 4 * player2Image.getWidth(), 0 * player2Image.getHeight(), null);
		
		// Draw glowing tiles
		g.drawImage(glowTileImage, 3 * glowTileImage.getWidth(), 8 * glowTileImage.getHeight(), null);
		g.drawImage(glowTileImage, 4 * glowTileImage.getWidth(), 7 * glowTileImage.getHeight(), null);
		g.drawImage(glowTileImage, 5 * glowTileImage.getWidth(), 8 * glowTileImage.getHeight(), null);
		
		// Draw wall pieces
		g.setColor(new Color(110, 110, 110));
		g.fillRect(45, 5, 10, 90);
	}
}
