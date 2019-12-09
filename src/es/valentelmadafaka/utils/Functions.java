package es.valentelmadafaka.utils;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import es.valentelmadafaka.game.Game;


public abstract class Functions {

	
	public static void crearTablero(JPanel p,JButton[][] buttons, int cantidad, int tamaño) {
		for(int c= 0; c<cantidad; c++) {
			for(int r = 0; r<cantidad; r++) {
				JButton b = new JButton();
				b.setBounds(tamaño*c,tamaño*r,tamaño,tamaño);
				b.setName("vacio");
				b.setBackground(Color.GREEN);
				p.add(b);
				buttons[c][r]=b;
				b.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Functions.seleccionar(b, buttons, cantidad, tamaño);
					}
				});
			}
		}
	}
	
	public static void seleccionar(JButton b, JButton[][] c, int cantidad, int tamaño) {
		
		boolean encontrado = false;
		if(b.getName().equals("ch1") || b.getName().equals("ch2")) {
			for(int i=0; i<cantidad; i++) {
				for(int e=0; e<cantidad; e++) {
					if(c[e][i].getName().equals("seleccionado1") || c[e][i].getName().equals("seleccionado2")) {
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
				for(int i=0; i<cantidad; i++) {
					for(int e=0; e<cantidad; e++) {
						if(c[e][i].getName().equals("seleccionado1")) {
							//if(!m.comer(c[e][i], c)) {
								if(b.getX()==c[e][i].getX()+tamaño || b.getY() == c[e][i].getY()+tamaño || b.getX()==c[e][i].getX()-tamaño || b.getY() == c[e][i].getY()-tamaño ) {
									b.setIcon(new ImageIcon(Game.class.getResource("../icons/chOne.jpg")));
									b.setName("ch1");
									c[e][i].setIcon(null);
									c[e][i].setName("vacio");
								}
							/*}else {
								if(b.getX()==c[e][i].getX()+80 & b.getY() == c[e][i].getY()+80) {
									for(int j=0; j<4; j++) {
										for(int s=0; s<8; s++) {
											if(c[s][j].getName().equals("blanca") & c[s][j].getX() == c[e][i].getX()+40 & c[s][j].getY() == c[e][i].getY()+40) {
												c[s][j].setName("vacia");
												c[s][j].setIcon(null);
												b.setIcon(new ImageIcon(Main.class.getResource("/iconos/negra.png")));
												b.setName("negra");
												if(!m.comer(b, c)) {
													m.setTurno("blancas");
												}
												c[e][i].setIcon(null);
												c[e][i].setName("vacia");
												m.setPuntos2(m.getPuntos2()+2);
											}
										}
									}
								}
								if(b.getX()==c[e][i].getX()-80 & b.getY() == c[e][i].getY()+80) {
									for(int j=0; j<4; j++) {
										for(int s=0; s<8; s++) {
											if(c[s][j].getName().equals("blanca") & c[s][j].getX() == c[e][i].getX()-40 & c[s][j].getY() == c[e][i].getY()+40) {
												c[s][j].setName("vacia");
												c[s][j].setIcon(null);
												b.setIcon(new ImageIcon(Main.class.getResource("/iconos/negra.png")));
												b.setName("negra");
												if(!m.comer(b, c)) {
													m.setTurno("blancas");
												}
												c[e][i].setIcon(null);
												c[e][i].setName("vacia");
												m.setPuntos2(m.getPuntos2()+2);
											}
										}
									}
								}
							}*/
						}
						if(c[e][i].getName().equals("seleccionado2")) {
							if(b.getX()==c[e][i].getX()+tamaño || b.getY() == c[e][i].getY()-tamaño || b.getX()==c[e][i].getX()-tamaño || b.getY() == c[e][i].getY()+tamaño) {
								b.setIcon(new ImageIcon(Game.class.getResource("../icons/chTwo.jpg")));
								b.setName("ch2");
								c[e][i].setIcon(null);
								c[e][i].setName("vacio");
							}
							/*else {
								if(b.getX()==c[e][i].getX()+80 & b.getY() == c[e][i].getY()-80) {
									for(int j=0; j<4; j++) {
										for(int s=0; s<8; s++) {
											if(c[s][j].getName().equals("negra") & c[s][j].getX() == c[e][i].getX()+40 & c[s][j].getY() == c[e][i].getY()-40) {
												c[s][j].setName("vacia");
												c[s][j].setIcon(null);
												b.setIcon(new ImageIcon(Main.class.getResource("/iconos/blanca.png")));
												b.setName("blanca");
												if(!m.comer(b, c)) {
													m.setTurno("negras");
												}
												c[e][i].setIcon(null);
												c[e][i].setName("vacia");
												m.setPuntos1(m.getPuntos1()+2);
											}
										}
									}
								}
								if(b.getX()==c[e][i].getX()-80 & b.getY() == c[e][i].getY()-80) {
									for(int j=0; j<4; j++) {
										for(int s=0; s<8; s++) {
											if(c[s][j].getName().equals("negra") & c[s][j].getX() == c[e][i].getX()-40 & c[s][j].getY() == c[e][i].getY()-40) {
												c[s][j].setName("vacia");
												c[s][j].setIcon(null);
												b.setIcon(new ImageIcon(Main.class.getResource("/iconos/blanca.png")));
												b.setName("blanca");
												if(!m.comer(b, c)) {
													m.setTurno("negras");
												}
												c[e][i].setIcon(null);
												c[e][i].setName("vacia");
												m.setPuntos1(m.getPuntos1()+2);
											}
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
	
}
