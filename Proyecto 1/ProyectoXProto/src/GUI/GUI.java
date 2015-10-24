package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Principal.ElementoEnCelda;
import Principal.Juego;
import Principal.Terreno;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GUI extends JFrame{

	private JPanel contentPane;
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
		
		matrizLabel = new JLabel[31][13];
		for (int i = 0; i < 31; i++)
		{
			for (int j = 0; j< 13; j++)
			{
				matrizLabel[i][j] = new JLabel();
			}
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 700, 320);
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
		
		Terreno miTerreno = juego.getTerreno();
		ImageIcon imagenCelda;
		for (int i = 0; i <31; i++)
		{
			for (int j = 0; j < 13; j++)
			{
				ElementoEnCelda elementoCelda= miTerreno.getCelda(i, j).obtenerElem();
				if (elementoCelda == null)
				{
					 imagenCelda= new ImageIcon(getClass().getResource("/images/Transitable.jpg"));
				}
				else
				{
					imagenCelda = elementoCelda.getImagen();
				}
				matrizLabel[i][j].setIcon(imagenCelda);
				matrizLabel[i][j].setBounds((i*22),(j*22),22,22);
				
				contentPane.add(matrizLabel[i][j]);
			}
		}

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
						juego.ponerBomba();
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

	public JLabel getLabelEnMatriz(int i, int j) {
		return matrizLabel[i][j];
	}
}