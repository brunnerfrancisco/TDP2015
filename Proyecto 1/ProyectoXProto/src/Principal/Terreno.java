package Principal;

/**
 * Clase que se encarga de la lógica y ubicación de todos los elementos en el mapa.
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
		matriz= new Celda[34][34];
//		for (int x = 0; i < 34 ; i++)
//		{
//			for (int j = 0; j < 34; j++)
//			{
//				
//			}
//			}
//		}
		
	}

	/**
	 * Método que devuelve la celda correspondiente a las coordenadas pasadas por parámetro.
	 * @param x, de tipo entero
	 * @param y, de tipo entero
	 * @return Celda
	 */
	public Celda obtenerCelda(int x, int y)
	{
		return matriz[x][y];
	}
	
}
