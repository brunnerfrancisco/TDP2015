package Principal;

import javax.swing.ImageIcon;
import Principal.Juego;

/**
 * Clase que maneja la l�gica de las bombas.
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
	 * @param t Terreno que conoce la Bomba
	 */
	public Bomba(Terreno t)
	{
		posX=0;
		posY=0;
		alcance=1;
		tiempo=2500;
		terreno=t;
		imagen = new ImageIcon(getClass().getResource("/images/bomba2.gif"));
	}
	
	/**
	 * M�todo que setea el tiempo que tarda en explotar la bomba.
	 * @param t, de tipo entero.
	 */
	public void setTiempo(int t)
	{
		tiempo=t;
	}
	
	/**
	 * M�todo que setea el alcance de la explosi�n de la bomba.
	 * @param a, de tipo entero.
	 */
	public void setAlcance(int a)
	{
		alcance=a;
	}
	
	/**
	 * M�todo que devuelve el tiempo que tarda en explotar la bomba.
	 * @return tiempo
	 */
	public int getTiempo()
	{
		return tiempo;
	}
	
	/**
	 * M�todo que devuelve el alcance de explosi�n que tiene la bomba.
	 * @return alcance
	 */
	public int getAlcance()
	{
		return alcance;
	}
	
	/**
	 * M�todo que devuelve la posici�n en X de la bomba.
	 * @return posX
	 */
	public int getX()
	{
		return posX;
	}
	
	/**
	 * M�todo que devuelve la posici�n en Y de la bomba.
	 * @return posY
	 */
	public int getY()
	{
		return posY;
	}
	
	/**
	 * M�todo que maneja la explosi�n de las bombas.
	 */
	public int explotar(int x, int y)
	{
		
		    terreno.getCelda(x, y).eliminarElementoEnCelda();
			int i=x;
			int puntos = 0;
			boolean destrui=true;
			ElementoEnCelda elementoCelda;
			while (i<=(x+alcance)&&(destrui))
			{
				elementoCelda =terreno.getCelda(i, y).obtenerElem();
				if(elementoCelda!=null)
				{
					puntos = puntos + elementoCelda.destruirse();
					if(elementoCelda!=null)
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
				elementoCelda =terreno.getCelda(i, y).obtenerElem();
				if(elementoCelda!=null)
				{
					puntos = puntos + elementoCelda.destruirse();
					if(	elementoCelda!=null)
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
					elementoCelda=terreno.getCelda(x, j).obtenerElem();
				if(	elementoCelda!=null)
				{
					puntos = puntos + elementoCelda.destruirse();
					if(	elementoCelda!=null)
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
				elementoCelda=terreno.getCelda(x, j).obtenerElem();
				if(	elementoCelda!=null)
				{
					puntos = puntos + elementoCelda.destruirse();
					if(elementoCelda!=null)
					{
						destrui=false;
					}
				}
				j--;
			}
			
					
		return puntos;
	}
	
	/**
	 * 
	 */
	public void avanzar (Enemigo e){}
	
	/**
	 * 
	 */
	public void avanzar (Bomberman b){}
	
	/**
	 * 
	 */
	public int destruirse()
	{
		return 0;
	}
	
	/**
	 * 
	 * @param posX
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	/**
	 * Setea la posisicion y de la bomba con el valor de posY
	 * @param posY
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}
}
