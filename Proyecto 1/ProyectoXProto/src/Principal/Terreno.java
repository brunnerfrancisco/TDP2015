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
		matriz= new Celda[31][13];
		// Establezco los limites para el terreno
		for (int i = 0; i< 13 ; i++)
		{
			matriz[0][i] = new Celda(0,i,new ParedNoDestruible(),this);
			matriz[30][i] = new Celda(30,i, new ParedNoDestruible(),this);
		}
		
		for (int i = 0; i< 31 ; i++)
		{
			matriz[i][12] = new Celda(i,12,new ParedNoDestruible(),this);
			matriz[i][0] = new Celda(i,0,new ParedNoDestruible(),this);
			
		}
		for (int i = 1; i <30 ; i++)
		{
			for (int j = 1; j < 12; j++)
			{	
				if ((i % 2 == 0) && (j % 2 == 0))
					matriz[i][j] = new Celda(i,j,new ParedNoDestruible(),this);
					
				else
					matriz[i][j] = new Celda(i,j, null,this);
			}
			
		}	
	}

	/**
	 * M�todo que devuelve la celda correspondiente a las coordenadas pasadas por par�metro.
	 * @param x, de tipo entero
	 * @param y, de tipo entero
	 * @return Celda
	 */
	public Celda getCelda(int x, int y)
	{
		return matriz[x][y];
	}
	
	
	
}