package Principal;

import javax.swing.ImageIcon;

/**
 * Clase abstracta encargada de organizar el manejo de cada tipo de elemento en Celda.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public abstract class ElementoEnCelda 
{

	public abstract void avanzar(Bomberman b);
	public abstract void avanzar(Enemigo e);
	public abstract void destruirse();
	public abstract ImageIcon getImagen();
	

}
