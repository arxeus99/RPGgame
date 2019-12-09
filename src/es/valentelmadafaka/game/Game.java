package es.valentelmadafaka.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

import es.valentelmadafaka.utils.Functions;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.BorderLayout;

public class Game {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		JButton[][] buttons = new JButton[10][10];
		
		
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 520, 550));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Functions.crearTablero(panel,buttons,10,50);
		buttons[0][0].setIcon(new ImageIcon(Game.class.getResource("../icons/chOne.jpg")));
		buttons[0][0].setName("ch1");
		buttons[9][9].setIcon(new ImageIcon(Game.class.getResource("../icons/chTwo.jpg")));
		buttons[9][9].setName("ch2");
		
		
	}

}
