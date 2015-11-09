package Principal;

import javax.swing.ImageIcon;

public class ParedNoDestruible extends Pared {
	protected ImageIcon imagen;
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public ParedNoDestruible()
	{
		imagen = new ImageIcon(getClass().getResource("/images/NoTransitable.jpg"));
	}

	@Override
	public void avanzar(Bomberman b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanzar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int destruirse() {
		return 0;
		
	}

}
