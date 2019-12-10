package es.valentelmadafaka.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import es.valentelmadafaka.game.Game;
import es.valentelmadafaka.utils.Functions;

public class Map {

	private int x;
	
	private int y;
	
	private JButton[][] buttons;
	
	private JPanel panel;
	
	private int sizeX;
	
	private int sizeY;

	public Map(int x, int y, JPanel panel) {
		super();
		this.x = x;
		this.y = y;
		this.panel = panel;
		this.buttons = new JButton[x][y];
		Dimension d = panel.getSize();
		sizeY = d.height/y;
		sizeX = d.width/x;
	}
	
	public void crearTablero() {
		for(int c= 0; c<x; c++) {
			for(int r = 0; r<y; r++) {
				JButton b = new JButton();
				b.setBounds(sizeX*c,sizeY*r,sizeX,sizeY);
				b.setName("vacio");
				b.setBackground(Color.GREEN);
				panel.add(b);
				buttons[c][r]=b;
				b.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						seleccionar(b, buttons, x, y, sizeX, sizeY);
					}
				});
			}
		}
	}
	
	private void seleccionar(JButton b, JButton[][] c, int x, int y, int sizeX, int sizeY) {
		
		boolean encontrado = false;
		if(b.getName().equals("ch1") || b.getName().equals("ch2")) {
			for(int i=0; i<x; i++) {
				for(int e=0; e<y; e++) {
					if(c[i][e].getName().equals("seleccionado1") || c[i][e].getName().equals("seleccionado2")) {
						encontrado = true;
					}
				}
			}
			if(encontrado == false) {
				if(b.getName().equals("ch1")) {
					b.setName("seleccionado1");
					b.setIcon(new ImageIcon(Game.class.getResource("../icons/chSelected.jpg")));
				}
				if(b.getName().equals("ch2")) {
					b.setName("seleccionado2");
					b.setIcon(new ImageIcon(Game.class.getResource("../icons/chSelected.jpg")));
				}
			}
		}else {
			if(b.getName().equals("seleccionado1")) {
				b.setName("ch1");
				b.setIcon(new ImageIcon(Game.class.getResource("../icons/chOne.jpg")));
			}
			if(b.getName().equals("seleccionado2")) {
				b.setName("ch2");
				b.setIcon(new ImageIcon(Game.class.getResource("../icons/chTwo.jpg")));
			}
			if(b.getName().equals("vacio")) {
				for(int i=0; i<x; i++) {
					for(int e=0; e<y; e++) {
						if(c[i][e].getName().equals("seleccionado1")) {
							//if(!m.comer(c[i][e], c)) {
								if(b.getX()==c[i][e].getX()+sizeX || b.getY() == c[i][e].getY()+sizeY || b.getX()==c[i][e].getX()-sizeX || b.getY() == c[i][e].getY()-sizeY ) {
									b.setIcon(new ImageIcon(Game.class.getResource("../icons/chOne.jpg")));
									b.setName("ch1");
									c[i][e].setIcon(null);
									c[i][e].setName("vacio");
							}
						}
						if(c[i][e].getName().equals("seleccionado2")) {
							if(b.getX()==c[i][e].getX()+sizeX || b.getY() == c[i][e].getY()-sizeY || b.getX()==c[i][e].getX()-sizeX || b.getY() == c[i][e].getY()+sizeY) {
								b.setIcon(new ImageIcon(Game.class.getResource("../icons/chTwo.jpg")));
								b.setName("ch2");
								c[i][e].setIcon(null);
								c[i][e].setName("vacio");
							}
							/*else {
								if(b.getX()==c[i][e].getX()+80 & b.getY() == c[i][e].getY()-80) {
									for(int j=0; j<4; j++) {
										for(int s=0; s<8; s++) {
											if(c[s][j].getName().equals("negra") & c[s][j].getX() == c[i][e].getX()+40 & c[s][j].getY() == c[i][e].getY()-40) {
												c[s][j].setName("vacia");
												c[s][j].setIcon(null);
												b.setIcon(new ImageIcon(Main.class.getResource("/iconos/blanca.png")));
												b.setName("blanca");
												if(!m.comer(b, c)) {
													m.setTurno("negras");
												}
												c[i][e].setIcon(null);
												c[i][e].setName("vacia");
												m.setPuntos1(m.getPuntos1()+2);
											}
										}
									}
								}*/
								/*if(b.getX()==c[i][e].getX()-80 & b.getY() == c[i][e].getY()-80) {
									for(int j=0; j<4; j++) {
										for(int s=0; s<8; s++) {
											if(c[s][j].getName().equals("negra") & c[s][j].getX() == c[i][e].getX()-40 & c[s][j].getY() == c[i][e].getY()-40) {
												c[s][j].setName("vacia");
												c[s][j].setIcon(null);
												b.setIcon(new ImageIcon(Main.class.getResource("/iconos/blanca.png")));
												b.setName("blanca");
												if(!m.comer(b, c)) {
													m.setTurno("negras");
												}
												c[i][e].setIcon(null);
												c[i][e].setName("vacia");
												m.setPuntos1(m.getPuntos1()+2);
											}
										}
									}
								}*/
							}
						}
					}
				}
			}
		}

	/*public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}*/

	public JButton[][] getButtons() {
		return buttons;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}
}
