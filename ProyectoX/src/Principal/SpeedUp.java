package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela el power-up de velocidad.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class SpeedUp extends PowerUp
{
	
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public SpeedUp()
	{	
		super.imagen = new ImageIcon(getClass().getResource("/images/speedUp.jpg"));
	}

	@Override
	public void avanzar(Bomberman b) {
		int velocidadNueva = b.getVelocidad() *2;
		b.setVelocidad(velocidadNueva);
		super.miCelda.eliminarElementoEnCelda(); // Saco el PowerUP
		b.addPuntos(30);
		super.miCelda.avanzar(b);
		//VEEEEEEEEER SI FUNCA O NO
		
	}

}
