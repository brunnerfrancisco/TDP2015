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
		if (elem != null)
			cantElementos = 1;
		else
			cantElementos = 0;
		terreno = t;
	}
	
	/**
	 * Retorna el ultimo elemento de la celda
	 * @return ultimo elemento de la celda
	 */
	public ElementoEnCelda obtenerElem()
	{
		if (!celdaVacia())
			return elementos[cantElementos-1];
		else
			return null;
	}
	/**
	 * Verifica que la celda este vacia
	 * @return true si la celda esta vacia, false en caso contrario
	 */
	private boolean celdaVacia() {
		return (cantElementos == 0);
	}
	/**
	 * Agrega un elemento a la celda
	 * @param e Elemento que va a pertenecer a la celda
	 */
	public void agregarElementoACelda(ElementoEnCelda e)
	{
		elementos[cantElementos] = e;
		cantElementos++;
	}
	
	/**
	 * Elimina el ultimo elemento de la celda
	 */
	public void eliminarElementoEnCelda()
	{
		
		elementos[cantElementos-1] = null;
		cantElementos--;
	}
	
	/**
	 * Retorma la posicion X de la celda en la matriz de celdas
	 * @return posX
	 */
	public int getPosX()
	{
		return posX;
	}
	
	/**
	 * Retorma la posicion X de la celda en la matriz de celdas
	 * @return posX
	 */
	public int getPosY()
	{
		return posY;
	}
	
	/**
	 * Agrega al bomberman como elemento de la celda en caso de ser posible
	 * @param b
	 */
	public void avanzar(Bomberman b)
	{		
		if (obtenerElem() == null) // celda vacia
			{
//				int posXAnteriorBomberman = b.getX();
//				int posYAnteriorBomberman = b.getY();
//				b.setX(posX);
//				b.setY(posY);
//				b.setCelda(this);
//				this.agregarElementoACelda(b);
//				terreno.getCelda(posXAnteriorBomberman, posYAnteriorBomberman).eliminarElementoEnCelda();
//				System.out.println(this.posX+ " y pos y" + posY);
			Celda celdaAnterior = b.getCelda(); // PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
			b.setX(posX);
			b.setY(posY);
			b.setCelda(this);
			b.setCeldaAnterior(celdaAnterior);
			this.agregarElementoACelda(b);
			celdaAnterior.eliminarElementoEnCelda();
			}
		else
		{
			obtenerElem().avanzar(b); // Llamo a avanzar del elemento en celda con bomberman 
		}
	}
	
	
	public void avanzar(Enemigo e)
	{
		if (obtenerElem() == null) // celda vacia
		{
//			Celda celdaAnterior = e.getCelda(); // PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
//			
//			e.setX(posX);
//			e.setY(posY);
//			e.setCelda(this);
//			this.agregarElementoACelda(e);
//			e.setCeldaAnterior(celdaAnterior);
//			celdaAnterior.eliminarElementoEnCelda();
//			System.out.println(celdaAnterior.obtenerElem() == null);
			Celda celdaAnterior = e.getCelda(); // PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
			e.setX(posX);
			e.setY(posY);
			e.setCelda(this);
			e.setCeldaAnterior(celdaAnterior);
			this.agregarElementoACelda(e);
			celdaAnterior.eliminarElementoEnCelda();
		}
		else
		{
			obtenerElem().avanzar(e); // Llamo a avanzar del elemento en celda con enemigo
		}
	}
	
	/**
	 * Se retorna a si misma
	 * @return this
	 */
	public Celda getCelda()
	{
		return this;
	}
	
	/**
	 * Agrega la bomba como elemento de la celda
	 * @param miBomba
	 */
	public void ponerBombaEnCelda(Bomba miBomba)
	{	//Pongo a bomberman sobre la bomba.
		elementos[cantElementos] = elementos[cantElementos-1];
		elementos[cantElementos-1] = miBomba;
		cantElementos++;
	}

}
