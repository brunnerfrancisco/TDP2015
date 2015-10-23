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
		matriz= new Celda[33][33];
		// Establezco los limites para el terreno
		for (int i = 0; i< 33 ; i++)
		{
			matriz[i][0] = new Celda(i,0,new ParedNoDestruible(),this);
			matriz[32][i] = new Celda(33,i,new ParedNoDestruible(),this);
			matriz[0][i] = new Celda(0,i,new ParedNoDestruible(),this);
			matriz[i][32] = new Celda(i,33, new ParedNoDestruible(),this);
		}
		
		for (int i = 1; i < 32 ; i++)
		{
			for (int j = 1; j < 32; j++)
			{	
				if ((i % 2 == 0) && (j % 2 == 0))
					matriz[i][j] = new Celda(i,j,new ParedNoDestruible(),this);
				else
					matriz[i][j] = new Celda(i,j, null,this);
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
