package Principal;

/**
 * Clase que modela los distintos enemigos que tiene el juego.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public abstract class Enemigo extends ElementoEnCelda
{

	protected int velocidad;
	protected boolean modoDios;
	protected int posX;
	protected int posY;
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Enemigo()
	{
		
	}
	
	/**
	 * Método que devuelve la velocidad del enemigo.
	 * @return velocidad
	 */
	public int getVel()
	{
		return velocidad;
	}
	
	/**
	 * Método responsable del avance de los enemigos.
	 */
	public void avanzar()
	{
		
	}
	
}
