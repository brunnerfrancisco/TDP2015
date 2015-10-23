package Principal;
/**
 * Clase que permite conocer y manejar los elementos que se encuentran en el terreno.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Celda 
{
	protected int posX;
	protected int posY;
	protected Terreno ubicacion;
	protected ElementoEnCelda [] elementos;
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Celda (int x, int y, ElementoEnCelda elem)
	{
		posX=x;
		posY=y;
		elementos = new ElementoEnCelda[4];
		elementos[0] = elem;
	}
	
	public ElementoEnCelda obtenerElem()
	{
		int i = 0;
		while(elementos[i] != null)
		{
			i++;
		}
		return elementos[i];
	}
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public void avanzar(Bomberman b)
	{
		if (elementos[0] == null) // celda vacia
			{
				b.setX(posX);
				b.setY(posY);
				muevo en la grafica 1*32 para arriba
			}
		else
			obtenerElem().avanzar(b); // Llamo a avanzar con bomberman y la celda a la que quiero avanzar
	}
	
	
	public void avanzar(Enemigo e)
	{
		
	}
	
	public Celda getCelda()
	{
		return this;
	}

}
