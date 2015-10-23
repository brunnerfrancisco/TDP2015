
package Principal;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUI;

/*
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
	
	public Bomberman getBomberman()
	{
		return jugador;
	}
	public Terreno getTerreno()
	{
		return terreno;
	}

	public void moverBombermanUP() {
		jugador.avanzar(jugador.getX(), jugador.getY()-1);
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		actualizarGUI();
	}
	
	public void moverBombermanDOWN() {
		jugador.avanzar(jugador.getX(), jugador.getY()+1);
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		actualizarGUI();
		
	}
	public void moverBombermanRIGHT() {
		jugador.avanzar(jugador.getX()+1, jugador.getY());
		actualizarGUI();  //repaint esta denytro de actualizar GUI
	
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		
	}
	public void moverBombermanLEFT() {
		jugador.avanzar(jugador.getX()-1, jugador.getY());
		System.out.println("Avanzarde Juego pos X " + jugador.getX()+ " y pos y " + jugador.getY());
		actualizarGUI(); 
	}
	
	public void actualizarGUI()
	{	
		ImageIcon imagenCelda;
		for (int i = 0; i < 33 ; i++)
		{
			for (int j = 0; j < 33; j++)
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
				labelActual.setBounds((i*22),(j*22),22,22);
				
				gui.getContentPane().add(labelActual);
			}
		}
		gui.getContentPane().repaint();
	}

	public void ponerBomba() {
		jugador.ponerBomba();
		actualizarGUI();
		(new Tiempo(this,jugador,gui)).run();
	
	}
	private static class Tiempo extends Thread
	{
		private Bomberman bomberman;
		private Juego juego;
		public Tiempo(Juego g, Bomberman b,GUI gu)
		{
			bomberman = b;
			juego = g;
		}
		public void run()
		{
			try {
				sleep(3000);
				Bomba miBomba = bomberman.getBomba();
				miBomba.explotar(miBomba.getX(),miBomba.getY());
				juego.actualizarGUI();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
}
