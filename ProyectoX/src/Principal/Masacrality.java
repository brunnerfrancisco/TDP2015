package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela el power-up de mas poderoso, el cual le brinda al jugador varias 
 * cualidades, entre ellas, ser inmortal por un tiempo limitado.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Masacrality extends PowerUp
{

	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Masacrality()
	{
		super.imagen = new ImageIcon(getClass().getResource("/images/masacrality.jpg"));
	}
	
	public void avanzar(Bomberman b)
	{
		
	}



}
