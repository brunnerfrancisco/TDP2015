package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Principal.ElementoEnCelda;
import Principal.Juego;
import Principal.Terreno;

public class GUI extends JFrame{

	private JPanel contentPane;
	private JPanel panelInfo;
	private JPanel panelJuego;
	
	private JLabel [][] matrizLabel;
	
	private JPanel tiempoPanel;
	private JLabel tiempoLabelTitulo;
	private JLabel tiempoLabelContenido;
	
	private JPanel puntajePanel;
	private JLabel puntajeLabelTitulo;
	protected JLabel puntajeLabelContenido;
	
	private Juego juego;
	
	private final static int cantFilas = 13;
	private final static int cantColumnas = 31;
	
	private final static int anchoTotal = 850;
	private final static int altoTotal = 325;
	
	private final static int anchoJuego = 700;
	private final static int tamLabel = 22;
	
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
	public GUI()
	{
		matrizLabel = new JLabel[cantColumnas][cantFilas];
		for (int i = 0; i < cantColumnas; i++)
		{
			for (int j = 0; j< cantFilas; j++)
			{
				matrizLabel[i][j] = new JLabel();
			}
		}
		super.setTitle("BOMBERMAN - Brunner Vercelli Volpe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(anchoTotal, altoTotal);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		panelJuego = new JPanel();
		panelJuego.setLayout(null);
		panelJuego.setBounds(0, 0, anchoJuego, anchoTotal);
		panelJuego.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(panelJuego,BorderLayout.CENTER);
		
		juego= new Juego(this);
		
		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(2,1));
		panelInfo.setBounds(0, 0, anchoTotal-anchoJuego, anchoTotal);
		panelInfo.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(panelInfo,BorderLayout.EAST);
		{
			puntajePanel = new JPanel();
			puntajePanel.setLayout(new FlowLayout());
			panelInfo.add(puntajePanel,0,0);
			puntajeLabelTitulo = new JLabel();
			puntajeLabelTitulo.setText("Puntaje: ");
			puntajePanel.add(puntajeLabelTitulo);
			puntajeLabelContenido = new JLabel();
			puntajeLabelContenido.setText("0");
			puntajePanel.add(puntajeLabelContenido);
			
			tiempoPanel = new JPanel();
			tiempoPanel.setLayout(new FlowLayout());
			panelInfo.add(tiempoPanel,1,0);
			tiempoLabelTitulo = new JLabel();
			tiempoLabelTitulo.setText("Tiempo");
			tiempoPanel.add(tiempoLabelTitulo);
			tiempoLabelContenido = new JLabel();
			tiempoLabelContenido.setText("0");
			tiempoPanel.add(tiempoLabelContenido);
		}
		
		/* 
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
		for (int i = 0; i <cantColumnas; i++)
		{
			for (int j = 0; j < cantFilas; j++)
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
				matrizLabel[i][j].setBounds((i*tamLabel),(j*tamLabel),tamLabel,tamLabel);
				
				panelJuego.add(matrizLabel[i][j]);
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
		});
	}
	/**
	 * Retorna el JLabel correspondiente a la posicion i, j de la matriz de JLabel
	 * @param i fila de la matriz de JLabel
	 * @param j columna de la matriz de JLabel
	 * @return JLabel correspondiente a la posicion i, j de la matriz de JLabel
	 */
	public JLabel getLabelEnMatriz(int i, int j) {
		return matrizLabel[i][j];
	}
	
	/**
	 * 
	 * @return
	 */
	public JPanel getPanelJuego()
	{
		return panelJuego;
	}

	public int getTamLabel() 
	{
		return tamLabel;
	}
	
	public void actualizarPuntaje(int p) 
	{
		String puntosAct = puntajeLabelContenido.getText();
		int puntos= Integer.parseInt(puntosAct);
		puntos = puntos + p;
		puntosAct = Integer.toString(puntos);
		puntajeLabelContenido.setText(puntosAct);
		
	}
}