package es.valentelmadafaka.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

import es.valentelmadafaka.models.Map;
import es.valentelmadafaka.utils.Functions;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game {

	private JFrame frame;
	private JTextField textFieldX;
	private JTextField textFieldY;

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
		
		
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 520, 550));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 478, 367);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textFieldX = new JTextField();
		textFieldX.setBounds(72, 413, 116, 22);
		panel.add(textFieldX);
		textFieldX.setColumns(10);
		
		textFieldY = new JTextField();
		textFieldY.setBounds(255, 413, 116, 22);
		panel.add(textFieldY);
		textFieldY.setColumns(10);
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(88, 393, 56, 16);
		panel.add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setBounds(274, 393, 56, 16);
		panel.add(lblY);
		
		JButton btnCrearTablero = new JButton("CREAR TABLERO");
		btnCrearTablero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				Map m = new Map(Integer.parseInt(textFieldX.getText()),Integer.parseInt(textFieldY.getText()), panel_1);
				m.crearTablero();
				m.getButtons()[0][0].setIcon(new ImageIcon(Game.class.getResource("../icons/chOne.jpg")));
				m.getButtons()[0][0].setName("ch1");
				m.getButtons()[m.getButtons().length-1][m.getButtons()[0].length-1].setIcon(new ImageIcon(Game.class.getResource("../icons/chTwo.jpg")));
				m.getButtons()[m.getButtons().length-1][m.getButtons()[0].length-1].setName("ch2");
				panel_1.updateUI();
			}
		});
		
		btnCrearTablero.setBounds(72, 448, 299, 42);
		panel.add(btnCrearTablero);
		
		
		
	}
}
