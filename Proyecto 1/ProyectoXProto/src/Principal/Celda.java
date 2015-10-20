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
//	protected Stack<ElementoEnCelda> elementos;
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Celda (int x, int y, ElementoEnCelda elem)
	{
		posX=x;
		posY=y;
//		elementos.addLast(elem);
	}
	
	public ElementoEnCelda obtenerElem()
	{
		//return elementos.pop();
		return null;
	}
	public void avanzar(Bomberman b)
	{
		
	}
	
	public void avanzar(Enemigo e)
	{
		
	}

}
