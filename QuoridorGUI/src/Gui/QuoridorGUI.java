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

public class QuoridorGUI extends JFrame {

	private static final long serialVersionUID = -8122266587490682878L;
	
	private Canvas canvas;
	private JPanel mainPanel;
	private JPanel wallsPanel;
	private JLabel numWallsP1;
	private JLabel numWallsP2;
	// private String[] options = { "Play Again", "Quit" };
	
	public QuoridorGUI() {
		super("Quoridor");
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(450, 450));
		
		JPanel auxPanel = new JPanel();
		auxPanel.setLayout(new BorderLayout());
		auxPanel.setBackground(new Color(71, 164, 201));
		auxPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		auxPanel.add(canvas, BorderLayout.CENTER);
		
		/*canvas.add(b);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showOptionDialog(frame, "Winner: ", "Game Over",
						 JOptionPane.YES_NO_CANCEL_OPTION,
						 JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);
				System.out.println(n);
			}
		});*/
		
		numWallsP1 = new JLabel("Player 1 Walls: 10", SwingConstants.CENTER);
		numWallsP2 = new JLabel("Player 2 Walls: 10", SwingConstants.CENTER);
		numWallsP1.setBorder(new EmptyBorder(10, 10, 10, 10));
		numWallsP2.setBorder(new EmptyBorder(10, 10, 10, 10));
		numWallsP1.setForeground(new Color(0, 128, 0));
		numWallsP2.setForeground(new Color(255, 0, 0));
		
		wallsPanel = new JPanel();
		wallsPanel.setLayout(new GridLayout(1, 2));
		wallsPanel.add(numWallsP1);
		wallsPanel.add(numWallsP2);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(auxPanel, BorderLayout.CENTER);
		mainPanel.add(wallsPanel, BorderLayout.PAGE_START);

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
	
	public static void main(String[] args) {
		new QuoridorGUI();
	}
}
