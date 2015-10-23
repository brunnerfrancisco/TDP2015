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
	protected int cantElementos;
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Celda (int x, int y, ElementoEnCelda elem)
	{
		posX=x;
		posY=y;
		elementos = new ElementoEnCelda[5];
		elementos[0] = elem;
		cantElementos = 0;
	}
	
	public ElementoEnCelda obtenerElem()
	{
	
		return elementos[cantElementos];
	}
	
	public void agregarElementoACelda(ElementoEnCelda e)
	{
		elementos[cantElementos+1] = e;
		cantElementos++;
	}
	
	public void eliminarElementoEnCelda()
	{
		elementos[cantElementos] = null;
		cantElementos--;
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
				System.out.println(this.posX+ " y pos y" + posY);
				
				//muevo en la grafica 1*32 para arriba
			}
		else
		{
			obtenerElem().avanzar(b); // Llamo a avanzar con bomberman y la celda a la que quiero avanzar
		}
	}
	
	
	public void avanzar(Enemigo e)
	{
		
	}
	
	public Celda getCelda()
	{
		return this;
	}

}
