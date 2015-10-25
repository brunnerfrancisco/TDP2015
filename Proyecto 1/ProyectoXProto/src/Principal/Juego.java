package Principal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUI;
import Threaders.BombaThread;

/**
 * Clase principal del juego. Responsable de iniciar toda la ejecución
 */
public class Juego 
{
	protected int puntaje;
	protected int reloj;
//	protected PositionList<Enemigo> listaEnemigos;
	protected Bomberman jugador;
	protected Terreno terreno;
	protected GUI gui;
	protected int tamLabel;
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Juego(GUI g)
	{
		puntaje= 0;
		terreno= new Terreno();
		jugador= new Bomberman(terreno);
		//Agrego a bomberman al terreno
		terreno.getCelda(1, 1).agregarElementoACelda(jugador);
		gui = g;
	}
	
	/**
	 * Retorna el bomberman del Juego
	 * @return jugador
	 */
	public Bomberman getBomberman()
	{
		return jugador;
	}
	
	/**
	 * Retorna el terreno del juego
	 * @return terreno
	 */
	public Terreno getTerreno()
	{
		return terreno;
	}
	
	/**
	 * Mueve al bomberman hacia arriba y actualiza la GUI
	 */
	public void moverBombermanUP() {
		jugador.avanzar(jugador.getX(), jugador.getY()-1);
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		actualizarGUI();
	}
	
	/**
	 * Mueve al bomberman hacia abajo y actualiza la GUI
	 */
	public void moverBombermanDOWN() {
		jugador.avanzar(jugador.getX(), jugador.getY()+1);
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		actualizarGUI();
	}
	
	/**
	 * Mueve al bomberman hacia la derecha y actualiza la GUI
	 */
	public void moverBombermanRIGHT() {
		jugador.avanzar(jugador.getX()+1, jugador.getY());
		actualizarGUI();  //repaint esta denytro de actualizar GUI
	
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
	}
	
	/**
	 * Mueve al bomberman hacia la izquierda y actualiza la GUI
	 */
	public void moverBombermanLEFT() {
		jugador.avanzar(jugador.getX()-1, jugador.getY());
		System.out.println("Avanzarde Juego pos X " + jugador.getX()+ " y pos y " + jugador.getY());
		actualizarGUI(); 
	}
	
	/**
	 * Atuliza los componentes graficos de la GUI
	 */
	public void actualizarGUI()
	{	
		tamLabel = gui.getTamLabel();
		ImageIcon imagenCelda;
		for (int i = 0; i < 31 ; i++)
		{
			for (int j = 0; j <13; j++)
			{
				ElementoEnCelda elementoCelda= terreno.getCelda(i, j).obtenerElem();
				if (elementoCelda == null)
				{
					 imagenCelda= new ImageIcon(getClass().getResource("/images/Transitable.jpg"));
				}
				else
				{
					imagenCelda = elementoCelda.getImagen();
				}
				JLabel labelActual = gui.getLabelEnMatriz(i,j);
				labelActual.setIcon(imagenCelda);
				labelActual.setBounds((i*tamLabel),(j*tamLabel),tamLabel,tamLabel);
				
				gui.getPanelJuego().add(labelActual);
			}
		}
		gui.getPanelJuego().repaint();
	}
	
	/**
	 * Pone una bomba en el terreno en la celda actual del bomberman
	 */
	public void ponerBomba() {

		if (jugador.obtenerCantBombas() > 0)
		{	
			BombaThread t = new BombaThread(this,jugador);
			t.start();
		}
		
	}
	
}