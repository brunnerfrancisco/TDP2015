package Principal;
/**
 * Clase Bomberman que maneja toda la lógica del jugador.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Bomberman 
{
	protected int velocidad;
	protected int cantBombasSimultaneas;
	protected int cantBombasActuales;
	protected boolean modoDios;
	protected int puntaje;
	protected int posX;
	protected int posY;
	protected boolean estaVivo;
	protected Bomba miBomba;
	protected Terreno miTerreno;
	
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Bomberman(Terreno t)
	{
		posX=1;
		posY=1;
		estaVivo=true;
		modoDios=false;
		puntaje=0;
		cantBombasSimultaneas=1;
		cantBombasActuales=1;
		miTerreno=t;
		miBomba=new Bomba(t);
		
	}
	
	/**
	 * Método que setea una nueva posición en X pasada por parámetro.
	 * @param x, de tipo entero.
	 */
	public void setX(int x)
	{
		posX=x;
	}
	
	/**
	 * Método que setea una nueva posición en Y pasada por parámetro.
	 * @param y, de tipo entero.
	 */
	public void setY(int y)
	{
		posX=y;
	}
	
	/**
	 * Método que devuelve la posición en X del jugador.
	 * @return posX
	 */
	public int getX()
	{
		return posX;
	}
	
	/**
	 * Método que devuelve la posición en Y del jugador.
	 * @return posY
	 */
	public int getY()
	{
		return posY;
	}
	
	/**
	 * Método que cambia el estado del modo dios del jugador.
	 * @param d, de tipo boolean
	 */
	public void modoDios(boolean d)
	{
		modoDios=d;
	}
	
	/**
	 * Método que aumenta el puntaje del jugador de acuerdo a la cantidad que indica el parámetro. 
	 * @param p, de tipo entero.
	 */
	public void sumarPuntos(int p)
	{
		puntaje+=p;
	}
	
	/**
	 * Método que devuelve el puntaje del jugador en ese momento.
	 * @return puntaje, de tipo entero.
	 */
	public int getPuntos()
	{
		return puntaje;
	}
	
	
	public void avanzar(int x, int y)
	{
		miTerreno.obtenerCelda(x,y).avanzar(this);	
	}
	
	/**
	 *Método que le permite al jugador poner una, o más, bombas. 
	 */
	public void ponerBomba()
	{
		if(cantBombasActuales>0)
		{
			miBomba.explotar(posX,posY);	
		}
	}
	
	/**
	 * Método que incrementa la velocidad de movimilidad del jugador.
	 */
	public void incrementarVel()
	{
		
	}
	
	/**
	 * Método que duplica el alcance de la bomba que pone el jugador.
	 */
	public void duplicarAlcance()
	{
		
	}
	
	/**
	 * Método que duplica la cantidad de bombas que puede poner el jugador simultaneamente.
	 */
	public void duplicarCantBombas()
	{
		cantBombasSimultaneas*=2;
	}
	

	
}
