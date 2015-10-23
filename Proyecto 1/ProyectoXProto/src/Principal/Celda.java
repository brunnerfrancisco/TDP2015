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
	protected Terreno terreno;
	protected ElementoEnCelda [] elementos;
	protected int cantElementos;
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Celda (int x, int y, ElementoEnCelda elem,Terreno t)
	{
		posX=x;
		posY=y;
		elementos = new ElementoEnCelda[5];
		elementos[0] = elem;
		cantElementos = 0;
		terreno = t;
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
		if (obtenerElem() == null) // celda vacia
			{
				int posXAnteriorBomberman = b.getX();
				int posYAnteriorBomberman = b.getY();
				b.setX(posX);
				b.setY(posY);
				this.agregarElementoACelda(b);
				terreno.getCelda(posXAnteriorBomberman, posYAnteriorBomberman).eliminarElementoEnCelda();;
				System.out.println(this.posX+ " y pos y" + posY);
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
