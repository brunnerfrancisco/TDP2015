
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
		gui = g;
	}
	
	public Bomberman getBomberman()
	{
		return jugador;
	}
	
	metodos mover arriba/abajo/etc.
	
}
