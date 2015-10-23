package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Principal.Bomberman;
import Principal.ElementoEnCelda;
import Principal.Juego;
import Principal.Terreno;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class GUI extends JFrame{

	private JPanel contentPane;
	private JLabel lblNewLabel, bomba;
	private JLabel [][] matrizLabel;
	private Juego juego;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		juego= new Juego(this);
		
		matrizLabel = new JLabel[34][34];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1350, 1024);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

/* ESTO NO SE SI VA

		JPanel panel_1 = new JPanel(new GridLayout(34,34));
		panel_1.setBackground(Color.BLACK);
		JPanel panel = new JPanel();
		panel.setBounds(150, 150, 1024, 1024);
		panel.setLayout(null);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setAlignmentX(0);

		lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(58, 100, 81, 14);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel);
		
		*/
		
		
		
		
		
		
		
//		
//		JPanel panelGrilla= new JPanel();//(new GridLayout(34,34));
//		panelGrilla.setBackground(Color.WHITE);
//	
//		panelGrilla.setBounds(200, 200, 1024, 1024);
		//contentPane.add(panelGrilla);
	
		Terreno miTerreno = juego.getTerreno();
		ImageIcon imagenCelda;
		JLabel labelCelda;
		for (int i = 0; i < 34 ; i++)
		{
			for (int j = 0; j < 34; j++)
			{
				labelCelda=new JLabel();
				ElementoEnCelda elementoCelda= miTerreno.getCelda(i, j).obtenerElem();
				if (elementoCelda == null)
				{
					 imagenCelda= new ImageIcon(getClass().getResource("/images/Transitable.jpg"));
				}
				else
				{
					imagenCelda = elementoCelda.getImagen();
				}
				labelCelda.setIcon(imagenCelda);
				labelCelda.setBounds((i*32),(j*32),32,32);
				
				contentPane.add(labelCelda);
			}
		}
			
/*		VVVVVVVVVVVVVVEEEEEEEEEEEER
		
		JLabel lblJugador = new JLabel("Jugador:");
		lblJugador.setBounds(22, 11, 62, 19);
		panel.add(lblJugador);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setBounds(22, 29, 52, 14);
		panel.add(lblPuntaje);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setBounds(359, 11, 73, 32);
		panel.add(lblTiempo);
		contentPane.setLayout(gl_contentPane);
*/
		addKeyListener(new KeyAdapter()
				
		{
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-genera tedmethod stub
					switch(e.getKeyCode()) {
					
					case KeyEvent.VK_UP:
					// LO PONGO EN AVANZAR DE BOMB	lblNewLabel.setBounds(lblNewLabel.getX(), lblNewLabel.getY()-10, lblNewLabel.getWidth(), lblNewLabel.getHeight());
						//bomberman.avanzar(bomberman.getX(), bomberman.getY()+1);
						juego.moverBombermanUP();
						break;
						
					case KeyEvent.VK_DOWN:	
						// LO PONGO EN AVANZAR DE BOMB	lblNewLabel.setBounds(lblNewLabel.getX(), lblNewLabel.getY()+10, lblNewLabel.getWidth(), lblNewLabel.getHeight());
						juego.moverBombermanDOWN();
						break;
						
					case KeyEvent.VK_RIGHT:	
						// LO PONGO EN AVANZAR DE BOMB	lblNewLabel.setBounds(lblNewLabel.getX()+10, lblNewLabel.getY(), lblNewLabel.getWidth(), lblNewLabel.getHeight());
						juego.moverBombermanRIGHT();
						break;
						
					case KeyEvent.VK_LEFT:	
						// LO PONGO EN AVANZAR DE BOMB	lblNewLabel.setBounds(lblNewLabel.getX()-10, lblNewLabel.getY(), lblNewLabel.getWidth(), lblNewLabel.getHeight());
						juego.moverBombermanLEFT();
						break;
					

					case KeyEvent.VK_SPACE:
		/*veeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer
						bomba=new JLabel();
						ImageIcon imagen= new ImageIcon("C:/Users/Lea/Desktop/bomba-01.gif");
						bomba.setBounds(lblNewLabel.getX(),lblNewLabel.getY(),imagen.getIconWidth(), imagen.getIconHeight());
						bomba.setIcon(imagen);
						panel_1.add(bomba);
						juego.getBomberman().ponerBomba();
		*/
						break;
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
		});
		
	}
}
