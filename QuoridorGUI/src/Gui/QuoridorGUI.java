package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Quoridor.Game;

public class QuoridorGUI extends JFrame {

	private static final long serialVersionUID = -8122266587490682878L;
	
	private Game game;
	private Canvas canvas;
	
	private JPanel mainPanel;
	private JPanel wallsPanel;
	
	private JLabel turnLabel;
	private JLabel numWallsP1;
	private JLabel numWallsP2;
	
	public QuoridorGUI() {
		super("Quoridor");
		
		game = new Game();
		
		canvas = new Canvas(this);
		canvas.setPreferredSize(new Dimension(450, 450));
		
		JPanel auxPanel = new JPanel();
		auxPanel.setLayout(new BorderLayout());
		auxPanel.setBackground(new Color(71, 164, 201));
		auxPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		auxPanel.add(canvas, BorderLayout.CENTER);
		
		turnLabel = new JLabel("Turn: Player " + game.getTurn(), SwingConstants.CENTER);
		turnLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		numWallsP1 = new JLabel("Player 1 Walls: " + game.getPlayer1().getNumWalls(), SwingConstants.CENTER);
		numWallsP2 = new JLabel("Player 2 Walls: " + game.getPlayer2().getNumWalls(), SwingConstants.CENTER);
		numWallsP1.setBorder(new EmptyBorder(5, 5, 5, 5));
		numWallsP2.setBorder(new EmptyBorder(5, 5, 5, 5));
		numWallsP1.setForeground(new Color(0, 128, 0));
		numWallsP2.setForeground(new Color(255, 0, 0));
		
		wallsPanel = new JPanel();
		wallsPanel.setLayout(new GridLayout(1, 2));
		wallsPanel.add(numWallsP1);
		wallsPanel.add(numWallsP2);
		
		JPanel topAuxPanel = new JPanel();
		topAuxPanel.setLayout(new GridLayout(2, 1));
		topAuxPanel.add(turnLabel);
		topAuxPanel.add(wallsPanel);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(auxPanel, BorderLayout.CENTER);
		mainPanel.add(topAuxPanel, BorderLayout.PAGE_START);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int) screenSize.getWidth() / 2;
		int centerY = (int) screenSize.getHeight() / 2;

		setResizable(false);
		setContentPane(mainPanel);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		setVisible(true);
	}
	
	public Game getGame() {
		return game;
	}
	
	public void resetGame() {
		game = new Game();
	}
	
	public void updateInfo() {
		turnLabel.setText("Turn: Player " + game.getTurn());
		numWallsP1.setText("Player 1 Walls: " + game.getPlayer1().getNumWalls());
		numWallsP2.setText("Player 2 Walls: " + game.getPlayer2().getNumWalls());
	}
	
	public static void main(String[] args) {
		new QuoridorGUI();
	}
}
