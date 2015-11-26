package Principal;

import javax.swing.ImageIcon;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class ExplosionGrafica extends ElementoEnCelda{
	

	protected ImageIcon [] explosion;
	
	/**
	 * Constructor explosion grafica horizontal
	 */
	public ExplosionGrafica(){
		explosion = new ImageIcon[4];
		explosion[0] = new ImageIcon(getClass().getResource("/images/explosion2.jpg"));
	}

	/**
	 * constructor explosion grafica vertical
	 * @param i
	 */
	public ExplosionGrafica(int i) {
		explosion = new ImageIcon[4];
		explosion[0] = new ImageIcon(getClass().getResource("/images/explosion1.jpg"));
	}

	@Override
	public void avanzar(Bomberman b) {}

	@Override
	public void avanzar(Enemigo e) {}

	@Override
	public int destruirse() {return 0;	}	

	public ImageIcon getImagen()
	{
		return explosion[0];
	}

}
