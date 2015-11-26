package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import Principal.ElementoEnCelda;
import Principal.Juego;
import Principal.Terreno;

public class GUI extends JFrame {

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
	
	private final static int anchoTotal = 920;
	private final static int altoTotal = 600;

	private final static int anchoJuego = 950;
	private final static int anchoLabel = 29;
	private final static int altoLabel = 40;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					new Thread(new Splash(frame)).start();
					//frame.setVisible(true);
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
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		panelJuego = new JPanel();
		panelJuego.setLayout(null);
		panelJuego.setBounds(0, 0, anchoJuego, anchoTotal);
		panelJuego.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(panelJuego,BorderLayout.CENTER);
		

		
		panelInfo = new JPanel();
		panelInfo.setLayout(new GridLayout(1,2));
		panelInfo.setBounds(0,0,anchoTotal-anchoJuego, anchoTotal);

		panelInfo.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(panelInfo,BorderLayout.SOUTH);
		{
			Font fuente=new Font("ARIAL",Font.BOLD,23);
			
			puntajePanel = new JPanel();
			puntajePanel.setLayout(new FlowLayout());
			panelInfo.add(puntajePanel,0,0);
			puntajeLabelTitulo = new JLabel();
			puntajeLabelTitulo.setFont(fuente);
			puntajeLabelTitulo.setText("Puntaje: ");
			puntajePanel.add(puntajeLabelTitulo);
			puntajeLabelContenido = new JLabel();
			puntajeLabelContenido.setFont(fuente);
			puntajeLabelContenido.setText("0");
			puntajePanel.add(puntajeLabelContenido);
			
			tiempoPanel = new JPanel();
			tiempoPanel.setLayout(new FlowLayout());
			panelInfo.add(tiempoPanel,1,0);
			tiempoLabelTitulo = new JLabel();
			tiempoLabelTitulo.setFont(fuente);
			tiempoLabelTitulo.setText("Tiempo: ");
			tiempoPanel.add(tiempoLabelTitulo);
			tiempoLabelContenido = new JLabel();
			tiempoLabelContenido.setFont(fuente);
			tiempoPanel.add(tiempoLabelContenido);
			juego= new Juego(this);
		}
		
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
				matrizLabel[i][j].setBounds((i*anchoLabel),(j*altoLabel),anchoLabel,altoLabel);
				
				panelJuego.add(matrizLabel[i][j]);
			}
		}

		
		
//	 new Thread()
//	 {
//		
//		 public void run() 
//		 {
//			 try {
//				Thread.sleep(2000);
//				System.out.println("toy dormido");
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			addKeyListener(new KeyAdapter()	
			{
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-genera tedmethod stub
					switch(e.getKeyCode()) {
					
					case KeyEvent.VK_UP:
						juego.moverBombermanUP();
						break;
						
					case KeyEvent.VK_DOWN:	
						juego.moverBombermanDOWN();
						break;
						
					case KeyEvent.VK_RIGHT:	
						juego.moverBombermanRIGHT();
						break;
						
					case KeyEvent.VK_LEFT:	
						juego.moverBombermanLEFT();
						break;
					
	
					case KeyEvent.VK_SPACE:
						juego.ponerBomba();
						break;
					
					}
				
		
		
				}});
	
			}
//	 };
//	 }
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

	public int getAnchoLabel() 
	{
		return anchoLabel;
	}
	public int getAltoLabel() 
	{
		return altoLabel;
	}
	public void actualizarPuntaje(int p) 
	{
		String puntosAct = puntajeLabelContenido.getText();
		int puntos= Integer.parseInt(puntosAct);
		puntos =  p;
		puntosAct = Integer.toString(puntos);
		puntajeLabelContenido.setText(puntosAct);
		
	}

	public JLabel getTiempoLabelContenido() 
	{
		return tiempoLabelContenido;	
	}
}