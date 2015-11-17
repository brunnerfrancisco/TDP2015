package Principal;

import javax.swing.ImageIcon;

public class ParedNoDestruible extends Pared {
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public ParedNoDestruible()
	{
		imagen = new ImageIcon(getClass().getResource("/images/NoTransitable.jpg"));
	}

	

	@Override
	public int destruirse() {
		return 0;
		
	}



	@Override
	public void avanzar(Bomberman b) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void avanzar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}

}
