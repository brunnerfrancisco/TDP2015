package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela el power-up de la cantidad de bombas simultaneas que puede poner el jugador.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Bombality extends PowerUp
{
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Bombality()
	{
		super.imagen = new ImageIcon(getClass().getResource("/images/bombality.jpg"));
	}

	/**
	 * Aumenta la cantidad de bombas simultaneas de bomberman y elimina el power
	 * up de la celda
	 */
	public void avanzar(Bomberman b)
	{
		b.aumentarCantBombas();
		super.miCelda.eliminarElementoEnCelda(); // Saco el PowerUP
		b.addPuntos(35);
		super.miCelda.avanzar(b);
	}


}
