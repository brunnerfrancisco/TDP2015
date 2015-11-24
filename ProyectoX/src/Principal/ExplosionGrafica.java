package Principal;

import javax.swing.ImageIcon;

public class ExplosionGrafica extends ElementoEnCelda{
	

	protected ImageIcon [] explosion;
	
	public ExplosionGrafica(){
		explosion = new ImageIcon[4];
		explosion[0] = new ImageIcon(getClass().getResource("/images/explosion2.jpg"));
	}

	public ExplosionGrafica(int i) {
		explosion = new ImageIcon[4];
		explosion[0] = new ImageIcon(getClass().getResource("/images/explosion1.jpg"));
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
		// TODO Auto-generated method stub
		return 0;
	}	

	public ImageIcon getImagen()
	{
		return explosion[0];
	}

}
