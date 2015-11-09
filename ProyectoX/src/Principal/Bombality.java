package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela el power-up de la cantidad de bombas simultaneas que puede poner el jugador.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Bombality extends PowerUps
{
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Bombality()
	{
		super.imagen = new ImageIcon(getClass().getResource("/images/Bombality.png"));
	}

	public void avanzar(Bomberman b)
	{
		b.aumentarCantBombas();
		super.miCelda.eliminarElementoEnCelda(); // Saco el PowerUP
		super.miCelda.avanzar(b);
		b.addPuntos(35);
	}


}
