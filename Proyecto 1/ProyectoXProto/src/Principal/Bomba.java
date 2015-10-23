package Principal;

import javax.swing.ImageIcon;
import Principal.Juego;

/**
 * Clase que maneja la l�gica de las bombas.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Bomba extends ElementoEnCelda implements Runnable
{
	protected int tiempo;
	protected int alcance;
	protected int posX;
	protected int posY;
	protected Terreno terreno;
	protected ImageIcon imagen;
	 
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
		imagen = new ImageIcon(getClass().getResource("/images/bomba.gif"));
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
	public void explotar(int x, int y)
	{
		
		terreno.getCelda(x, y).eliminarElementoEnCelda();
		
//		terreno.getCelda(posXAnteriorBomberman, posYAnteriorBomberman).eliminarElementoEnCelda();;
//		System.out.println(this.posX+ " y pos y" + posY);
		
		
		/*
							int i=x;
							boolean destrui=true;
							ElementoEnCelda elementoCelda;
							while (i<=(x+alcance)&&(destrui))
							{
								elementoCelda =terreno.getCelda(i, y).obtenerElem();
								if(elementoCelda!=null)
								{
									elementoCelda.destruirse();
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
									elementoCelda.destruirse();
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
									elementoCelda.destruirse();
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
									elementoCelda.destruirse();
									if(elementoCelda!=null)
									{
										destrui=false;
									}
								}
								j--;
							}
					*/
	}
	
	public void avanzar (Enemigo e){}
	public void avanzar (Bomberman b){}
	public void destruirse()
	{
		
	}

	@Override
	public ImageIcon getImagen() {
		return imagen;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
