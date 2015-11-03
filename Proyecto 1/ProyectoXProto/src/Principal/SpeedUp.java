package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela el power-up de velocidad.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class SpeedUp extends PowerUps 
{

	protected ImageIcon imagen;
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public SpeedUp()
	{
		
	}

	@Override
	public void avanzar(Bomberman b) {
		int velocidadNueva = b.getVelocidad() *2;
		b.setVelocidad(velocidadNueva);
		
		
		destruirse();
		
	}

	@Override
	public void avanzar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destruirse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
