
package Principal;
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
	}
	
	public void moverBombermanDOWN() {
		jugador.avanzar(jugador.getX(), jugador.getY()+1);
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		
	}
	public void moverBombermanRIGHT() {
		jugador.avanzar(jugador.getX()+1, jugador.getY());
		actualizarGUI();  //repaint esta denytro de actualizar GUI
		gui.repaint();
		System.out.println("Avanzarde Juego pos X" + jugador.getX()+ " y pos y" + jugador.getY());
		
	}
	public void moverBombermanLEFT() {
		jugador.avanzar(jugador.getX()-1, jugador.getY());
		System.out.println("Avanzarde Juego pos X " + jugador.getX()+ " y pos y " + jugador.getY());
	}
	
	public void actualizarGUI()
	{
		// hay que hacer una matriz de JLabel en la GUI
	}
	
}
