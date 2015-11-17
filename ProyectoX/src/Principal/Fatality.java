package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela el power-up del alcance de la bomba.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Fatality extends PowerUp
{

	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Fatality()
	{
		super.imagen = new ImageIcon(getClass().getResource("/images/fatality.jpg"));
	}
	
	public void avanzar(Bomberman b)
	{
		b.duplicarAlcance();
		miCelda.eliminarElementoEnCelda();
		miCelda.avanzar(b);
		b.addPuntos(35);
	}



}
