package Principal;

import javax.swing.ImageIcon;

/**
 * Clase abstracta encargada de organizar el manejo de cada tipo de elemento en Celda.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public abstract class ElementoEnCelda 
{
	protected Celda miCelda;
	protected ImageIcon imagen;

	public abstract void avanzar(Bomberman b);
	public abstract void avanzar(Enemigo e);
	public abstract int destruirse();
	public  void setCelda(Celda c)
	{
		miCelda = c;
	}
	
	/**
	 * Retona la imagen del PowerUp
	 */
	public ImageIcon getImagen() {
		return imagen;
	}

}
