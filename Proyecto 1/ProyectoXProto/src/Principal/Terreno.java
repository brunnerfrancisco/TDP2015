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
		// Establezco los limites para el terreno
		for (int i = 0; i< 34 ; i++)
		{
			matriz[i][0] = new Celda(i,0,new ParedNoDestruible());
			matriz[33][i] = new Celda(33,i,new ParedNoDestruible());
			matriz[0][i] = new Celda(0,i,new ParedNoDestruible());
			matriz[i][33] = new Celda(i,33, new ParedNoDestruible());
		}
		
		for (int i = 1; i < 33 ; i++)
		{
			for (int j = 1; j < 33; j++)
			{	
				if ((i % 2 == 0) && (j % 2 == 0))
					matriz[i][j] = new Celda(i,j,new ParedNoDestruible());
				else
					matriz[i][j] = new Celda(i,j, null);
			}
			
		}	
	}

	/**
	 * Método que devuelve la celda correspondiente a las coordenadas pasadas por parámetro.
	 * @param x, de tipo entero
	 * @param y, de tipo entero
	 * @return Celda
	 */
	public Celda getCelda(int x, int y)
	{
		return matriz[x][y];
	}
	
	
	
}
