package Principal;
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
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Juego()
	{
		puntaje= 0;
		terreno= new Terreno();
		jugador= new Bomberman(terreno);
	}
	
	public Bomberman getBomberman()
	{
		return jugador;
	}
	
}
