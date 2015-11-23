package Principal;

import java.util.Random;

import javax.swing.ImageIcon;

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
		matriz= new Celda[31][13];
		// Establezco los limites para el terreno
		for (int i = 0; i< 12 ; i++)
		{
				matriz[0][i] = new Celda(0,i, new ParedNoDestruible(0),this);
				matriz[30][i] = new Celda(30,i, new ParedNoDestruible(0),this);
		}
		
		for (int i = 0; i< 31 ; i++)
		{
			if (i == 0){
				matriz[i][12] = new Celda(i,12, new ParedNoDestruible(3),this);
				matriz[i][0] = new Celda(i,0, new ParedNoDestruible(4),this);
			}
			else{
				if (i == 30)
				{
					matriz[i][12] = new Celda(i,12,new ParedNoDestruible(2),this);
					matriz[i][0] = new Celda(i,0,new ParedNoDestruible(5),this);
				}else{
					matriz[i][12] = new Celda(i,12,new ParedNoDestruible(1),this);
					matriz[i][0] = new Celda(i,0,new ParedNoDestruible(1),this);
				
				}
			}
		}
		
		//Creo las Celdas que son transitables
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
		//Pongo los PowerUp sobre celdas transitables
		 this.agregarPowerUps();
		 
		
	}

	private void agregarPowerUps() {
		 PowerUp [] misPowerUps = new PowerUp[11];
		 misPowerUps[0] = new SpeedUp();
		 misPowerUps[1] = new SpeedUp();
		 misPowerUps[2] = new SpeedUp();
		 misPowerUps[3] = new SpeedUp();
		 misPowerUps[4] = new Fatality();
		 misPowerUps[5] = new Fatality();
		 misPowerUps[6] = new Fatality();
		 misPowerUps[7] = new Bombality();
		 misPowerUps[8] = new Bombality();
		 misPowerUps[9] = new Bombality();
		 misPowerUps[10] = new Masacrality();
		 Random rnd  = new Random();
		 for (int i = 0; i < 11; i++)
		 {
			 int fila = 1+rnd.nextInt(29);
			 int col = 1+rnd.nextInt(11);
			 while(((fila % 2 == 0) && (col % 2 == 0)) || (fila < 9 && col < 5))
			 {
				  fila = 1+rnd.nextInt(29);
				  col = 1+rnd.nextInt(11);
			 }
				 Celda c = this.getCelda(fila,col);
			 	 c.agregarElementoACelda(misPowerUps[i]);
			     misPowerUps[i].setCelda(c);
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