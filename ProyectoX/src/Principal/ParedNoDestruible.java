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

	public ParedNoDestruible(int i) {
		switch (i) {
        case 0:  imagen = new ImageIcon(getClass().getResource("/images/NoTransitableVert.jpg"));
                 break;
        case 1:  imagen = new ImageIcon(getClass().getResource("/images/NoTransitableHori.jpg"));
        		break;
        case 2:  imagen = new ImageIcon(getClass().getResource("/images/noTransitableEzq2.jpg"));
        		break;
        case 3:  imagen = new ImageIcon(getClass().getResource("/images/noTransitableEzq3.jpg"));
				break;
        case 4:  imagen = new ImageIcon(getClass().getResource("/images/NoTransitableEzq4.jpg"));
				break;
        case 5:  imagen = new ImageIcon(getClass().getResource("/images/NoTransitableEzq5.jpg"));
				break;
		}
			
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
