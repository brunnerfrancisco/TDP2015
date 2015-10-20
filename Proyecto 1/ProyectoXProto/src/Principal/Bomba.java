package Principal;
/**
 * Clase que maneja la lógica de las bombas.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Bomba extends ElementoEnCelda
{
	protected int tiempo;
	protected int alcance;
	protected int posX;
	protected int posY;
	protected Terreno terreno;
	
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Bomba(Terreno t)
	{
		posX=0;
		posY=0;
		alcance=1;
		tiempo=2500;
		terreno=t;
	}
	
	/**
	 * Método que setea el tiempo que tarda en explotar la bomba.
	 * @param t, de tipo entero.
	 */
	public void setTiempo(int t)
	{
		tiempo=t;
	}
	
	/**
	 * Método que setea el alcance de la explosión de la bomba.
	 * @param a, de tipo entero.
	 */
	public void setAlcance(int a)
	{
		alcance=a;
	}
	
	/**
	 * Método que devuelve el tiempo que tarda en explotar la bomba.
	 * @return tiempo
	 */
	public int getTiempo()
	{
		return tiempo;
	}
	
	/**
	 * Método que devuelve el alcance de explosión que tiene la bomba.
	 * @return alcance
	 */
	public int getAlcance()
	{
		return alcance;
	}
	
	/**
	 * Método que devuelve la posición en X de la bomba.
	 * @return posX
	 */
	public int getX()
	{
		return posX;
	}
	
	/**
	 * Método que devuelve la posición en Y de la bomba.
	 * @return posY
	 */
	public int getY()
	{
		return posY;
	}
	
	/**
	 * Método que maneja la explosión de las bombas.
	 */
	public void explotar(int x, int y)
	{
		int i=x;
		boolean destrui=true;
		Celda celda=null;
		
		while (i<=(x+alcance)&&(destrui))
		{
//			Celda celda=terreno.obtenerCelda(i, y).obtenerElem();
			if(celda!=null)
			{
//				celda.destruirse();
				if(celda!=null)
				{
					destrui=false;
				}
			}
			
			i++;
		}
		i=x;
		destrui=true;
		while (i>=(x-alcance)&&(destrui))
		{
//			Celda celda=terreno.obtenerCelda(i, y).obtenerElem();
			if(celda!=null)
			{
//				celda.destruirse();
				if(celda!=null)
				{
					destrui=false;
				}
			}
			i--;
		}
		int j=y;
		destrui=true;
		while (j<=(y+alcance)&&(destrui))
		{
//			Celda celda=terreno.obtenerCelda(x, j).obtenerElem();
			if(celda!=null)
			{
//				celda.destruirse();
				if(celda!=null)
				{
					destrui=false;
				}
			}
			j++;
		}
		j=y;
		destrui=true;
		while (j>=(y-alcance)&&(destrui))
		{
//			Celda celda=terreno.obtenerCelda(x, j).obtenerElem();
			if(celda!=null)
			{
//				celda.destruirse();
				if(celda!=null)
				{
					destrui=false;
				}
			}
			j--;
		}
		
	}
	
	public void avanzar (Enemigo e){}
	public void avanzar (Bomberman b){}
	public void destruirse()
	{
		
	}
	
}
