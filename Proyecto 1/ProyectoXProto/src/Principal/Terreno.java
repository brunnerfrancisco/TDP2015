package Principal;

/**
 * Clase que se encarga de la l�gica y ubicaci�n de todos los elementos en el mapa.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Terreno 
{
	
	protected Celda[][] matriz;
	
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma e inicializa el terreno de juego.
	 */
	public Terreno()
	{
		matriz= new Celda[32][32];
	}

	/**
	 * M�todo que devuelve la celda correspondiente a las coordenadas pasadas por par�metro.
	 * @param x, de tipo entero
	 * @param y, de tipo entero
	 * @return Celda
	 */
	public Celda obtenerCelda(int x, int y)
	{
		return matriz[x][y];
	}
	
}
